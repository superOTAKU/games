package org.otaku.doudizhu

import java.lang.IllegalStateException
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 斗地主游戏
 */
class DouDiZhuGame {
    //所有的牌
    private val cards = CardListCreator.createCards()
    //公开的3张牌
    private var openCards: List<Card>? = null
    //决定谁先抢地主的牌
    private var startVoteCard: Card? = null
    //游戏状态
    private var status = GameStatus.INIT
    //三个玩家
    private val players = ArrayList<Player>()
    //玩家轮次
    private var round = -1
    //选地主投票
    private val votes = HashMap<Int, Vote>()
    //投票次数，轮完一次不能再投，投了3分立刻成为地主
    private var voteTimes = 0

    //发牌，发完牌进入抢地主环节
    fun dealCards() {
        checkStatus(GameStatus.INIT)
        val randomCards = cards.shuffled()
        openCards = randomCards.subList(0, 3)
        val playerCards = randomCards.subList(3, randomCards.size)
        val startVoteCardIdx = ThreadLocalRandom.current().nextInt(0, playerCards.size);
        startVoteCard = playerCards[startVoteCardIdx]
        val cardMap = HashMap<Int, MutableList<Card>>()
        for (i in playerCards.indices) {
            val cardList = cardMap.getOrDefault(i % 17, ArrayList())
            cardList.add(playerCards[i])
        }
        for (i in 0 .. 2) {
            val player = Player(this, i);
            player.init(requireNotNull(cardMap[i]).toList())
            if (i == startVoteCardIdx % 17) {
                round = i
            }
            players.add(player)
        }
        status = GameStatus.VOTING
    }

    fun getStartVoteCard(): Card? {
        return startVoteCard
    }

    fun getOpenCards(): List<Card>? {
        return openCards
    }

    //投票
    fun voteForLandlord(playerNo: Int, vote: Vote) {
        checkStatus(GameStatus.VOTING)
        checkRound(playerNo)
        voteTimes += 1
        votes[playerNo] = vote
        if (vote == Vote.THREE) {
            setLandlord(playerNo)
            status = GameStatus.PLAYING
            return
        }
        if (voteTimes != 3) {
            nextRound()
            return
        }
        val entry = votes.maxByOrNull { it.value.weight }
        if (entry == null) {
            status = GameStatus.CANCELLED
            return
        }
        setLandlord(entry.key)
        status = GameStatus.PLAYING
    }

    /**
     * 出牌
     * @param playerNo 第几个玩家
     * @param cardIdxList 出那几张牌
     */
    fun playCard(playerNo: Int, cardIdxList: List<Int>) {

    }

    private fun checkRound(playerNo: Int) {
        if (round != playerNo) {
            throw IllegalStateException("playerNo is $playerNo, current round is $round")
        }
    }

    private fun checkStatus(requiredStatus: GameStatus) {
        if (requiredStatus != status) {
            throw IllegalStateException("[$requiredStatus] required, but $status")
        }
    }

    private fun nextRound() {
        round = (round + 1) % 3
    }

    private fun setLandlord(landlordIdx: Int) {
        for (i in players.indices) {
            if (i == landlordIdx) {
                players[i].setRole(PlayerRole.LANDLORD)
            } else {
                players[i].setRole(PlayerRole.FARMER)
            }
        }

    }

}

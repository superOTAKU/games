package org.otaku.doudizhu

/**
 * 斗地主游戏
 */
class DouDiZhuGame {
    //所有的牌
    private val cards = CardListCreator.createCards()
    //公开的3张牌
    private val openCards = ArrayList<Card>()
    //决定谁先抢地主的牌
    private var startVoteCard: Card? = null
    //游戏状态
    private var status = GameStatus.INIT
    //三个玩家
    private val players = ArrayList<Player>()
    //玩家轮次
    private var round = -1
    //选地主投票
    private val votes = HashMap<Int, Int>()

    //发牌，发完牌进入抢地主环节
    fun dealCards() {

    }

    //投票
    fun voteForLandlord(playerNo: Int, vote: Vote) {

    }

    //发牌

}

package org.otaku.doudizhu

import org.otaku.doudizhu.playcard.PlayCardFactory
import java.lang.IllegalStateException

/**
 * 玩家，斗地主和平民没必要区分子类，因为功能基本是一样的
 */
class Player(val game: DouDiZhuGame, val playerNo: Int) {
    //自己的牌
    private lateinit var cards: MutableList<Card>
    //玩家角色
    private lateinit var role: PlayerRole

    private var win = false

    internal fun init(cards: List<Card>) {
        this.cards = ArrayList(cards)
    }

    internal fun setRole(role: PlayerRole) {
        this.role = role
    }

    internal fun playCard(cardIdxList: List<Int>) {
        require(cardIdxList.isNotEmpty() && cardIdxList.all { it >= 0 && it < cards.size })
        val playCards = HashSet<Card>()
        for (idx in cardIdxList) {
            playCards.add(cards[idx])
        }
        val playCard = PlayCardFactory.DEFAULT.createPlayCard(playCards)
        //判断牌能不能打过
        if (!game.canPlay(playCard)) {
            throw IllegalStateException("your card can't play!")
        }
        cards.removeAll(playCards)
        if (cards.isEmpty()) {
            win = true
        }
    }

    //方便展示牌
    fun getCards(): List<Card> {
        return cards
    }

    fun isWin(): Boolean {
        return win
    }

    fun getRole(): PlayerRole {
        return role
    }

}

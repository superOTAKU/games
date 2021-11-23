package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.Card
import org.otaku.doudizhu.PlayCard

/**
 * 对子，A和2也能参与，只有大小王不能参与
 */
class Pair(cards: Set<Card>): PlayCard(1, cards) {

    init {
        //只有两张牌，标志相同
        require(cards.size == 2 && cards.groupBy { it.symbol }.size == 2)
    }

    override fun isSameCardType(other: PlayCard): Boolean {
        return javaClass == other.javaClass
    }

    override fun sameCardTypeCompare(other: PlayCard): Int {
        val otherP = other as Pair
        return cards.first().symbol.weight - otherP.cards.first().symbol.weight
    }
}

package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.Card
import org.otaku.doudizhu.PlayCard

/**
 * 单张牌型
 */
class Single(cards: Set<Card>): PlayCard(1, cards) {

    init {
        require(cards.size == 1)
    }

    override fun isSameCardType(other: PlayCard): Boolean {
        return javaClass == other.javaClass
    }

    override fun sameCardTypeCompare(other: PlayCard): Int {
        val otherSingle = other as Single
        return cards.first().symbol.weight - otherSingle.cards.first().symbol.weight
    }

}

package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.Card
import org.otaku.doudizhu.PlayCard

/**
 * 单张牌型
 */
class Single(private val card: Card): PlayCard(1, setOf(card)) {

    override fun isSameCardType(other: PlayCard): Boolean {
        return javaClass == other.javaClass
    }

    override fun sameCardTypeCompare(other: PlayCard): Int {
        val otherSingle = other as Single
        return card.symbol.weight - otherSingle.card.symbol.weight
    }

}

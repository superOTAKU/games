package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.Card
import org.otaku.doudizhu.PlayCard

/**
 * 单张牌型
 */
class SinglePlay(private val card: Card): PlayCard(1, listOf(card)) {

    override fun isSameCardType(other: PlayCard): Boolean {
        return javaClass == other.javaClass
    }

    override fun sameCardTypeCompare(other: PlayCard): Int {
        val otherSingle = other as SinglePlay
        return card.symbol.weight - otherSingle.card.symbol.weight
    }

}
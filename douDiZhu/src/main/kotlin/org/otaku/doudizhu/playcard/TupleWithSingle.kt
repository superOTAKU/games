package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.Card
import org.otaku.doudizhu.PlayCard

/**
 * 三带一，和飞机不一样，包括 AAA 222
 */
class TupleWithSingle(cards: Set<Card>): PlayCard(1, cards) {
    private var weight = 0

    init {
        val symbolToCards = cards.groupBy { it.symbol }
        require(symbolToCards.size == 2)
        val singles = symbolToCards.filter { it.value.size == 1 }
        val tuples = symbolToCards.filter { it.value.size == 3 }
        require(singles.size == 1 && tuples.size == 1)
        weight = tuples.keys.first().weight
    }

    override fun isSameCardType(other: PlayCard): Boolean {
        return javaClass == other.javaClass
    }

    override fun sameCardTypeCompare(other: PlayCard): Int {
        val otherT = other as TupleWithSingle
        return weight - otherT.weight
    }
}

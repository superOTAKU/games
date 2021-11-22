package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.Card
import org.otaku.doudizhu.PlayCard

//三带一对，和飞机不一样，包括AAA 222
class TupleWithPair(cards: Set<Card>): PlayCard(1, cards) {
    private var weight = 0
    init {
        val symbolToCards = cards.groupBy { it.symbol }
        assert(symbolToCards.size == 2)
        val tuples = symbolToCards.filter { it.value.size == 3 }
        val pairs = symbolToCards.filter { it.value.size == 2 }
        assert(tuples.size == 1 && pairs.size == 1)
        weight = tuples.keys.first().weight
    }

    override fun isSameCardType(other: PlayCard): Boolean {
        return javaClass == other.javaClass
    }

    override fun sameCardTypeCompare(other: PlayCard): Int {
        val otherT = other as TupleWithPair
        return weight - otherT.weight
    }
}

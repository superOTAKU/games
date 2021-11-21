package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.Card
import org.otaku.doudizhu.PlayCard

//三带一对
class TupleWithPairPlay(cards: Set<Card>): PlayCard(1, cards) {
    private var weight = 0
    private var tupleCount = 0
    init {
        val symbolToCards = cards.groupBy { it.symbol }
        assert(symbolToCards.isNotEmpty())
        val tuples = symbolToCards.filter { it.value.size == 3 }
        val pairs = symbolToCards.filter { it.value.size == 2 }
        assert(tuples.size == pairs.size
                && symbolToCards.size == tuples.size + pairs.size)
        weight = tuples.keys.maxOf { it.weight }
        tupleCount = tuples.size
    }

    override fun isSameCardType(other: PlayCard): Boolean {
        if (javaClass != other.javaClass) {
            return false
        }
        val otherT = other as TupleWithPairPlay
        return tupleCount == otherT.tupleCount
    }

    override fun sameCardTypeCompare(other: PlayCard): Int {
        val otherT = other as TupleWithPairPlay
        return weight - otherT.weight
    }
}
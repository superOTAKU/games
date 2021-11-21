package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.Card
import org.otaku.doudizhu.CardSymbol
import org.otaku.doudizhu.PlayCard
import java.lang.IllegalStateException

/**
 * 三带一
 */
class TupleWithSinglePlay(cards: Set<Card>): PlayCard(1, cards) {
    private var weight = 0
    private var tupleCount = 0

    init {
        val tuples = HashMap<CardSymbol, MutableSet<Card>>()
        for (card in cards) {
            val set = tuples.computeIfAbsent(card.symbol) {HashSet()}
            if (set.size == 3) {
                continue
            }
            set.add(card)
        }
        assert(tuples.isNotEmpty())
        assert(tuples.values.all { it.size == 3 })
        val singleCards = HashSet(cards)
        for (c in tuples.values) {
            singleCards.removeAll(c)
        }
        assert(tuples.size == singleCards.size)
        if (tuples.size == 1 && singleCards.size == 1) {
            if (tuples.iterator().next().key == singleCards.iterator().next().symbol) {
                throw IllegalStateException("a Bomb, not a tuple with single")
            }
        }
        weight = tuples.maxOf { (k, _) -> k.weight }
        tupleCount = tuples.size
    }

    override fun isSameCardType(other: PlayCard): Boolean {
        if (javaClass != other.javaClass) {
            return false
        }
        val otherT = other as TupleWithSinglePlay
        return tupleCount == otherT.tupleCount
    }

    override fun sameCardTypeCompare(other: PlayCard): Int {
        val otherT = other as TupleWithSinglePlay
        return weight - otherT.weight
    }
}
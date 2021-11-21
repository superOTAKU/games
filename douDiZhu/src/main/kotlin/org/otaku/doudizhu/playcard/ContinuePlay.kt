package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.Card
import org.otaku.doudizhu.CardSymbol
import org.otaku.doudizhu.PlayCard
import java.util.*

//连队或者连续的三个
abstract class ContinuePlay(cards: Set<Card>, continueCount: Int): PlayCard(1, cards) {
    private var count = 0
    private var weight = 0
    init {
        assert(cards.isNotEmpty())
        val symbolToCards = TreeMap<CardSymbol, MutableList<Card>>(compareBy { it.number })
        cards.groupByTo(symbolToCards) { it.symbol }
        assert(symbolToCards.all { it.value.size == continueCount })
        var lastNumber: Int? = null
        for (symbol in symbolToCards.keys) {
            if (lastNumber == null) {
                lastNumber = symbol.number
                continue
            }
            assert(symbol.number - lastNumber == 1)
            lastNumber = symbol.number
        }
        count = symbolToCards.size
        weight = symbolToCards.keys.maxOf { it.number }
    }

    override fun isSameCardType(other: PlayCard): Boolean {
        if (javaClass != other.javaClass) {
            return false
        }
        val otherCP = other as ContinuePlay
        return count == otherCP.count
    }

    override fun sameCardTypeCompare(other: PlayCard): Int {
        val otherCP = other as ContinuePlay
        return weight - otherCP.weight
    }
}
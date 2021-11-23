package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.Card
import org.otaku.doudizhu.CardSymbol
import org.otaku.doudizhu.PlayCard
import java.util.*

//飞机带大翼
class AirPlaneWithPair(cards: Set<Card>): PlayCard(1, cards) {
    private var weight = 0
    private var count = 0

    init {
        require(cards.none { it.symbol.number < 0 })
        val symbolToCards = TreeMap<CardSymbol, MutableList<Card>>(compareBy { it.number })
        cards.groupByTo(symbolToCards) { it.symbol }
        val tuples = symbolToCards.filter { it.value.size == 3 }
        val singles = symbolToCards.filter { it.value.size == 2 }
        require(symbolToCards.size >= 4 && tuples.size == singles.size && symbolToCards.size == tuples.size + singles.size)
        //是否按顺序
        require(PlayCardUtil.isSymbolsOrder(tuples.keys))
        count = tuples.size
        weight = tuples.keys.maxOf { it.number }
    }

    override fun isSameCardType(other: PlayCard): Boolean {
        if (javaClass != other.javaClass) {
            return false
        }
        val otherObj = other as AirPlaneWithPair
        return count == otherObj.count
    }

    override fun sameCardTypeCompare(other: PlayCard): Int {
        val otherObj = other as AirPlaneWithPair
        return weight - otherObj.weight
    }
}

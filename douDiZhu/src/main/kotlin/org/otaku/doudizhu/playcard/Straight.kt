package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.Card
import org.otaku.doudizhu.CardSymbol
import org.otaku.doudizhu.PlayCard
import java.util.*

/**
 * 順子
 */
class Straight(cards: Set<Card>):PlayCard(1, cards) {
    private var count = 0
    private var weight = 0

    init {
        require(cards.none {it.symbol.number < 0})
        require(cards.size >= 5)
        val symbolToCars = TreeMap<CardSymbol, MutableList<Card>>(compareBy{it.number})
        cards.groupByTo(symbolToCars) {it.symbol}
        require(symbolToCars.all { it.value.size == 1 })
        PlayCardUtil.isSymbolsOrder(symbolToCars.keys)
        count = cards.size
        weight = symbolToCars.keys.last().number
    }

    override fun isSameCardType(other: PlayCard): Boolean {
        if (javaClass != other.javaClass) {
            return false
        }
        val otherP = other as Straight
        return count == otherP.count
    }

    override fun sameCardTypeCompare(other: PlayCard): Int {
        val otherP = other as Straight
        return weight - otherP.weight
    }
}

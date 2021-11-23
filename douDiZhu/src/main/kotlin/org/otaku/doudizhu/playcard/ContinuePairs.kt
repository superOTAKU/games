package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.Card
import org.otaku.doudizhu.CardSymbol
import org.otaku.doudizhu.PlayCard
import java.util.*

//连队，最少3张，从3开始
class ContinuePairs(cards: Set<Card>): PlayCard(1, cards) {
    private var count = 0
    private var weight = 0
    init {
        //不能包含2，大小王
        require(cards.none { it.symbol.number < 0 })
        val symbolToCards = TreeMap<CardSymbol, MutableList<Card>>(compareBy { it.number })
        cards.groupByTo(symbolToCards) { it.symbol }
        //连队至少3对
        require(symbolToCards.size >= 3 && symbolToCards.values.all { it.size == 2 })
        //连队必须按顺序
        require(PlayCardUtil.isSymbolsOrder(symbolToCards.keys))
        count = symbolToCards.size
        weight = symbolToCards.keys.maxOf { it.number }
    }

    override fun isSameCardType(other: PlayCard): Boolean {
        if (javaClass != other.javaClass) {
            return false
        }
        val otherCP = other as ContinuePairs
        return count == otherCP.count
    }

    override fun sameCardTypeCompare(other: PlayCard): Int {
        val otherCP = other as ContinuePairs
        return weight - otherCP.weight
    }
}

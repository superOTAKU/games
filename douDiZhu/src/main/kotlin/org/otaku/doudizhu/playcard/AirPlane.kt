package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.Card
import org.otaku.doudizhu.CardSymbol
import org.otaku.doudizhu.PlayCard
import java.util.*

//飞机不带翅膀，和连队规则基本是一样的
class AirPlane(cards: Set<Card>): PlayCard(1, cards) {
    private var count = 0
    private var weight = 0
    init {
        //不能包含2，大小王
        assert(cards.none { it.symbol.number < 0 })
        val symbolToCards = TreeMap<CardSymbol, MutableList<Card>>(compareBy { it.number })
        cards.groupByTo(symbolToCards) { it.symbol }
        assert(symbolToCards.size >= 2 && symbolToCards.values.all { it.size == 3 })
        assert(PlayCardUtil.isSymbolsOrder(symbolToCards.keys))
        count = symbolToCards.size
        weight = symbolToCards.keys.maxOf { it.number }
    }

    override fun isSameCardType(other: PlayCard): Boolean {
        if (javaClass != other.javaClass) {
            return false
        }
        val otherObj = other as AirPlane
        return count == otherObj.count
    }

    override fun sameCardTypeCompare(other: PlayCard): Int {
        val otherCP = other as AirPlane
        return weight - otherCP.weight
    }
}

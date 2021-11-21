package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.Card
import org.otaku.doudizhu.PlayCard

//飞机，不带单张，不带对子
class TuplePlay(cards: List<Card>): PlayCard(1, cards) {
    //最大的牌权重
    private var weight = 0
    //三张的对数
    private var tupleCount = 0
    init {
        val symbolToCards = cards.groupBy { it.symbol }
        for ((k, v) in symbolToCards) {
            //三张
            assert(v.size == 3)
            //三张的花色不一样
            assert(v.toSet().size == 3)
            if (weight < k.weight) {
                weight = k.weight
            }
        }
        tupleCount = symbolToCards.size
    }

    override fun isSameCardType(other: PlayCard): Boolean {
        if (javaClass != other.javaClass) {
            return false
        }
        val otherT = other as TuplePlay
        return tupleCount == otherT.tupleCount
    }

    override fun sameCardTypeCompare(other: PlayCard): Int {
        val otherT = other as TuplePlay
        return weight - otherT.weight
    }

}
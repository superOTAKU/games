package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.Card
import org.otaku.doudizhu.PlayCard

//对子
class PairPlay(cards: List<Card>): PlayCard(1, cards) {

    init {
        assert(cards.size == 2
                && cards[0].symbol == cards[1].symbol
                && cards[0].suit != cards[1].suit
        )
    }

    override fun isSameCardType(other: PlayCard): Boolean {
        return javaClass == other.javaClass
    }

    override fun sameCardTypeCompare(other: PlayCard): Int {
        val otherP = other as PairPlay
        return cards[0].symbol.weight - otherP.cards[0].symbol.weight
    }
}
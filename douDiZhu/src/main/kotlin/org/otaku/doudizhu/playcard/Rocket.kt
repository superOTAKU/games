package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.Card
import org.otaku.doudizhu.PlayCard

class Rocket(cards: Set<Card>):PlayCard(3, cards) {
    init {
        require(cards.size == 2 && cards.all { it.symbol.isJoker() })
    }

    override fun isSameCardType(other: PlayCard): Boolean {
        return javaClass == other.javaClass
    }

    //不可能有兩個火箭，所以火箭就是最大的
    override fun sameCardTypeCompare(other: PlayCard): Int {
        return 1
    }
}

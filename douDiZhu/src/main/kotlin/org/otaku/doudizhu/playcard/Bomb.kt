package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.Card
import org.otaku.doudizhu.PlayCard

class Bomb(cards: Set<Card>): PlayCard(2, cards) {
    private var weight = 0

    init {
        assert(cards.size == 4)
        assert(cards.map { it.symbol }.toSet().size == 1)
        weight = cards.first().symbol.weight
    }

    override fun isSameCardType(other: PlayCard): Boolean {
        return javaClass == other.javaClass
    }

    override fun sameCardTypeCompare(other: PlayCard): Int {
        val otherP = other as Bomb
        return weight - otherP.weight
    }
}

package org.otaku.doudizhu

import java.lang.IllegalArgumentException

//一次出牌，需要整理出所有的牌型，实现牌型
abstract class PlayCard(val priority: Int, val cards: Set<Card>): Comparable<PlayCard> {

    //是否可比，优先级不同，可以比；牌型相同，可以比；其他情况不能比
    fun isComparableTo(other: PlayCard): Boolean {
        if (priority != other.priority) {
            return true
        }
        if (javaClass != other.javaClass) {
            return false
        }
        return isSameCardType(other)
    }

    //是否相同的牌型
    abstract fun isSameCardType(other: PlayCard): Boolean

    //相同牌型之间的比较
    abstract fun sameCardTypeCompare(other: PlayCard): Int

    final override fun compareTo(other: PlayCard): Int {
        if (!isComparableTo(other)) {
            throw IllegalArgumentException("not comparable")
        }
        if (priority != other.priority) {
            return priority - other.priority
        }
        return sameCardTypeCompare(other)
    }

}
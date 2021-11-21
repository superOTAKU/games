package org.otaku.doudizhu

enum class Vote(val weight: Int) {
    GIVE_UP(0),
    ONE(1),
    TWO(2),
    THREE(3);
}

object VoteComparator : Comparator<Vote> {

    override fun compare(v1: Vote?, v2: Vote?): Int {
        requireNotNull(v1)
        requireNotNull(v2)
        return v1.weight - v2.weight
    }

}
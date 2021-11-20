package org.otaku.doudizhu

/**
 * 牌的种类，但不包括花色
 * @param symbol 代表这个牌的标志
 * @param weight 权重
 */
enum class CardType(val symbol: String, val weight: Int) {
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("J", 11),
    QUEEN("Q", 12),
    KING("K", 13),
    A("A", 14),
    TWO("2", 15),
    LITTLE_JOKER("LittleJoker", 16),
    BIG_JOKER("BigJoker", 17);

    fun isJoker(): Boolean {
        return this == LITTLE_JOKER || this == BIG_JOKER
    }
}
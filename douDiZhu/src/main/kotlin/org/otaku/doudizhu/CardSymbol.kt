package org.otaku.doudizhu

/**
 * 牌的种类，但不包括花色
 * @param symbol 代表这个牌的标志
 * @param weight 权重
 * @param number 组成顺子时，代表的次序
 */
enum class CardSymbol(val symbol: String, val weight: Int, val number: Int) {
    A("A", 14, 1),
    TWO("2", 15, 2),
    THREE("3", 3, 3),
    FOUR("4", 4, 4),
    FIVE("5", 5, 5),
    SIX("6", 6, 6),
    SEVEN("7", 7, 7),
    EIGHT("8", 8, 8),
    NINE("9", 9, 9),
    TEN("10", 10, 10),
    JACK("J", 11, 11),
    QUEEN("Q", 12, 12),
    KING("K", 13, 13),
    LITTLE_JOKER("LittleJoker", 16, -1),
    BIG_JOKER("BigJoker", 17, -1);

    fun isJoker(): Boolean {
        return this == LITTLE_JOKER || this == BIG_JOKER
    }
}
package org.otaku.doudizhu

object CardListCreator {
    private val cardList = mutableListOf<Card>()

    init {
        for (cardSuit in CardSuit.values()) {
            if (cardSuit == CardSuit.NONE) {
                continue
            }
            for (cardType in CardType.values()) {
                if (cardType.isJoker()) {
                    continue
                }
                cardList.add(Card(cardType, cardSuit))
            }
        }
        cardList.add(Card(CardType.LITTLE_JOKER, CardSuit.NONE))
        cardList.add(Card(CardType.BIG_JOKER, CardSuit.NONE))
    }

    fun createCards(): List<Card> {
        return ArrayList(cardList)
    }

}

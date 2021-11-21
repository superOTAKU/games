package org.otaku.doudizhu

object CardListCreator {
    private val cardList = mutableListOf<Card>()

    init {
        for (cardSuit in CardSuit.values()) {
            if (cardSuit == CardSuit.NONE) {
                continue
            }
            for (cardType in CardSymbol.values()) {
                if (cardType.isJoker()) {
                    continue
                }
                cardList.add(Card(cardType, cardSuit))
            }
        }
        cardList.add(Card(CardSymbol.LITTLE_JOKER, CardSuit.NONE))
        cardList.add(Card(CardSymbol.BIG_JOKER, CardSuit.NONE))
    }

    fun createCards(): List<Card> {
        return ArrayList(cardList)
    }

}

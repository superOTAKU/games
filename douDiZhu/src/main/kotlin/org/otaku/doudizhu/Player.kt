package org.otaku.doudizhu

/**
 * 玩家，斗地主和平民没必要区分子类，因为功能基本是一样的
 */
class Player(game: DouDiZhuGame, val playerNo: Int) {
    //自己的牌
    private lateinit var cards: MutableList<Card>
    //玩家角色
    private lateinit var role: PlayerRole

    internal fun init(cards: List<Card>) {
        this.cards = ArrayList(cards)
    }

    internal fun setRole(role: PlayerRole) {
        this.role = role
    }

    //方便展示牌
    fun getCards(): List<Card> {
        return cards
    }

}

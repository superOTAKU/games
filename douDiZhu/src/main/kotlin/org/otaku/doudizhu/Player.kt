package org.otaku.doudizhu

/**
 * 玩家，斗地主和平民没必要区分子类，因为功能基本是一样的
 */
class Player(game: DouDiZhuGame) {
    //自己的牌
    private lateinit var cards: List<Card>
    //玩家角色
    private lateinit var role: PlayerRole
    //是否轮到自己
    private var myRound: Boolean = false
}
package org.otaku.doudizhu

/**
 * 斗地主游戏
 */
class DouDiZhuGame {
    //所有的牌
    private val cards = CardListCreator.createCards()
    //公开的3张牌
    private val openCards = ArrayList<Card>()
    //决定谁先抢地主的牌
    private var startVoteCard: Card? = null
    //游戏状态
    private var status = GameStatus.INIT
    //三个玩家
    private val player1 = Player()
    private val player2 = Player()
    private val player3 = Player()

}

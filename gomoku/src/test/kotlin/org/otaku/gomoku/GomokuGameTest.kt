package org.otaku.gomoku

import org.junit.Test
import kotlin.test.assertEquals

class GomokuGameTest {
    private val game = GomokuGame()

    @Test
    fun gameTest() {
        game.init()
        val player1 = game.getPlayer1()
        val player2 = game.getPlayer2()
        player1.setChessman(5, 5)
        player2.setChessman(10, 0)
        player1.setChessman(6, 6)
        player2.setChessman(11, 0)
        player1.setChessman(7, 7)
        player2.setChessman(0, 0)
        player1.setChessman(8, 8)
        player2.setChessman(2, 5)
        player1.setChessman(9, 9)
        assertEquals(GameStatus.PLAYER1_WIN, game.getStatus())
    }
}
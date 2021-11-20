package org.otaku.gomoku

class Player(val game: GomokuGame, val player1: Boolean) {
    private lateinit var chessman: Chessman

    fun init(chessman: Chessman) {
        this.chessman = chessman
    }

    //设置棋子
    fun setChessman(row: Int, col: Int) {
        if (player1) {
            game.setPlayer1Chessman(row, col)
        } else {
            game.setPlayer2Chessman(row, col)
        }
    }

    fun getChessman(): Chessman {
        return chessman
    }

}
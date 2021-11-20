package org.otaku.gomoku

/**
 * 五子棋游戏
 */
class GomokuGame {
    //棋盘
    private val chessBoard = ChessBoard()
    //棋手1
    private val player1 = Player(this, true)
    //棋手2
    private val player2 = Player(this, false)
    //游戏状态
    private var status = GameStatus.INIT

    fun init() {
        checkStatus(GameStatus.INIT)
        player1.init(Chessman.BLACK)
        player2.init(Chessman.WHITE)
        status = GameStatus.PLAYER1_ROUND
    }

    fun getStatus(): GameStatus {
        return status
    }

    fun getPlayer1(): Player {
        return player1
    }

    fun getPlayer2(): Player {
        return player2
    }

    fun setPlayer1Chessman(row: Int, col: Int) {
        checkStatus(GameStatus.PLAYER1_ROUND)
        chessBoard.setChessman(row, col, player1.getChessman())
        if (chessBoard.getWinChessman() != null) {
            status = GameStatus.PLAYER1_WIN
            return
        }
        if (chessBoard.isFull()) {
            status = GameStatus.WIN_WIN
            return
        }
        status = GameStatus.PLAYER2_ROUND
    }

    fun setPlayer2Chessman(row: Int, col: Int) {
        checkStatus(GameStatus.PLAYER2_ROUND)
        chessBoard.setChessman(row, col, player2.getChessman())
        if (chessBoard.getWinChessman() != null) {
            status = GameStatus.PLAYER2_ROUND
            return
        }
        if (chessBoard.isFull()) {
            status = GameStatus.WIN_WIN
            return
        }
        status = GameStatus.PLAYER1_ROUND
    }

    private fun checkStatus(requiredStatus: GameStatus) {
        if (status != requiredStatus) {
            throw IllegalStateException("require status[$requiredStatus] but status[$status]")
        }
    }

}
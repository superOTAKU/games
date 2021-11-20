package org.otaku.gomoku

enum class GameStatus {
    //还没开始
    INIT,
    //轮到player1
    PLAYER1_ROUND,
    //轮到player2
    PLAYER2_ROUND,
    //player1赢了
    PLAYER1_WIN,
    //player2赢了
    PLAYER2_WIN,
    //平局
    WIN_WIN
}
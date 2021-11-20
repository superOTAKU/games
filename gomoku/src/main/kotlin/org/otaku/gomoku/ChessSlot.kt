package org.otaku.gomoku

/**
 * 格子
 */
class ChessSlot(val row: Int, val col: Int) {
    private var chessman: Chessman? = null

    fun setChessman(chessman: Chessman) {
        if (this.chessman != null) {
            throw IllegalStateException("slot[$row,$col] already has chessman ${this.chessman}")
        }
        this.chessman = chessman
    }

    fun getChessman(): Chessman? {
        return chessman
    }

    fun isIdle(): Boolean {
        return chessman == null
    }
}
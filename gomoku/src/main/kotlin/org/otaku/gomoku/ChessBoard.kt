package org.otaku.gomoku

//棋盘
class ChessBoard {

    companion object {
        const val TABLE_SIZE = 15
    }

    //数组通过lambda初始化
    private val table = Array(TABLE_SIZE) {
            i -> Array(TABLE_SIZE) {
                j -> ChessSlot(i, j)
            }
    }

    //记录赢的玩家
    private var winChessman: Chessman? = null

    private var full: Boolean = false

    fun isFull(): Boolean {
        if (full) {
            return full
        }
        for (i in 0 .. TABLE_SIZE - 1) {
            for (j in 0 .. TABLE_SIZE - 1) {
                if (table[i][j].isIdle()) {
                    return false
                }
            }
        }
        full = true
        return full
    }

    private fun checkIndexRange(index: Int) {
        if (index in 0 .. TABLE_SIZE - 1) {
            return
        }
        throw IllegalArgumentException("index[$index] illegal")
    }

    fun setChessman(row: Int, col: Int, chessman: Chessman) {
        checkIndexRange(row)
        checkIndexRange(col)
        val slot = table[row][col]
        if (!slot.isIdle()) {
            throw IllegalStateException("slot[$row,$col] already has chessman")
        }
        slot.setChessman(chessman)
        //检查状态，记录赢的花色
        if (isWin(row, col)) {
            winChessman = chessman
        }
    }

    fun getWinChessman(): Chessman? {
        return winChessman
    }

    //从最后一步开始算，判断是否造成胜负关系
    private fun isWin(row: Int, col: Int): Boolean {
        //垂直方向
        for (i in col - 4 .. col) {
            if (i < 0 || i + 4 > TABLE_SIZE) {
                continue
            }
            if (continue5ChessmanCol(row, i) != null) {
                return true
            }
        }
        //平行方向
        for (i in row - 4 .. row) {
            if (i < 0 || i + 4 > TABLE_SIZE) {
                continue
            }
            if (continue5ChessmanRow(i, col) != null) {
                return true
            }
        }
        //左上到右下
        for (i in 0 .. 4) {
            val leftTopRow = row - i
            val leftTopCol = col - i
            val rightBottomRow = leftTopRow + 4
            val rightBottomCol = leftTopCol + 4
            if (leftTopRow < 0 || leftTopCol < 0
                || rightBottomRow > TABLE_SIZE || rightBottomCol > TABLE_SIZE) {
                continue
            }
            if (continue5LeftTopToRightBottom(leftTopRow, leftTopCol) != null) {
                return true
            }
        }
        //右上到左下
        for (i in 0 .. 4) {
            val rightTopRow = row - i
            val rightTopCol = col + i
            val leftBottomRow = rightTopRow + 4
            val leftBottomCol = rightTopCol - 4
            if (rightTopRow < 0 || leftBottomRow > TABLE_SIZE
                || rightTopCol > TABLE_SIZE || leftBottomCol < 0) {
                continue
            }
            if (continue5RightTopToLeftBottom(rightTopRow, rightTopCol) != null) {
                return true
            }
        }
        return false
    }

    private fun continue5ChessmanCol(row: Int, colStart: Int): Chessman? {
        val firstChessman = table[row][colStart].getChessman() ?: return null
        for (i in colStart + 1 .. colStart + 4) {
            if (firstChessman != table[row][i].getChessman()) {
                return null
            }
        }
        return firstChessman
    }

    private fun continue5ChessmanRow(rowStart: Int, col: Int): Chessman? {
        val firstChessman = table[rowStart][col].getChessman() ?: return null
        for (i in rowStart + 1 .. rowStart + 4) {
            if (firstChessman != table[i][col].getChessman()) {
                return null
            }
        }
        return firstChessman
    }

    private fun continue5LeftTopToRightBottom(row: Int, col: Int): Chessman? {
        val firstChessman = table[row][col].getChessman() ?: return null
        for (i in 1 .. 4) {
            if (firstChessman != table[i + row][i + col].getChessman()) {
                return null
            }
        }
        return firstChessman
    }

    private fun continue5RightTopToLeftBottom(row: Int, col: Int): Chessman? {
        val firstChessman = table[row][col].getChessman() ?: return null
        for (i in 1 .. 4) {
            if (firstChessman != table[i + row][col - i].getChessman()) {
                return null
            }
        }
        return firstChessman
    }

}
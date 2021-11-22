package org.otaku.doudizhu.playcard

import org.otaku.doudizhu.CardSymbol

object PlayCardUtil {

    fun isSymbolsOrder(symbols: Iterable<CardSymbol>): Boolean {
        var lastSymbol: CardSymbol? = null
        for (symbol in symbols) {
            if (lastSymbol == null) {
                lastSymbol = symbol
            }
            if (symbol.number - lastSymbol.number != 1) {
                return false
            }
            lastSymbol = symbol
        }
        return true
    }

}

package org.otaku.doudizhu

enum class GameStatus {
    //等待发牌
    INIT,
    //发完牌，竞选地主
    VOTING,
    //打牌
    PLAYING,
    //地主赢了
    LANDLORD_WIN,
    //农民赢了
    FARMER_WIN,
    //没人相当地主，流局
    CANCELLED
}
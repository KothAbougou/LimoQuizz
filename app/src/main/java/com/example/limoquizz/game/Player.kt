package com.example.limoquizz.game

import java.io.Serializable

data class Player(
    private var pseudo: String,
    private var limcoins: Int = 500
): Serializable {

    var finalScore: Int = 0
    var finalOutOff: Int = 0

    fun getPseudo(): String{
        return this.pseudo
    }

    fun getLimcoins(): Int{
        return this.limcoins
    }

    fun addCoins(lmc: Int)
    {
        this.limcoins += lmc
    }

    fun removeCoins(lmc: Int)
    {
        this.limcoins -= lmc
    }
}
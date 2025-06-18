package com.example.krypto.model

import com.google.gson.annotations.SerializedName

data class Krypto (
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    @SerializedName("current_price") val currentPrice: Double,
    @SerializedName("market_cap") val marketCap: Long,
    @SerializedName("high_24h") val high24h: Double,
    @SerializedName("low_24h") val low24h: Double

)
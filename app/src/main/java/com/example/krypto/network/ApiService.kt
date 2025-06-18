package com.example.krypto.network

import com.example.krypto.model.Krypto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{
    @GET("coins/markets")
    suspend fun getMarketData(
        @Query("vs_currency") vsCurrency: String,
        @Query("order") order: String = "market_cap_desc",
        @Query("per_page") perPage: Int = 20,
        @Query("page") page: Int = 1,
        @Query("sparkline") sparkline: Boolean = false
    ): List<Krypto>


}


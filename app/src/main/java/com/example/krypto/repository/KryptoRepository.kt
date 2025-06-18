package com.example.krypto.repository

import com.example.krypto.model.Krypto
import com.example.krypto.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class KryptoRepository {
    suspend fun getKryptoList(vsCurrency: String): List<Krypto> = withContext(Dispatchers.IO) {
        RetrofitInstance.api.getMarketData(vsCurrency)
    }

    suspend fun getKryptoById(id: String, vsCurrency: String): Krypto? = withContext(Dispatchers.IO) {
        getKryptoList(vsCurrency).find { it.id == id }
    }
}
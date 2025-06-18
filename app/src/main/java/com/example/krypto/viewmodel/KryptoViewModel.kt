package com.example.krypto.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.krypto.model.Krypto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.krypto.repository.KryptoRepository

class KryptoViewModel : ViewModel() {
    private val repository = KryptoRepository()

    private val _kryptoList = MutableStateFlow<List<Krypto>>(emptyList())
    val kryptoList: StateFlow<List<Krypto>> = _kryptoList


    fun fetchKryptoList(vsCurrency: String = "usd") {
        viewModelScope.launch {
            try{
                val kryptoList = repository.getKryptoList(vsCurrency)
                _kryptoList.value = kryptoList
            } catch (e: Exception) {
                println("Error fetching krypto list: ${e.message}")


            }
            finally {
                println("Finally block executed")

            }

        }
    }

    fun getCoinDetails(id: String, vsCurrency: String = "usd"):StateFlow<Krypto?>{
        val coinState = MutableStateFlow<Krypto?>(null)
        viewModelScope.launch {
            val result = repository.getKryptoById(id, vsCurrency)
            coinState.value = result

        }
        return coinState

    }

}






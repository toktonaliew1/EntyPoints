package com.example.entypoints.repository

import androidx.lifecycle.liveData

import com.example.android4hw1.data.remote.apiservices.CoinsApiService
import com.example.entypoints.Either
import kotlinx.coroutines.Dispatchers
import java.io.IOException
import javax.inject.Inject

class CoinsRepository @Inject constructor(private val apiService: CoinsApiService) {

    fun fetchCoins() = liveData (Dispatchers.IO) {
        try {
            emit(Either.Right(apiService.fetchCoins()))
        } catch (ioException: IOException) {
            emit(Either.Left(ioException.localizedMessage))
        }
    }
}
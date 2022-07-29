package com.example.android4hw1.data.remote.apiservices

import com.example.android4hw1.models.CoinsModel
import retrofit2.http.GET

interface CoinsApiService {

    @GET("coins")
    suspend fun fetchCoins(): List<CoinsModel>
}
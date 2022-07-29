package com.example.android4hw1.data.remote.apiservices

import javax.inject.Inject

class NetWorkClient @Inject constructor(
    retrofitClient: RetrofitClient,
    okHttpClient: OkHttp ) {

    private val provideRetrofit = retrofitClient.provideRetrofit(okHttpClient.provideOkHttpClient())

    fun provideCoinsApiService() = provideRetrofit.create(CoinsApiService::class.java)
}
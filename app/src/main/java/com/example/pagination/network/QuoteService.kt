package com.example.pagination.network

import com.example.pagination.Utils.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class QuoteService {

    fun getQuotesApi(): QuoteApi {
        val api = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(QuoteApi::class.java)
        return api
    }
}
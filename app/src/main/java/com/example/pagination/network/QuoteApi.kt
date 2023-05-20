package com.example.pagination.network

import com.example.pagination.model.Quote
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): Quote
}
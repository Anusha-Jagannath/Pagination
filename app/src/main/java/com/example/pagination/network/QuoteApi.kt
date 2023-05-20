package com.example.pagination.network

import com.example.pagination.model.Quote
import retrofit2.http.GET

interface QuoteApi {

    @GET("/quotes")
    suspend fun getQuotes(): Quote
}
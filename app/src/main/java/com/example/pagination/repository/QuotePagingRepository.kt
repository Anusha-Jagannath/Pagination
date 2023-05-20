package com.example.pagination.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.pagination.network.QuoteApi
import com.example.pagination.paging.QuotePagingDataSource

class QuotePagingRepository(private val quoteApi: QuoteApi) {

    fun getQuotes() =
        Pager(
            config = PagingConfig(pageSize = 20, maxSize = 100),
            pagingSourceFactory = { QuotePagingDataSource(quoteApi) }
        ).liveData
}
package com.example.pagination.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.pagination.model.Quote
import com.example.pagination.network.QuoteService
import com.example.pagination.repository.QuotePagingRepository
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    private val _quoteList = MutableLiveData<Quote>()
    val quoteList = _quoteList as LiveData<Quote>

    val repository: QuotePagingRepository

    init {
        val quoteApi = QuoteService().getQuotesApi()
        repository = QuotePagingRepository(quoteApi)
    }

    val data = repository.getQuotes().cachedIn(viewModelScope)
}
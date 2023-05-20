package com.example.pagination.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pagination.model.Quote
import com.example.pagination.network.QuoteService
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {

    private val _quoteList = MutableLiveData<Quote>()
    val quoteList = _quoteList as LiveData<Quote>

    fun getQuotes() {
        viewModelScope.launch {
            val response = QuoteService().getQuotesApi().getQuotes()
            _quoteList.value = response
        }
    }
}
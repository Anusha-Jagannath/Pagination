package com.example.pagination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagination.adapter.QuoteAdapter
import com.example.pagination.databinding.ActivityMainBinding
import com.example.pagination.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: QuoteViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: QuoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(QuoteViewModel::class.java)
        viewModel.getQuotes()

        setupRecyclerView()
        observeChanges()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = QuoteAdapter()
        binding.recyclerView.adapter = adapter

    }

    private fun observeChanges() {
        viewModel.quoteList.observe(this) {
            it?.let {
                adapter.differ.submitList(it.results)
            }
        }
    }
}
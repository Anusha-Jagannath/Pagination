package com.example.pagination.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pagination.R
import com.example.pagination.databinding.ItemQuoteBinding
import com.example.pagination.model.Result

class QuoteAdapter : RecyclerView.Adapter<QuoteViewHolder>() {
    private lateinit var binding: ItemQuoteBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        binding = ItemQuoteBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.item_quote, parent, false)
        )

        return QuoteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        val currentItem = differ.currentList[position]
        holder.bind(currentItem)
    }


    companion object {
        val differUtil = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }

        }
    }

    val differ = AsyncListDiffer(this, differUtil)
}

class QuoteViewHolder(private val binding: ItemQuoteBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(result: Result) {
        binding.title.text = result._id
        binding.subtitle.text = result.author
    }
}
package com.example.afreecatv.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.afreecatv.R
import com.example.afreecatv.databinding.ItemBroadLoadStateBinding

class BroadLoadStateViewHolder(
    parent: ViewGroup
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context)
        .inflate(R.layout.item_broad_load_state, parent, false)
) {
    private val binding = ItemBroadLoadStateBinding.bind(itemView)
    private val progressBar: ProgressBar = binding.pbLoadState

    fun bind(loadState: LoadState) {
        progressBar.isVisible = loadState is LoadState.Loading
    }
}
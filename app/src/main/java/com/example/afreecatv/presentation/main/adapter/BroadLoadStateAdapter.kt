package com.example.afreecatv.presentation.main.adapter

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class BroadLoadStateAdapter : LoadStateAdapter<BroadLoadStateViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ) = BroadLoadStateViewHolder(parent)

    override fun onBindViewHolder(
        holder: BroadLoadStateViewHolder,
        loadState: LoadState
    ) = holder.bind(loadState)
}
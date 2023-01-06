package com.example.afreecatv.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.afreecatv.R
import com.example.afreecatv.databinding.ItemBroadBinding

class BroadAdapter(
    val requestManager: RequestManager
) :
    PagingDataAdapter<BroadModel, BroadAdapter.BroadModelViewHolder>(broadDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BroadModelViewHolder {
        return BroadModelViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_broad,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BroadModelViewHolder, position: Int) {
        holder.bind(getItem(position) ?: return)
    }

    inner class BroadModelViewHolder(private val binding: ItemBroadBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BroadModel) {
            binding.broadItem = item
            binding.requestManager = requestManager
        }
    }

    companion object {

        val broadDiffUtil = object : DiffUtil.ItemCallback<BroadModel>() {
            override fun areItemsTheSame(
                oldItem: BroadModel,
                newItem: BroadModel
            ): Boolean {
                return oldItem.broadNo == newItem.broadNo
            }

            override fun areContentsTheSame(
                oldItem: BroadModel,
                newItem: BroadModel
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}
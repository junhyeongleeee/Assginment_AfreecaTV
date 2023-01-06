package com.example.afreecatv.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.afreecatv.R
import com.example.afreecatv.databinding.ItemBroadBinding
import com.example.afreecatv.presentation.main.model.BroadModel

class BroadAdapter(
    private val onClick: (BroadModel?) -> Unit
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
            binding.root.setOnClickListener {
                onClick(getItem(bindingAdapterPosition))
            }
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
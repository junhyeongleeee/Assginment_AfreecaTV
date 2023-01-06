package com.example.afreecatv.presentation.main.tab

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.afreecatv.R
import com.example.afreecatv.data.category.Category
import com.example.afreecatv.databinding.FragmentBroadBinding
import com.example.afreecatv.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoardFragment : BaseFragment<FragmentBroadBinding>(R.layout.fragment_broad) {

    private val viewModel: BoardViewModel by viewModels()

    override fun initView() {
        binding.viewModel = viewModel
        binding.requestManager = Glide.with(this)
    }

    companion object {

        const val KEY_CATEGORY = "category"

        fun newInstance(category: Category) = BoardFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY_CATEGORY, category)
            }
        }
    }

}
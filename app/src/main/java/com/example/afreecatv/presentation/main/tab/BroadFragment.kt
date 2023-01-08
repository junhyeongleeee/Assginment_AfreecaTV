package com.example.afreecatv.presentation.main.tab

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.afreecatv.R
import com.example.afreecatv.data.category.Category
import com.example.afreecatv.databinding.FragmentBroadBinding
import com.example.afreecatv.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BroadFragment : BaseFragment<FragmentBroadBinding>(R.layout.fragment_broad) {

    private val viewModel: BroadViewModel by viewModels()

    override fun initView() {
        binding.viewModel = viewModel
    }

    companion object {

        const val KEY_CATEGORY = "category"
        const val KEY_BROAD = "broad"

        fun newInstance(category: Category) = BroadFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY_CATEGORY, category)
            }
        }
    }

}
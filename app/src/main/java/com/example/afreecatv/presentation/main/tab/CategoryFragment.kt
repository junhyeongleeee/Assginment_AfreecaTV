package com.example.afreecatv.presentation.main.tab

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.example.afreecatv.R
import com.example.afreecatv.databinding.FragmentCategoryBinding
import com.example.afreecatv.presentation.BaseFragment
import com.example.afreecatv.presentation.main.model.Category
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category) {

    private val viewModel : CategoryViewModel by viewModels()
    override fun initView() {
        binding.viewModel = viewModel
    }

    companion object {

        const val KEY_CATEGORY = "category"

        fun newInstance(category: Category) = CategoryFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY_CATEGORY, category)
            }
        }
    }

}
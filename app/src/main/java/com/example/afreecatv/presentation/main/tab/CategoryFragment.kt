package com.example.afreecatv.presentation.main.tab

import android.os.Bundle
import com.example.afreecatv.R
import com.example.afreecatv.databinding.FragmentCategoryBinding
import com.example.afreecatv.presentation.BaseFragment
import com.example.afreecatv.presentation.main.model.Category

class CategoryFragment : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category) {

    private var param: Category? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param = it.getParcelable(ARG_KEY)
        }
    }

    override fun initView() {
        binding.tvCategory.text = param?.category ?: ""
    }

    companion object {

        private const val ARG_KEY = "category"

        fun newInstance(category: Category) = CategoryFragment().apply {
            arguments = Bundle().apply {
                putParcelable(ARG_KEY, category)
            }
        }
    }

}
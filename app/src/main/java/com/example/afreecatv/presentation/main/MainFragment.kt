package com.example.afreecatv.presentation.main

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.afreecatv.R
import com.example.afreecatv.data.category.Category
import com.example.afreecatv.databinding.FragmentMainBinding
import com.example.afreecatv.presentation.base.BaseFragment
import com.example.afreecatv.presentation.main.adapter.MainPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun initView() {
        collectFlow()
    }

    private fun collectFlow() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.categoryListFlow.collect {
                    initViewPager(it)
                }
            }
        }
    }

    private fun initViewPager(categoryList: List<Category>) {
        binding.vpMain.adapter = MainPagerAdapter(categoryList, requireActivity())
        TabLayoutMediator(binding.tlMain, binding.vpMain) { tab, position ->
            tab.text = categoryList[position].cateName
        }.attach()
    }
}
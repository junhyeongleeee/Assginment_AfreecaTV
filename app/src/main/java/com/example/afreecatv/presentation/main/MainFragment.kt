package com.example.afreecatv.presentation.main

import com.example.afreecatv.R
import com.example.afreecatv.databinding.FragmentMainBinding
import com.example.afreecatv.presentation.BaseFragment
import com.example.afreecatv.presentation.main.adapter.MainPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    override fun initView() {
        initViewPager()
        initBinding()
    }

    private fun initViewPager() {
        binding.vpMain.adapter = MainPagerAdapter(requireActivity())
    }

    private fun initBinding() {
        binding.viewPager = binding.vpMain
    }
}
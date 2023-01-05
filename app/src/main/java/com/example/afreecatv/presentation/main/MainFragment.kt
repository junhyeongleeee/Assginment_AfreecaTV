package com.example.afreecatv.presentation.main

import com.example.afreecatv.R
import com.example.afreecatv.databinding.FragmentMainBinding
import com.example.afreecatv.presentation.BaseFragment
import com.example.afreecatv.presentation.main.adapter.MainPagerAdapter

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    override fun initView() {
        initBinding()
    }

    private fun initBinding() {
        binding.vpMain.adapter = MainPagerAdapter(requireActivity())
        binding.viewPager = binding.vpMain
    }
}
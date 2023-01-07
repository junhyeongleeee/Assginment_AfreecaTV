package com.example.afreecatv.presentation.main

import androidx.fragment.app.viewModels
import com.example.afreecatv.R
import com.example.afreecatv.databinding.FragmentMainBinding
import com.example.afreecatv.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun initView() {
        initBinding()
    }

    private fun initBinding() {
        binding.activity = requireActivity()
        binding.tabLayout = binding.tlMain
        binding.viewModel = viewModel
    }
}
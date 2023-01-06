package com.example.afreecatv.presentation.detail

import androidx.activity.viewModels
import com.example.afreecatv.R
import com.example.afreecatv.databinding.ActivityDetailBinding
import com.example.afreecatv.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : BaseActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    private val viewModel: DetailViewModel by viewModels()

    override fun initView() {
        binding.viewModel = viewModel
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(0, android.R.anim.fade_out)
    }
}
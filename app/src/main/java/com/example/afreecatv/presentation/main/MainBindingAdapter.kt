package com.example.afreecatv.presentation.main

import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewpager2.widget.ViewPager2
import com.example.afreecatv.presentation.main.adapter.MainPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch

@BindingAdapter("setActivity", "setTabLayout", "setViewModel")
fun ViewPager2.initTabViewPager(
    activity: FragmentActivity,
    tabLayout: TabLayout,
    viewModel: MainViewModel
) {
    findViewTreeLifecycleOwner()?.lifecycleScope?.launch {
        findViewTreeLifecycleOwner()?.repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.categoryListFlow.collect {
                adapter = MainPagerAdapter(it, activity)
                offscreenPageLimit = 2

                TabLayoutMediator(tabLayout, this@initTabViewPager) { tab, position ->
                    tab.text = it[position].cateName
                }.attach()
            }
        }
    }
}
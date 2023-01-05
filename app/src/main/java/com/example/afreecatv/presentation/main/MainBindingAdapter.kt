package com.example.afreecatv.presentation.main

import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.afreecatv.presentation.main.model.Category
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

@BindingAdapter("setViewPager")
fun TabLayout.initTab(viewPager2: ViewPager2) {
    TabLayoutMediator(this, viewPager2) { tab, position ->
        tab.text = Category.values()[position].category
    }.attach()
}
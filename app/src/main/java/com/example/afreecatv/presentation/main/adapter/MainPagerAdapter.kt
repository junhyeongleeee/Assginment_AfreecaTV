package com.example.afreecatv.presentation.main.adapter

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.afreecatv.presentation.main.model.Category
import com.example.afreecatv.presentation.main.tab.CategoryFragment

class MainPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): CategoryFragment {
        return CategoryFragment.newInstance(Category.values()[position])
    }
}

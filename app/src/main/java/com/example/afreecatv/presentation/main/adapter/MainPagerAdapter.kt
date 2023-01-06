package com.example.afreecatv.presentation.main.adapter

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.afreecatv.data.category.Category
import com.example.afreecatv.presentation.main.tab.BroadFragment

class MainPagerAdapter(
    private val categoryList: List<Category>,
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = TAB_SIZE

    override fun createFragment(position: Int): BroadFragment {
        return BroadFragment.newInstance(categoryList[position])
    }

    companion object {
        const val TAB_SIZE = 3
    }
}

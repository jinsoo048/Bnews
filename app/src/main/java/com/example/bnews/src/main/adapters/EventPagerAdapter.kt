package com.example.bnews.src.main.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bnews.src.main.ui.culture.CultureFragment
import com.example.bnews.src.main.ui.culture.EducationFragment

private const val NUM_PAGES = 2

class EventPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = NUM_PAGES
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CultureFragment()
            1 -> EducationFragment()
            else -> CultureFragment()
        }
    }
}


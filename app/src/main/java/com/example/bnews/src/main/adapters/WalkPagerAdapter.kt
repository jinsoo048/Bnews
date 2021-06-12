package com.example.bnews.src.main.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bnews.src.main.ui.walk.DosungFragment
import com.example.bnews.src.main.ui.walk.FutureFragment
import com.example.bnews.src.main.ui.walk.LiveFragment

private const val NUM_PAGES = 3

class WalkPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = NUM_PAGES
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FutureFragment()
            1 -> LiveFragment()
            2 -> DosungFragment()
            else -> FutureFragment()
        }
    }
}


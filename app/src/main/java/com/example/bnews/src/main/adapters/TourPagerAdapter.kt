package com.example.bnews.src.main.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.bnews.src.main.ui.tour.CampFragment
import com.example.bnews.src.ui.walk.*

private const val NUM_PAGES = 2

class TourPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = NUM_PAGES
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TravelFragment()
            1 -> CampFragment()
            else -> TravelFragment()
        }
    }
}


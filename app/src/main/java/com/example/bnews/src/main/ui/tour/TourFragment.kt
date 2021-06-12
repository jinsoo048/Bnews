package com.example.bnews.src.main.ui.tour

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.bnews.R
import com.example.bnews.config.BaseFragment
import com.example.bnews.databinding.FragmentTourBinding
import com.example.bnews.src.main.adapters.TourPagerAdapter
import com.example.bnews.src.main.models.tour.camp.Camp
import com.example.bnews.src.main.models.tour.travel.Item
import com.example.bnews.src.main.models.tour.camp.image.Image
import com.example.bnews.src.main.models.tour.travel.Travel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class TourFragment :
    BaseFragment<FragmentTourBinding>(
        com.example.bnews.databinding.FragmentTourBinding::bind,
        R.layout.fragment_tour
    ),
    TourFragmentView {

    private lateinit var tourPagerAdapter: TourPagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //HomeService(this).tryGetCultureEvent()
        tourPagerAdapter = TourPagerAdapter(this)
        viewPager = binding.tourVp
        viewPager.adapter = tourPagerAdapter

        val tabName = arrayOf<String>("여행", "캠프")

        TabLayoutMediator(binding.tourTab, binding.tourVp) { tab, position ->
            tab.text = tabName[position].toString()
        }.attach()

        binding.tourTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.tourVp.currentItem = tab !!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d("JJS", "onTabUnselected !!!!!!!!!!!!!!!!!")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("JJS", "onTabReselected !!!!!!!!!!!!!!!!!")
            }
        })
    }


    override fun onGetTourTravelSuccess(response: Travel) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerTourTravelEvent(response: Item) {
        //TODO("Not yet implemented")
    }

    override fun onGetTourCampSuccess(response: Camp) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerTourCampEvent(response: com.example.bnews.src.main.models.tour.camp.Item) {
        //TODO("Not yet implemented")
    }

    override fun onGetTourCampImageSuccess(response: Image) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerTourCampImageEvent(response: com.example.bnews.src.main.models.tour.camp.image.Item) {
        //TODO("Not yet implemented")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
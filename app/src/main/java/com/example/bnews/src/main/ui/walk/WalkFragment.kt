package com.example.bnews.src.main.ui.walk

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.bnews.R
import com.example.bnews.config.BaseFragment
import com.example.bnews.databinding.FragmentWalkBinding
import com.example.bnews.src.main.adapters.WalkPagerAdapter
import com.example.bnews.src.main.models.walk.Live.Live
import com.example.bnews.src.main.models.walk.dosung.Dosung
import com.example.bnews.src.main.models.walk.future.Row
import com.example.bnews.src.main.models.walk.future.Future
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class WalkFragment :
    BaseFragment<FragmentWalkBinding>(
        com.example.bnews.databinding.FragmentWalkBinding::bind,
        R.layout.fragment_walk
    ),
    WalkFragmentView {

    private lateinit var walkPagerAdapter: WalkPagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //WalkService(this).tryGetCultureEvent()
        walkPagerAdapter = WalkPagerAdapter(this)
        viewPager = binding.walkVp
        viewPager.adapter = walkPagerAdapter

        val tabName = arrayOf<String>("미래유산길", "생태문화길", "한성도성길")
        //val tabName = arrayOf<String>("한성도성길", "생태문화길")

        TabLayoutMediator(binding.walkTab, binding.walkVp) { tab, position ->
            tab.text = tabName[position].toString()
        }.attach()

        binding.walkTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.walkVp.currentItem = tab !!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d("JJS", "onTabUnselected !!!!!!!!!!!!!!!!!")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("JJS", "onTabReselected !!!!!!!!!!!!!!!!!")
            }
        })
    }

    override fun onGetWalkDosungSuccess(response: Dosung) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerWalkDosungEvent(response: com.example.bnews.src.main.models.walk.dosung.Row) {
        TODO("Not yet implemented")
    }

    override fun onGetWalkLiveSuccess(response: Live) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerWalkLiveEvent(response: com.example.bnews.src.main.models.walk.Live.Row) {
        TODO("Not yet implemented")
    }

    override fun onGetWalkFutureSuccess(response: Future) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerWalkFutureEvent(response: Row) {
        TODO("Not yet implemented")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
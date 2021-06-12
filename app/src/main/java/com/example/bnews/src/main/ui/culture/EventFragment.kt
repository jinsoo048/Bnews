package com.example.bnews.src.main.ui.culture

import android.os.Bundle
import android.util.Log.d
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.bnews.R
import com.example.bnews.config.BaseFragment
import com.example.bnews.databinding.FragmentEventBinding
import com.example.bnews.src.main.adapters.EventPagerAdapter
import com.example.bnews.src.main.models.culture.PublicReservationCulture
import com.example.bnews.src.main.models.culture.Row
import com.example.bnews.src.main.models.education.Education
import com.example.bnews.src.ui.home.EventFragmentView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class EventFragment :
    BaseFragment<FragmentEventBinding>(FragmentEventBinding::bind, R.layout.fragment_event),
    EventFragmentView {

    private lateinit var eventPagerAdapter: EventPagerAdapter
    private lateinit var viewPager: ViewPager2

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //HomeService(this).tryGetCultureEvent()
        eventPagerAdapter = EventPagerAdapter(this)
        viewPager = binding.eventVp
        viewPager.adapter = eventPagerAdapter

        val tabName = arrayOf<String>("문화체험", "교육체험")

        TabLayoutMediator(binding.eventTab, binding.eventVp) { tab, position ->
            tab.text = tabName[position].toString()
        }.attach()

        binding.eventTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.eventVp.currentItem = tab !!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                d("JJS", "onTabUnselected !!!!!!!!!!!!!!!!!")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                d("JJS", "onTabReselected !!!!!!!!!!!!!!!!!")
            }
        })
    }


    override fun onGetCultureEventSuccess(response: PublicReservationCulture) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerCultureEvent(response: Row) {
        //TODO("Not yet implemented")
    }

    override fun onGetEducationEventSuccess(response: Education) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerEducationEvent(response: com.example.bnews.src.main.models.education.Row) {
        //TODO("Not yet implemented")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
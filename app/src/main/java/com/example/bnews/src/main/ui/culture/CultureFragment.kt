package com.example.bnews.src.main.ui.culture

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bnews.R
import com.example.bnews.config.BaseFragment
import com.example.bnews.databinding.FragmentCultureBinding
import com.example.bnews.src.main.adapters.CultureEventRecyclerViewAdapter
import com.example.bnews.src.main.models.culture.PublicReservationCulture
import com.example.bnews.src.main.models.culture.Row
import com.example.bnews.src.main.models.education.Education
import com.example.bnews.src.ui.home.EventFragmentView

class CultureFragment :
    BaseFragment<com.example.bnews.databinding.FragmentCultureBinding>(FragmentCultureBinding::bind, R.layout.fragment_culture),
    EventFragmentView {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        EventService(this).tryGetCultureEvent()
    }

    override fun onGetCultureEventSuccess(response: PublicReservationCulture) {
        binding.cultureEventRv.layoutManager =
            //StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL)
            GridLayoutManager(context, 2)
        //데이터 받고
        val adapter = CultureEventRecyclerViewAdapter(context = CultureFragment(), response, this)
        binding.cultureEventRv.adapter = adapter

    }
    override fun onCellClickListenerCultureEvent(response: Row) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(response.SVCURL)))
    }

    override fun onGetEducationEventSuccess(response: Education) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerEducationEvent(response: com.example.bnews.src.main.models.education.Row) {
        //TODO("Not yet implemented")
    }

}
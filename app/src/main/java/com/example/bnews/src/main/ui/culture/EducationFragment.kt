package com.example.bnews.src.main.ui.culture

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bnews.R
import com.example.bnews.config.BaseFragment
import com.example.bnews.databinding.FragmentEducationBinding
import com.example.bnews.src.main.adapters.EducationEventRecyclerViewAdapter
import com.example.bnews.src.main.models.culture.PublicReservationCulture
import com.example.bnews.src.main.models.culture.Row
import com.example.bnews.src.main.models.education.Education
import com.example.bnews.src.ui.home.EventFragmentView

class EducationFragment : BaseFragment<FragmentEducationBinding>(FragmentEducationBinding::bind,R.layout.fragment_education),
    EventFragmentView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        EventService(this).tryGetEducationEvent()

    }

    override fun onGetEducationEventSuccess(response: Education) {
        binding.educationEventRv.layoutManager =
            GridLayoutManager(context, 2)
        //데이터 받고
        val adapter = EducationEventRecyclerViewAdapter(context = EducationFragment(), response, this)
        binding.educationEventRv.adapter = adapter    }

    override fun onCellClickListenerEducationEvent(response: com.example.bnews.src.main.models.education.Row) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(response.SVCURL)))
    }


    override fun onGetCultureEventSuccess(response: PublicReservationCulture) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerCultureEvent(response: Row) {
        //ODO("Not yet implemented")
    }

}

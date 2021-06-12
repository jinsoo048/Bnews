package com.example.bnews.src.ui.walk

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.bnews.R
import com.example.bnews.config.BaseFragment
import com.example.bnews.databinding.FragmentTravelBinding
import com.example.bnews.src.main.adapters.TourTravelRecyclerAdapter
import com.example.bnews.src.main.models.tour.camp.Camp
import com.example.bnews.src.main.models.tour.travel.Item
import com.example.bnews.src.main.models.tour.camp.image.Image
import com.example.bnews.src.main.models.tour.travel.Travel
import com.example.bnews.src.main.ui.tour.TourFragmentView
import com.example.bnews.src.main.ui.tour.TourService


class TravelFragment : BaseFragment<FragmentTravelBinding>(FragmentTravelBinding::bind, R.layout.fragment_travel),
    TourFragmentView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        TourService(this).tryGetTourTravel()
    }

    override fun onGetTourTravelSuccess(response: Travel) {
        binding.travelRv.layoutManager =
            StaggeredGridLayoutManager(1,LinearLayoutManager.VERTICAL)
        //데이터 받고
        val adapter = TourTravelRecyclerAdapter(context = TravelFragment(), response, this)
        binding.travelRv.adapter = adapter    }

    override fun onCellClickListenerTourTravelEvent(response: Item) {
        var mUrl = "https://www.bing.com/search?q="+response.galTitle
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(mUrl)))
    }

    override fun onGetTourCampSuccess(respose: Camp) {
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


}
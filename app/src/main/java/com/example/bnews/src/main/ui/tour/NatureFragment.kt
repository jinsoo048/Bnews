package com.example.bnews.src.main.ui.tour

import android.os.Bundle
import android.view.View
import com.example.bnews.R
import com.example.bnews.config.BaseFragment
import com.example.bnews.databinding.FragmentNatureBinding
import com.example.bnews.src.main.models.tour.camp.Camp
import com.example.bnews.src.main.models.tour.travel.Item
import com.example.bnews.src.main.models.tour.camp.image.Image
import com.example.bnews.src.main.models.tour.travel.Travel

class NatureFragment : BaseFragment<com.example.bnews.databinding.FragmentNatureBinding>(FragmentNatureBinding::bind, R.layout.fragment_nature),
    TourFragmentView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TourService(this).tryGetTourNature()
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
}
package com.example.bnews.src.main.ui.tour

import com.example.bnews.src.main.models.tour.camp.Camp
import com.example.bnews.src.main.models.tour.travel.Item
import com.example.bnews.src.main.models.tour.camp.image.Image
import com.example.bnews.src.main.models.tour.travel.Travel

interface TourFragmentView {

    fun onGetTourTravelSuccess(response: Travel)
    fun onCellClickListenerTourTravelEvent(response: Item)

    fun onGetTourCampSuccess(response: Camp)
    fun onCellClickListenerTourCampEvent(response: com.example.bnews.src.main.models.tour.camp.Item)

    fun onGetTourCampImageSuccess(response: Image)
    fun onCellClickListenerTourCampImageEvent(response: com.example.bnews.src.main.models.tour.camp.image.Item)
}
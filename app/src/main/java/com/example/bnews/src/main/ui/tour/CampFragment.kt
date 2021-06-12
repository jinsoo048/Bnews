package com.example.bnews.src.main.ui.tour

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver.OnScrollChangedListener
import android.widget.ScrollView
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bnews.R
import com.example.bnews.config.BaseFragment
import com.example.bnews.databinding.FragmentCampBinding
import com.example.bnews.src.main.adapters.TourCampRecyclerAdapter
import com.example.bnews.src.main.models.tour.camp.Camp
import com.example.bnews.src.main.models.tour.camp.image.Image
import com.example.bnews.src.main.models.tour.travel.Item
import com.example.bnews.src.main.models.tour.travel.Travel


class CampFragment : BaseFragment<FragmentCampBinding>(FragmentCampBinding::bind, R.layout.fragment_camp),
    TourFragmentView {

    var pageNo : Int = 1
    var numOfRows : Int = 10

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        TourService(this).tryGetTourCamp(pageNo,numOfRows)

    }


    override fun onGetTourTravelSuccess(response: Travel) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerTourTravelEvent(response: Item) {
        //TODO("Not yet implemented")
    }

    override fun onGetTourCampSuccess(response: Camp) {

        binding.campRv.isNestedScrollingEnabled = false;

        binding.campRv.layoutManager =
            GridLayoutManager(context,3)
        //데이터 받고
        val adapter = TourCampRecyclerAdapter(context = CampFragment(), response, this)
        binding.campRv.adapter = adapter


        var mScrollView : NestedScrollView = binding.scrollView

        mScrollView.viewTreeObserver.addOnScrollChangedListener(OnScrollChangedListener {
            val view = mScrollView.getChildAt(mScrollView.getChildCount() - 1) as View

            var topDetector : Int = mScrollView.scrollY

            val bottomDetector : Int = view.bottom - (mScrollView.height + mScrollView.scrollY)
            if (bottomDetector  == 0) {
                Toast.makeText(context,"Scroll View bottom reached",Toast.LENGTH_SHORT).show();
                pageNo++
                //progressBar.setVisibility(View.VISIBLE)
                TourService(this).tryGetTourCamp(pageNo,numOfRows)
            }
            if(topDetector <= 0){
                Toast.makeText(context,"Scroll View top reached",Toast.LENGTH_SHORT).show();
            }
        })

    }
    override fun onCellClickListenerTourCampEvent(response: com.example.bnews.src.main.models.tour.camp.Item) {
        var mUrl = "https://www.bing.com/search?q="+response.facltNm
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(mUrl)))
    }

    override fun onGetTourCampImageSuccess(response: Image) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerTourCampImageEvent(response: com.example.bnews.src.main.models.tour.camp.image.Item) {
//
    }

}
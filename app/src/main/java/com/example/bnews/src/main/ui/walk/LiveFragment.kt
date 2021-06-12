package com.example.bnews.src.main.ui.walk

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.bnews.R
import com.example.bnews.config.BaseFragment
import com.example.bnews.databinding.FragmentLiveBinding
import com.example.bnews.src.main.adapters.WalkLiveRecyclerAdapter
import com.example.bnews.src.main.models.walk.Live.Live
import com.example.bnews.src.main.models.walk.dosung.Dosung
import com.example.bnews.src.main.models.walk.dosung.Row
import com.example.bnews.src.main.models.walk.future.Future

class LiveFragment :
    BaseFragment<FragmentLiveBinding>(FragmentLiveBinding::bind, R.layout.fragment_live),
    WalkFragmentView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        WalkService(this).tryGetWalkLive()
    }

    override fun onGetWalkDosungSuccess(response: Dosung) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerWalkDosungEvent(response: Row) {
        //TODO("Not yet implemented")
    }

    override fun onGetWalkLiveSuccess(response: Live) {
        //binding.dosungRv.layoutManager = GridLayoutManager(context, 2)

        binding.liveRv.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        //데이터 받고
        val adapter = WalkLiveRecyclerAdapter(context = LiveFragment(), response, this)
        binding.liveRv.adapter = adapter
    }

    override fun onCellClickListenerWalkLiveEvent(response: com.example.bnews.src.main.models.walk.Live.Row) {
        var mUrl = "https://www.bing.com/search?q="+response.COURSE_NAME
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(mUrl)))
    }

    override fun onGetWalkFutureSuccess(response: Future) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerWalkFutureEvent(response: com.example.bnews.src.main.models.walk.future.Row) {
        TODO("Not yet implemented")
    }
}
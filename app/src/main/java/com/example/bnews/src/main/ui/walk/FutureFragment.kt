package com.example.bnews.src.main.ui.walk

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.bnews.R
import com.example.bnews.config.BaseFragment
import com.example.bnews.databinding.FragmentFutureBinding
import com.example.bnews.src.main.adapters.WalkFutureRecyclerAdapter
import com.example.bnews.src.main.models.walk.Live.Live
import com.example.bnews.src.main.models.walk.dosung.Dosung
import com.example.bnews.src.main.models.walk.dosung.Row
import com.example.bnews.src.main.models.walk.future.Future

class FutureFragment:BaseFragment<FragmentFutureBinding>(FragmentFutureBinding::bind, R.layout.fragment_future),
    WalkFragmentView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        WalkService(this).tryGetWalkFuture()
    }

     override fun onGetWalkDosungSuccess(response: Dosung) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerWalkDosungEvent(response: Row) {
        //TODO("Not yet implemented")
    }

    override fun onGetWalkLiveSuccess(response: Live) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerWalkLiveEvent(response: com.example.bnews.src.main.models.walk.Live.Row) {
        //TODO("Not yet implemented")
    }

    override fun onGetWalkFutureSuccess(response: Future) {
        binding.futureRv.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        //데이터 받고
        val adapter = WalkFutureRecyclerAdapter(context = FutureFragment(), response, this)
        binding.futureRv.adapter = adapter    }

    override fun onCellClickListenerWalkFutureEvent(response: com.example.bnews.src.main.models.walk.future.Row) {
        var mUrl = "https://www.bing.com/search?q="+response.HT_NM
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(mUrl)))
    }
}
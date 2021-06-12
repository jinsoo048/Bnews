package com.example.bnews.src.main.ui.walk

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bnews.R
import com.example.bnews.config.BaseFragment
import com.example.bnews.databinding.FragmentDosungBinding
import com.example.bnews.src.main.adapters.WalkDosungRecyclerViewAdapter
import com.example.bnews.src.main.models.walk.Live.Live
import com.example.bnews.src.main.models.walk.dosung.Dosung
import com.example.bnews.src.main.models.walk.dosung.Row
import com.example.bnews.src.main.models.walk.future.Future

class DosungFragment : BaseFragment<FragmentDosungBinding>(FragmentDosungBinding::bind, R.layout.fragment_dosung),
    WalkFragmentView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        WalkService(this).tryGetWalkDosung()
    }

    override fun onGetWalkDosungSuccess(response: Dosung) {
        //binding.dosungRv.layoutManager = GridLayoutManager(context, 2)

        binding.dosungRv.layoutManager = GridLayoutManager(context, 2)
        //데이터 받고
        val adapter = WalkDosungRecyclerViewAdapter(context = DosungFragment(), response, this)
        binding.dosungRv.adapter = adapter
    }

    override fun onCellClickListenerWalkDosungEvent(response: com.example.bnews.src.main.models.walk.dosung.Row) {
        var mUrl = "https://www.bing.com/search?q="+response.COURSE_NAME
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(mUrl)))
    }



    override fun onGetWalkLiveSuccess(response: Live) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerWalkLiveEvent(response: com.example.bnews.src.main.models.walk.Live.Row) {
        //TODO("Not yet implemented")
    }

    override fun onGetWalkFutureSuccess(response: Future) {
        TODO("Not yet implemented")
    }

    override fun onCellClickListenerWalkFutureEvent(response: com.example.bnews.src.main.models.walk.future.Row) {
        //TODO("Not yet implemented")
    }
}
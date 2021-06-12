package com.example.bnews.src.main.ui.walk

import com.example.bnews.src.main.models.walk.Live.Live
import com.example.bnews.src.main.models.walk.dosung.Dosung
import com.example.bnews.src.main.models.walk.future.Row
import com.example.bnews.src.main.models.walk.future.Future

interface WalkFragmentView {
    fun onGetWalkDosungSuccess(response: Dosung)
    fun onCellClickListenerWalkDosungEvent(response: com.example.bnews.src.main.models.walk.dosung.Row)

    fun onGetWalkLiveSuccess(response: Live)
    fun onCellClickListenerWalkLiveEvent(response: com.example.bnews.src.main.models.walk.Live.Row)

    fun onGetWalkFutureSuccess(response: Future)
    fun onCellClickListenerWalkFutureEvent(response: Row)

}
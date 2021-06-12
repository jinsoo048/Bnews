package com.example.bnews.src.main.ui.walk

import android.util.Log.d
import com.example.bnews.config.ApplicationClass
import com.example.bnews.src.main.models.walk.Live.Live
import com.example.bnews.src.main.models.walk.dosung.Dosung
import com.example.bnews.src.main.models.walk.future.Future
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WalkService(val view: WalkFragmentView) {

    fun tryGetWalkDosung() {
        val walkRetrofitInterface =
            ApplicationClass.sRetrofit.create(WalkRetrofitInterface::class.java)
        var mUrl: String =
            "41547274756a6a7335326d6f475450/json/walkDoseongInfo/1/100/"
        walkRetrofitInterface.getWalkDosung(mUrl)
            .enqueue(object : Callback<Dosung> {
                override fun onResponse(
                    call: Call<Dosung>,
                    response: Response<Dosung>
                ) {
                    view.onGetWalkDosungSuccess(response.body() as Dosung)
                }
                override fun onFailure(call: Call<Dosung>, t: Throwable) {
                    d("JJS", "tryGetWalkDosung failed !!!!!!!!!!!!!!!")
                }
            })
    }
    fun tryGetWalkLive() {
        val walkRetrofitInterface =
            ApplicationClass.sRetrofit.create(WalkRetrofitInterface::class.java)
        var mUrl: String =
            "56655455636a6a73333449424d4853/json/walkSaengtaeInfo/1/100/"
        walkRetrofitInterface.getWalkLive(mUrl)
            .enqueue(object : Callback<Live> {
                override fun onResponse(
                    call: Call<Live>,
                    response: Response<Live>
                ) {
                    view.onGetWalkLiveSuccess(response.body() as Live)
                }
                override fun onFailure(call: Call<Live>, t: Throwable) {
                    d("JJS", "tryGetWalkLive failed !!!!!!!!!!!!!!!")
                }
            })
    }
    fun tryGetWalkFuture() {
        val walkRetrofitInterface =
            ApplicationClass.sRetrofit.create(WalkRetrofitInterface::class.java)
        var mUrl: String =
            "4c6f5066626a6a7334386e7757434c/json/futureCourseInfo/1/100/"
        walkRetrofitInterface.getWalkFuture(mUrl)
            .enqueue(object : Callback<Future> {
                override fun onResponse(
                    call: Call<Future>,
                    response: Response<Future>
                ) {
                    view.onGetWalkFutureSuccess(response.body() as Future)
                }
                override fun onFailure(call: Call<Future>, t: Throwable) {
                    d("JJS", "tryGetWalkFuture failed !!!!!!!!!!!!!!!")
                }
            })
    }


}


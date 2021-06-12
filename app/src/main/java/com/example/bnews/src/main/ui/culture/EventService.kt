package com.example.bnews.src.main.ui.culture

import android.util.Log.d
import com.example.bnews.config.ApplicationClass
import com.example.bnews.src.main.models.culture.PublicReservationCulture
import com.example.bnews.src.main.models.education.Education
import com.example.bnews.src.ui.home.EventFragmentView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EventService(val view: EventFragmentView) {


    // get the culture event information
    fun tryGetCultureEvent() {
        val eventRetrofitInterface =
            ApplicationClass.sRetrofit.create(EventRetrofitInterface::class.java)
        var mUrl: String =
            "6c566673796a6a733839664d4a624d/json/ListPublicReservationCulture/1/100"
        eventRetrofitInterface.getCultureEvent(mUrl)
            .enqueue(object : Callback<PublicReservationCulture> {
                override fun onResponse(
                    //ListPublicReservationCulture
                    call: Call<PublicReservationCulture>,
                    response: Response<PublicReservationCulture>
                ) {
                    view.onGetCultureEventSuccess(response.body() as PublicReservationCulture)
                }
                override fun onFailure(call: Call<PublicReservationCulture>, t: Throwable) {
                    d("JJS", "tryGetCultureEvent failed !!!!!!!!!!!!!!!")
                }

            })

    }

    // get the education event information
    fun tryGetEducationEvent() {
        val eventRetrofitInterface =
            ApplicationClass.sRetrofit.create(EventRetrofitInterface::class.java)
        var mUrl: String =
            "76466d68766a6a733830667a784c49/json/ListPublicReservationEducation/1/100/"
        eventRetrofitInterface.getEducationEvent(mUrl)
            .enqueue(object : Callback<Education> {
                override fun onResponse(
                    //ListPublicReservationCulture
                    call: Call<Education>,
                    response: Response<Education>
                ) {
                    view.onGetEducationEventSuccess(response.body() as Education)
                }
                override fun onFailure(call: Call<Education>, t: Throwable) {
                    d("JJS", "tryGetCultureEvent failed !!!!!!!!!!!!!!!")
                }
            })
    }


}


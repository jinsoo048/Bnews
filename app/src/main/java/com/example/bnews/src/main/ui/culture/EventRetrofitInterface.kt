package com.example.bnews.src.main.ui.culture

import com.example.bnews.src.main.models.culture.PublicReservationCulture
import com.example.bnews.src.main.models.education.Education
import retrofit2.Call
import retrofit2.http.*

interface EventRetrofitInterface {


    //Culture & Education
    @GET
    fun getCultureEvent(@Url url: String): Call<PublicReservationCulture>
    @GET
    fun getEducationEvent(@Url url: String): Call<Education>


}

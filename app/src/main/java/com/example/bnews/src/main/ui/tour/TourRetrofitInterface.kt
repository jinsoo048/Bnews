package com.example.bnews.src.main.ui.tour

import com.example.bnews.src.main.models.tour.camp.Camp
import com.example.bnews.src.main.models.tour.camp.image.Image
import com.example.bnews.src.main.models.tour.travel.Travel
import retrofit2.Call
import retrofit2.http.*

interface TourRetrofitInterface {

    //Tour seriese
    @GET
    fun getTourTravel(@Url url: String): Call<Travel>

    //Camp
    @GET
    fun getTourCamp(@Url url: String,@Query("pageNo") pageNo : Int,@Query("numOfRows") numOfRows:Int ): Call<Camp>


    @GET
    fun getTourCampImage(@Url url: String): Call<Image>
}

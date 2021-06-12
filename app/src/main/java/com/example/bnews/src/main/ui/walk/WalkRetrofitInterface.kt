package com.example.bnews.src.main.ui.walk

import com.example.bnews.src.main.models.walk.Live.Live
import com.example.bnews.src.main.models.walk.dosung.Dosung
import com.example.bnews.src.main.models.walk.future.Future
import retrofit2.Call
import retrofit2.http.*

interface WalkRetrofitInterface {


    //Seoul Walk
    @GET
    fun getWalkDosung(@Url url: String): Call<Dosung>
    @GET
    fun getWalkLive(@Url url: String): Call<Live>
    @GET
    fun getWalkFuture(@Url url: String): Call<Future>


}

package com.example.bnews.src.main.ui.tour

import android.util.Log.d
import com.example.bnews.src.main.models.tour.camp.Camp
import com.example.bnews.src.main.models.tour.travel.Travel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class TourService(val view: TourFragmentView) {

    fun tryGetTourTravel() {
        var API_URL = "http://api.visitkorea.or.kr/"
        var lRetrofit: Retrofit

        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            // 로그캣에 okhttp.OkHttpClient로 검색하면 http 통신 내용을 보여줍니다.
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            //           .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .build()
        lRetrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val tourRetrofitInterface =
            lRetrofit.create(TourRetrofitInterface::class.java)

        var mUrl: String =
            "openapi/service/rest/PhotoGalleryService/galleryList?ServiceKey=oxkeiOH8uK8oW7g0PbEl5%2F1XxEPIdlvQtZnFkmMONh8qI3VCVBLjtyn0Q9LCS5ICwiC0oE9SmI7pEaH%2F2IzfDg%3D%3D&numOfRows=100&pageNo=1&MobileOS=ETC&MobileApp=TestApp&_type=json"
        tourRetrofitInterface.getTourTravel(mUrl)
            .enqueue(object : Callback<Travel> {
                override fun onResponse(
                    call: Call<Travel>,
                    response: Response<Travel>
                ) {
                    view.onGetTourTravelSuccess(response.body() as Travel)
                }

                override fun onFailure(call: Call<Travel>, t: Throwable) {
                    d("JJS", "tryGetTourTravel failed !!!!!!!!!!!!!!!")
                }
            })

    }

    fun tryGetTourCamp(pageNo:Int, numOfRows:Int) {
        var API_URL = "http://api.visitkorea.or.kr/"
        var lRetrofit: Retrofit
        var contentID: Int

        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            // 로그캣에 okhttp.OkHttpClient로 검색하면 http 통신 내용을 보여줍니다.
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            //           .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .build()
        lRetrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val tourRetrofitInterface =
            lRetrofit.create(TourRetrofitInterface::class.java)

        //var mUrl: String =
        //    "http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/basedList?serviceKey=oxkeiOH8uK8oW7g0PbEl5%2F1XxEPIdlvQtZnFkmMONh8qI3VCVBLjtyn0Q9LCS5ICwiC0oE9SmI7pEaH%2F2IzfDg%3D%3D&pageNo=1&numOfRows=10&MobileOS=ETC&MobileApp=AppTest&_type=json"
        var mUrl: String = "https://b25d56bd-0ba3-4162-8b2c-82749ee9d3e2.mock.pstmn.io"
            //"http://api.visitkorea.or.kr/openapi/service/rest/GoCamping/basedList?serviceKey=oxkeiOH8uK8oW7g0PbEl5%2F1XxEPIdlvQtZnFkmMONh8qI3VCVBLjtyn0Q9LCS5ICwiC0oE9SmI7pEaH%2F2IzfDg%3D%3D&MobileOS=ETC&MobileApp=AppTest&_type=json"



        tourRetrofitInterface.getTourCamp(mUrl,pageNo,numOfRows)
            .enqueue(object : Callback<Camp> {
                override fun onResponse(
                    call: Call<Camp>,
                    response: Response<Camp>
                ) {
                    view.onGetTourCampSuccess(response.body() as Camp)
                    //var json: JSONObject = JSONObject(response.body().toString())
                    //contentID = json[]
                }

                override fun onFailure(call: Call<Camp>, t: Throwable) {
                    d("JJS", "tryGetTourTravel failed !!!!!!!!!!!!!!!")
                }
            })
    }
}





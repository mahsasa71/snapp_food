package com.example.radiojavannahaei.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    var retrofit=Retrofit.Builder()
        .baseUrl("http://flutterapps.ir/apps/snappfood/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
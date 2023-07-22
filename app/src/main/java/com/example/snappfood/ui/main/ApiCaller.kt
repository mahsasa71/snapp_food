package com.example.snappfood.ui.main

import android.util.Log
import com.example.radiojavannahaei.api.ApiService
import com.example.radiojavannahaei.api.Iservice
import com.example.snappfood.models.FoodModel
import com.example.snappfood.models.IResponseMessage
import com.example.snappfood.models.ResturantModel
import com.navin.snappfood.models.CategoryModelModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiCaller {
    val iservice:Iservice=ApiService.retrofit.create(Iservice::class.java)
    fun getcategories(listener: IResponseMessage<CategoryModelModel>){
        Log.e("","")
    iservice.getCategories().enqueue(object :Callback<CategoryModelModel>{
        override fun onResponse(call: Call<CategoryModelModel>, response: Response<CategoryModelModel>) {
            Log.e("","")
            response.body()?.let { listener.onsuccess(it) }

        }

        override fun onFailure(call: Call<CategoryModelModel>, t: Throwable) {
        listener.onfailure("Error")
        }

    })
    }

    fun getFoods(listener: IResponseMessage<FoodModel>){
        Log.e("","")
        iservice.getLatestFoods().enqueue(object :Callback<FoodModel>{
            override fun onResponse(call: Call<FoodModel>, response: Response<FoodModel>) {
                Log.e("","")
                response.body()?.let { listener.onsuccess(it) }

            }

            override fun onFailure(call: Call<FoodModel>, t: Throwable) {
                listener.onfailure("Error")
            }

        })
    }
    fun getRestaurants(listener: IResponseMessage<ResturantModel>){
        Log.e("","")
        iservice.getRestaurants().enqueue(object :Callback<ResturantModel>{
            override fun onResponse(call: Call<ResturantModel>, response: Response<ResturantModel>) {
                Log.e("","")
                response.body()?.let { listener.onsuccess(it) }

            }

            override fun onFailure(call: Call<ResturantModel>, t: Throwable) {
                listener.onfailure("Error")
            }

        })
    }

}
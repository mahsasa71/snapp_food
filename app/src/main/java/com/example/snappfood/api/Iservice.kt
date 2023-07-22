package com.example.radiojavannahaei.api


import com.example.snappfood.models.FoodModel
import com.example.snappfood.models.ResturantModel
import com.navin.snappfood.models.CategoryModelModel
import retrofit2.Call
import retrofit2.http.GET

interface Iservice {
    @GET("api.php?cat_list")
    fun getCategories(): Call<CategoryModelModel>
    @GET("api.php?latest")
    fun getLatestFoods(): Call<FoodModel>
    @GET("api.php?album_list")
    fun getRestaurants(): Call<ResturantModel>



}
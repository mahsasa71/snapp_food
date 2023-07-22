package com.example.snappfood.models

import com.google.gson.annotations.SerializedName

data class ResturantModel (
    @SerializedName("ONLINE_Book")
    val restaurantList:List<Resturant>

        )
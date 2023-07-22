package com.example.snappfood.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize

data class Resturant (
    @SerializedName("aid")
    var rid:String,
    @SerializedName("album_name")
    var restaurantName:String,
    @SerializedName("album_image")
    var restaurantImage:String,
    @SerializedName("album_image_thumb")
    var restaurantimageThumb:String,

        ) : Parcelable
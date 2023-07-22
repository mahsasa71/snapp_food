package com.navin.snappfood.models

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("cid")
    var cId : String,
    @SerializedName("category_name")
    var categoryName : String,
    @SerializedName("category_image")
    var categoryImage : String,
     @SerializedName("category_image_thumb")
    var category_image_thumb : String,
)

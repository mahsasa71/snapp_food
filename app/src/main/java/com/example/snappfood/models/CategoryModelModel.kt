package com.navin.snappfood.models

import com.google.gson.annotations.SerializedName

data class CategoryModelModel(
    @SerializedName("ONLINE_Book")
    var categories: List<Category>
)

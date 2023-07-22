package com.example.snappfood.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Food(
    val book_description: String,
    val book_numbers: String,
    val book_publisher: String,
    val book_thumbnail_b: String,
    val book_thumbnail_s: String,
    val book_title: String,
    val book_type: String,
    val book_url: String,
    val cat_id: String,
    val category_image: String,
    val category_image_thumb: String,
    val category_name: String,
    val cid: String,
    val id: String,
    val rate_avg: String,
    val total_download: String,
    val total_rate: String,
    val total_views: String
) : Parcelable
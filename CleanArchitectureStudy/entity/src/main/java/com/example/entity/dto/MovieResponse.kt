package com.example.entity.dto

import com.google.gson.annotations.SerializedName


/**
 * api return 값의 형태
 */
data class MovieResponse(
    @SerializedName("display")
    val display: Int,

    @SerializedName("items")
    val movies: List<MovieDTO>,

    @SerializedName("lastBuildDate")
    val lastBuildDate: String,

    @SerializedName("start")
    val start: Int,

    @SerializedName("total")
    val total: Int
)
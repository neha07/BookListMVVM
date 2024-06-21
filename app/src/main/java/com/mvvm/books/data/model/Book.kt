package com.mvvm.books.data.model

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("author")
    val author: String = "",
    @SerializedName("release_date")
    val release_date: String = "",
    @SerializedName("image")
    val image: String = ""
)


package com.mvvm.books.data.api

import com.mvvm.books.data.model.Book
import retrofit2.http.GET

interface BooksApi {

    @GET("/")
    suspend fun getBooks(): List<Book>
}

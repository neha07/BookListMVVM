package com.mvvm.books.data

import com.mvvm.books.data.api.BooksApi
import com.mvvm.books.data.model.Book
import javax.inject.Inject

class BooksService @Inject constructor(private val booksApi: BooksApi) {

    suspend fun getBooks(): List<Book> {
        // TODO getBooks from API
        return booksApi.getBooks()
    }
}

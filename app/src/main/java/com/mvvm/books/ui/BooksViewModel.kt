package com.mvvm.books.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvvm.books.data.BooksService
import com.mvvm.books.data.model.Book
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class BooksViewModel @Inject constructor(private val booksService: BooksService) : ViewModel() {

    private val books = MutableLiveData<List<Book>>()

    fun books(): LiveData<List<Book>> = books

    fun fetchBooks() {
        viewModelScope.launch {
            try {
                books.value = booksService.getBooks()
            } catch (e: Exception) {
                Timber.e(e, "while loading data")
            }

        }
    }
}

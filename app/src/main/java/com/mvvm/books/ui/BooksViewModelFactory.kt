package com.mvvm.books.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mvvm.books.data.BooksService
import javax.inject.Inject

class BooksViewModelFactory @Inject constructor(
    private val booksService: BooksService
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = BooksViewModel(booksService) as T
}

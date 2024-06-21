package com.mvvm.books.data.api

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class BooksApiModule {

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun getBooksApi(
        gsonConverterFactory: GsonConverterFactory
    ): BooksApi {

        return Retrofit.Builder()
            .baseUrl("https://c27b2d72-8d9c-4aa0-b549-7ae7e5666815.mock.pstmn.io/")
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(BooksApi::class.java)
    }
}




package com.mvvm.books.di

import android.content.Context
import com.mvvm.books.data.api.BooksApiModule
import com.mvvm.books.ui.BooksActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [BooksApiModule::class])
interface ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

    fun inject(activity: BooksActivity)
}

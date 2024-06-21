package com.mvvm.books

import android.app.Application
import com.blinkslabs.blinkist.android.challenge.BuildConfig
import com.mvvm.books.di.ApplicationComponent
import com.jakewharton.threetenabp.AndroidThreeTen
import com.mvvm.books.di.DaggerApplicationComponent
import timber.log.Timber

class BooksApplication : Application() {

  val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        initTimber()
        initThreeTen()
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }

    private fun initThreeTen() = AndroidThreeTen.init(this)
}

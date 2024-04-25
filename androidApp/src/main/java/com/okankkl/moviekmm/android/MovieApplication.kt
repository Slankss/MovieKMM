package com.okankkl.moviekmm.android

import android.app.Application
import com.okankkl.moviekmm.android.di.appModule
import com.okankkl.moviekmm.di.getSharedModules
import org.koin.core.context.startKoin

class MovieApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules( appModule + getSharedModules())
        }
    }
}
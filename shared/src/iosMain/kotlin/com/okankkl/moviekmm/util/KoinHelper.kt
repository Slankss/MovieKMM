package com.okankkl.moviekmm.util
import com.okankkl.moviekmm.di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin() {

    startKoin{
        modules(getSharedModules())
    }

}
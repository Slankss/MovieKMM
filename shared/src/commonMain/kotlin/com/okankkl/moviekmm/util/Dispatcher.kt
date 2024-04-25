package com.okankkl.moviekmm.util

import kotlinx.coroutines.CoroutineDispatcher

internal interface Dispatcher {
    val io : CoroutineDispatcher
}

internal expect fun provideDispatcher() : Dispatcher

// expect vs actual
// expect : bunu um bunu bulmak zorundayız
// actual : gerçekten onun uygulanmış hali
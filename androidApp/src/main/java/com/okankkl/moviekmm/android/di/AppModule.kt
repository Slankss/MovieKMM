package com.okankkl.moviekmm.android.di

import com.okankkl.moviekmm.android.detail.DetailViewModel
import com.okankkl.moviekmm.android.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { params -> DetailViewModel(getMovieUseCase = get(),movieId = params.get()) }

}
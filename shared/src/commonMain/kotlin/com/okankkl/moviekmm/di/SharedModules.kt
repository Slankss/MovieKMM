package com.okankkl.moviekmm.di

import com.okankkl.moviekmm.data.remote.MovieService
import com.okankkl.moviekmm.data.remote.RemoteDataSource
import com.okankkl.moviekmm.data.repository.MovieRepositoryImp
import com.okankkl.moviekmm.domain.repository.MovieRepository
import com.okankkl.moviekmm.domain.usecase.GetMovieUseCase
import com.okankkl.moviekmm.domain.usecase.GetMoviesUseCase
import com.okankkl.moviekmm.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory { RemoteDataSource(get(),get()) }
    factory { MovieService() }
}

private val utilModule = module {
    factory { provideDispatcher() }

}

private val domainModule = module {
    factory { GetMovieUseCase() }
    factory { GetMoviesUseCase() }
    single<MovieRepository> { MovieRepositoryImp(get()) }
}

private val sharedModules = listOf(dataModule, utilModule, domainModule)

fun getSharedModules() = sharedModules
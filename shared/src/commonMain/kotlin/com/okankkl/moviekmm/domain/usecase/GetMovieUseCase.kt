package com.okankkl.moviekmm.domain.usecase

import com.okankkl.moviekmm.domain.model.Movie
import com.okankkl.moviekmm.domain.repository.MovieRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class GetMovieUseCase : KoinComponent {

    private val repository : MovieRepository by inject()

    @Throws(Exception::class)
    suspend operator fun invoke(movieId : Int) : Movie {
        return repository.getMovie(movieId = movieId)
    }

}
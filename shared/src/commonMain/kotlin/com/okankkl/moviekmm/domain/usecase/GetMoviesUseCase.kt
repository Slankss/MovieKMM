package com.okankkl.moviekmm.domain.usecase

import com.okankkl.moviekmm.domain.model.Movie
import com.okankkl.moviekmm.domain.repository.MovieRepository
import io.github.aakira.napier.Napier
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetMoviesUseCase : KoinComponent {

    private val repository : MovieRepository by inject()

    @Throws(Exception::class) // try catch gibi hata yakalamayı sağlıyor
    suspend operator fun invoke(page : Int) : List<Movie> {
        return repository.getMovies(page = page)
    }

}
package com.okankkl.moviekmm.domain.repository

import com.okankkl.moviekmm.domain.model.Movie

internal interface MovieRepository {

    suspend fun getMovies(page : Int) : List<Movie>
    suspend fun getMovie(movieId : Int) : Movie

}
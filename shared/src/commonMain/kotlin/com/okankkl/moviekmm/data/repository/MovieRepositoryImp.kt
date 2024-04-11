package com.okankkl.moviekmm.data.repository

import com.okankkl.moviekmm.data.remote.RemoteDataSource
import com.okankkl.moviekmm.data.util.toMovie
import com.okankkl.moviekmm.domain.model.Movie
import com.okankkl.moviekmm.domain.repository.MovieRepository

internal class MovieRepositoryImp(
    private val remoteDataSource: RemoteDataSource
) : MovieRepository {
    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDataSource.getMovies(page = page).results.map { it.toMovie() }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDataSource.getMovie(movieId = movieId).toMovie()
    }
}
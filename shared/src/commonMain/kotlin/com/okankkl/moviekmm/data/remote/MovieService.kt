package com.okankkl.moviekmm.data.remote

import com.okankkl.moviekmm.data.remote.dto.MovieDto
import com.okankkl.moviekmm.data.remote.response.MoviesResponse
import io.github.aakira.napier.Napier
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class MovieService : KtorApi() {

    suspend fun getMovies(page : Int = 1) : MoviesResponse = client.get {
        pathUrl("movie/popular")
        parameter("page",page)
    }.body()

    suspend fun getMovie(movieId : Int) : MovieDto = client.get {
        pathUrl("movie/$movieId")
    }.body()

}
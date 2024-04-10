package com.okankkl.moviekmm.data.remote

import com.okankkl.moviekmm.data.remote.dto.MovieDto
import com.okankkl.moviekmm.data.remote.response.MoviesResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class MovieService : KtorApi() {

    suspend fun getMovies() : MoviesResponse = client.get {
        pathUrl("movie/popular")
        parameter("page",1)
    }.body()

    suspend fun getMovie(movieId : String) : MovieDto = client.get {
        pathUrl("movie/$movieId")
    }.body()

}
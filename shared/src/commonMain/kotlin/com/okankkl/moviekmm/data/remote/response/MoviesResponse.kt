package com.okankkl.moviekmm.data.remote.response

import com.okankkl.moviekmm.data.remote.dto.MovieDto
import kotlinx.serialization.Serializable

@Serializable
internal data class MoviesResponse(
    val results : List<MovieDto>
)
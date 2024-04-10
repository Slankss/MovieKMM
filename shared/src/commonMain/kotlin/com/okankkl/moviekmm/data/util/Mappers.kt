package com.okankkl.moviekmm.data.util

import com.okankkl.moviekmm.data.remote.dto.MovieDto
import com.okankkl.moviekmm.domain.model.Movie
import com.okankkl.moviekmm.util.Constants.IMAGE_BASE_URL

internal fun MovieDto.toMovie() : Movie {
    return Movie(
        id = id,
        title = title,
        description = overview,
        imageUrl = getImageUrl(posterImage),
        releaseDate = releaseDate
    )
}

private fun getImageUrl(posterImage : String) = "$IMAGE_BASE_URL$posterImage"
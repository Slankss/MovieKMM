package com.okankkl.moviekmm.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MovieDto(
    val id : Int,
    val title : String,
    var overview : String,
    @SerialName("poster_path")
    var posterImage : String,
    @SerialName("release_date")
    var releaseDate : String
)

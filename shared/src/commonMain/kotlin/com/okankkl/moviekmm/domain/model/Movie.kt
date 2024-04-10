package com.okankkl.moviekmm.domain.model

data class Movie(
    val id : Int,
    val title : String,
    var description : String,
    var imageUrl : String,
    var releaseDate : String
)

package com.okankkl.moviekmm.android.detail

import com.okankkl.moviekmm.domain.model.Movie

data class DetailScreenState(
    var loading : Boolean = false,
    var error : String? = null,
    var movie : Movie? = null,
)

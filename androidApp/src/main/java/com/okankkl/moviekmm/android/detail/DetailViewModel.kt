package com.okankkl.moviekmm.android.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okankkl.moviekmm.domain.usecase.GetMovieUseCase
import kotlinx.coroutines.launch

class DetailViewModel(
    val getMovieUseCase: GetMovieUseCase,
    val movieId : Int
) : ViewModel() {

    var state by mutableStateOf(DetailScreenState())

    init {
        loadMovie(movieId)
    }
    private fun loadMovie(movieId : Int){

        viewModelScope.launch {
            state = state.copy(loading = true)

            state = try {
                val movie = getMovieUseCase(movieId)
                state.copy(loading = false,movie = movie)
            } catch (error : Throwable){
                state.copy(error = error.localizedMessage)
            }
        }

    }

}
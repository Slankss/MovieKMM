package com.okankkl.moviekmm.android.home

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.okankkl.moviekmm.domain.usecase.GetMoviesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    val getMoviesUseCase : GetMoviesUseCase
) : ViewModel() {

    var state by mutableStateOf(HomeScreenState())
    private var currentPage = 1
    init {
        loadMovies(forceReload = false)
    }
    fun loadMovies(forceReload : Boolean = false){

        if(state.loading) return
        if(forceReload) currentPage = 1
        if(currentPage == 1) state = state.copy(refreshing = true)

        viewModelScope.launch {
            state = state.copy(loading = true)
            try {
                val resultMovies = getMoviesUseCase(page = currentPage)
                val movies = if(currentPage == 1) resultMovies else state.movies + resultMovies

                currentPage +=1
                state = state.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = resultMovies.isEmpty(),
                    movies = movies
                )
            } catch (error : Throwable){
                state = state.copy(
                    loading = false,
                    refreshing = false,
                    loadFinished = true,
                    errorMessage = "Could not load : ${error.message}"
                )
            }

        }
    }
}
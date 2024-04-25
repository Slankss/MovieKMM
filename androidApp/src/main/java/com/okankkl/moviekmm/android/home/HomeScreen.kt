package com.okankkl.moviekmm.android.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.okankkl.moviekmm.android.Dark1
import com.okankkl.moviekmm.android.home.component.MovieListItem
import com.okankkl.moviekmm.domain.model.Movie


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    modifier : Modifier = Modifier,
    state : HomeScreenState,
    loadNextMovies : (Boolean) -> Unit,
    navigateToDetail : (Movie) -> Unit
) {

    val pullRefreshState = rememberPullRefreshState(
        refreshing = state.refreshing,
        onRefresh = { loadNextMovies(true)}
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Dark1)
            .pullRefresh(pullRefreshState)
    ){
        state.errorMessage?.let {
            Text(
                text = it,
                modifier = Modifier.align(Alignment.Center),
                color = Color.White
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        )
        {
            itemsIndexed(
                items = state.movies,
                key = {_,movie -> movie.id}
            ){ index,movie ->
                MovieListItem(movie = movie, onMovieClick = {navigateToDetail(movie)})

                if(index >= state.movies.size -1 && !state.loading && !state.loadFinished){
                    LaunchedEffect(key1 = Unit, block = { loadNextMovies(false) })
                }
            }

            if(state.loading && state.movies.isNotEmpty()){
                item(span = { GridItemSpan(2) }) {
                    Row(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        CircularProgressIndicator(color = Color.Red)
                    }
                }
            }
        }
        PullRefreshIndicator(
            refreshing = state.refreshing,
            state = pullRefreshState,
            modifier = modifier.align(Alignment.TopCenter)
        )
    }

}


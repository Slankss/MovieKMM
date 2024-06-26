package com.okankkl.moviekmm.android

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.okankkl.moviekmm.android.common.Detail
import com.okankkl.moviekmm.android.common.Home
import com.okankkl.moviekmm.android.common.MovieAppBar
import com.okankkl.moviekmm.android.common.movieDestinations
import com.okankkl.moviekmm.android.detail.DetailScreen
import com.okankkl.moviekmm.android.detail.DetailScreenState
import com.okankkl.moviekmm.android.detail.DetailViewModel
import com.okankkl.moviekmm.android.home.HomeScreen
import com.okankkl.moviekmm.android.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MovieApp(){

    val scaffoldState = rememberScaffoldState()
    val navController = rememberNavController()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = movieDestinations.find {
        backStackEntry?.destination?.route == it.route ||
                backStackEntry?.destination?.route == it.routeWithArgs
    } ?: Home

    Scaffold(
        topBar = {
            MovieAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                currentScreen = currentScreen) {
                navController.navigateUp()
            }
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = Home.routeWithArgs,
        ){

            composable(route = Home.routeWithArgs){
                val homeViewModel : HomeViewModel = koinViewModel()
                HomeScreen(
                    modifier = Modifier,
                    state = homeViewModel.state,
                    loadNextMovies = {
                        homeViewModel.loadMovies(forceReload = it)
                    },
                    navigateToDetail = { movie ->
                        navController.navigate("${Detail.route}/${movie.id}")
                    }
                )
            }

            composable(route = Detail.routeWithArgs, arguments = Detail.arguments){
                val movieId = it.arguments?.getInt("movieId") ?: 0
                val detailViewModel : DetailViewModel = koinViewModel(
                    parameters = { parametersOf(movieId) }
                )


                DetailScreen(
                    modifier = Modifier,
                    state = detailViewModel.state,
                    navigateToHome = {
                        navController.navigate(Home.route)
                    }
                )
            }
        }

    }

}
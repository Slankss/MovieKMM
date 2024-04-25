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
import com.okankkl.moviekmm.android.home.HomeScreen
import com.okankkl.moviekmm.android.home.HomeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieApp(){

    val scaffolState = rememberScaffoldState()
    val navController = rememberNavController()

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = movieDestinations.find {
        backStackEntry?.destination?.route == it.route ||
                backStackEntry?.destination?.route == it.routeWithArgs
    } ?: Home

    Scaffold(
        topBar = {
            MovieAppBar(
                canNavigateBack = navController.currentBackStackEntry != null,
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
                    navigateToDetail = {
                        navController.navigate("${Detail.route}/{${it.id}}")
                    }
                )
            }

            composable(route = Detail.routeWithArgs, arguments = Detail.arguments){
                val movieId = it.arguments?.getInt("movieId") ?: 0
            }
        }

    }

}
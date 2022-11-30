package com.example.mad_00011414.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.compose.material.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mad_00011414.viewModels.AboutMovieView
import com.example.mad_00011414.viewModels.MoviesListView
import com.example.mad_00011414.viewModels.NewMovieView

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "moviesList"
    ) {
        composable("moviesList") {
            MoviesListView(
                onMovieClick = { movieId ->
                    navController.navigate("aboutMovie/$movieId")
                },
                navController
            )
        }
        composable(
            route = "aboutMovie/{movieId}"
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("movieId")?.let {
                AboutMovieView(it, navController)
            }
        }
        composable(
            route = "newMovie"
        ) {
            NewMovieView(navController)
        }
    }
}
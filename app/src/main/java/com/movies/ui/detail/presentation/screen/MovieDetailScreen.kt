package com.movies.ui.detail.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.movies.ui.detail.presentation.compose.MovieDetailsPage
import com.movies.ui.detail.presentation.viewmodel.MovieDetailViewModel

/**
 * Created by Pranav Bhoraskar
 */
@Composable
fun MovieDetailScreen(
    viewModel: MovieDetailViewModel,
    navController: NavHostController,
    onSimilarMovieClicked: (Int) -> Unit
) {
    val movieDetailResponseState by viewModel.movieDetailResponseState.collectAsState()
    val similarMoviesState by viewModel.similarMoviesState.collectAsState()
    val loadingState by viewModel.loadingState.collectAsState()
    MovieDetailsPage(
        movieDetailResponseState = movieDetailResponseState,
        similarMoviesState = similarMoviesState,
        loadingState = loadingState,
        onBackButtonClicked = { navController.popBackStack() },
        onSimilarMovieClicked = onSimilarMovieClicked
    )
}
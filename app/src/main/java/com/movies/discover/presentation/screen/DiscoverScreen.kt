package com.movies.discover.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.movies.discover.presentation.compose.DiscoverMoviesPage
import com.movies.discover.presentation.viewmodel.DiscoverViewModel

/**
 * Created by Pranav Bhoraskar
 */
@Composable
fun DiscoverScreen(
    viewModel: DiscoverViewModel,
    onMovieClicked: (Int) -> Unit
) {
    val discoverResponseState by viewModel.discoverResponseState.collectAsState()
    val loadingState by viewModel.loadingState.collectAsState()
//    LaunchedEffect(key1 = true) {
//        viewModel.getDiscoverMovies()
//    }
    DiscoverMoviesPage(
        discoverResponseState = discoverResponseState,
        loadingState = loadingState,
        onMovieClicked = onMovieClicked
    )
}
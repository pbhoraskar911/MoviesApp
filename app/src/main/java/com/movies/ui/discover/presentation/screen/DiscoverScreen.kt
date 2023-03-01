package com.movies.ui.discover.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.movies.ui.discover.presentation.compose.DiscoverMoviesPage
import com.movies.ui.discover.presentation.viewmodel.DiscoverViewModel

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
    DiscoverMoviesPage(
        discoverResponseState = discoverResponseState,
        loadingState = loadingState,
        onMovieClicked = onMovieClicked
    )
}
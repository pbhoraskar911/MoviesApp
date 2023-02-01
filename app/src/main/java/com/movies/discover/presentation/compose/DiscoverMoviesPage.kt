package com.movies.discover.presentation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.movies.discover.domain.model.Results
import com.movies.discover.presentation.viewmodel.DiscoverScreenState
import com.movies.ui.compose.molecules.ProgressIndicatorMolecule
import com.movies.utils.ProgressBarState

/**
 * Created by Pranav Bhoraskar
 */
@Composable
fun DiscoverMoviesPage(
    discoverResponseState: DiscoverScreenState,
    loadingState: ProgressBarState,
    onMovieClicked: (Int) -> Unit
) {
    DiscoverMoviesPageUi(
        listOfMovies = discoverResponseState.discoverResponseState,
        loadingState = loadingState,
        onMovieClicked = onMovieClicked
    )
}

@Composable
fun DiscoverMoviesPageUi(
    listOfMovies: List<Results>?,
    loadingState: ProgressBarState,
    onMovieClicked: (Int) -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (!listOfMovies.isNullOrEmpty()) {
            DiscoverCardWidget(moviesList = listOfMovies, onMovieClicked = onMovieClicked)
        }
        ProgressIndicatorMolecule(isLoading = loadingState == ProgressBarState.Loading)
    }
}
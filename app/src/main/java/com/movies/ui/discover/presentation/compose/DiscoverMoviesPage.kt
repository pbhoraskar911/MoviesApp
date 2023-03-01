package com.movies.ui.discover.presentation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.movies.data.model.Results
import com.movies.ui.discover.presentation.viewmodel.DiscoverScreenState
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoverMoviesPageUi(
    listOfMovies: List<Results>?,
    loadingState: ProgressBarState,
    onMovieClicked: (Int) -> Unit
) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "Movies") },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface,
                titleContentColor = MaterialTheme.colorScheme.onSurface
            )
        )
    }) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            if (!listOfMovies.isNullOrEmpty()) {
                DiscoverCardWidget(moviesList = listOfMovies, onMovieClicked = onMovieClicked)
            }
            ProgressIndicatorMolecule(isLoading = loadingState == ProgressBarState.Loading)
        }
    }
}
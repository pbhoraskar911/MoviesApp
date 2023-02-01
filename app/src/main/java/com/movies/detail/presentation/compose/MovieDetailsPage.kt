package com.movies.detail.presentation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.movies.detail.presentation.viewmodel.MovieDetailScreenState
import com.movies.ui.compose.molecules.ProgressIndicatorMolecule
import com.movies.utils.ProgressBarState


/**
 * Created by Pranav Bhoraskar
 */
@Composable
fun MovieDetailsPage(
    movieDetailResponseState: MovieDetailScreenState,
    loadingState: ProgressBarState
) {
    MovieDetailPageUi(
        movieDetailResponseState = movieDetailResponseState,
        loadingState = loadingState
    )
}

@Composable
fun MovieDetailPageUi(
    movieDetailResponseState: MovieDetailScreenState,
    loadingState: ProgressBarState
) {
    Box(modifier = Modifier.fillMaxSize()) {
        MovieDetailsWidget(movieDetailResponseState.movieDetailResponseState)
        ProgressIndicatorMolecule(isLoading = loadingState == ProgressBarState.Loading)
    }
}

@file:OptIn(ExperimentalMaterial3Api::class)

package com.movies.ui.detail.presentation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.movies.ui.detail.presentation.viewmodel.MovieDetailScreenState
import com.movies.ui.detail.presentation.viewmodel.SimilarMoviesState
import com.movies.ui.compose.molecules.ProgressIndicatorMolecule
import com.movies.utils.ProgressBarState

/**
 * Created by Pranav Bhoraskar
 */
@Composable
fun MovieDetailsPage(
    movieDetailResponseState: MovieDetailScreenState,
    similarMoviesState: SimilarMoviesState,
    loadingState: ProgressBarState,
    onBackButtonClicked: () -> Unit,
    onSimilarMovieClicked: (Int) -> Unit
) {
    MovieDetailPageUi(
        movieDetailResponseState = movieDetailResponseState,
        similarMoviesState = similarMoviesState,
        loadingState = loadingState,
        onBackButtonClicked = { onBackButtonClicked() },
        onSimilarMovieClicked = onSimilarMovieClicked
    )
}

@Composable
fun MovieDetailPageUi(
    movieDetailResponseState: MovieDetailScreenState,
    similarMoviesState: SimilarMoviesState,
    loadingState: ProgressBarState,
    onBackButtonClicked: () -> Unit,
    onSimilarMovieClicked: (Int) -> Unit
) {
    Scaffold(topBar = {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = { onBackButtonClicked() }) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back Arrow",
                        modifier = Modifier.padding(start = 12.dp)
                    )
                }
            },
            title = { movieDetailResponseState.movieDetailResponseState?.title },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface,
                titleContentColor = MaterialTheme.colorScheme.onSurface
            )
        )
    }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            MovieDetailsWidget(
                movieDetailResponse = movieDetailResponseState.movieDetailResponseState,
                similarMoviesResponse = similarMoviesState.similarMoviesResponseState,
                onSimilarMovieClicked = onSimilarMovieClicked
            )
            ProgressIndicatorMolecule(isLoading = loadingState == ProgressBarState.Loading)
        }
    }
}

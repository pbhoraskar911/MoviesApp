package com.movies.discover.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.movies.discover.domain.model.Results
import com.movies.utils.getMoviePoster

/**
 * Created by Pranav Bhoraskar
 */
@Composable
fun DiscoverCardWidget(moviesList: List<Results>?, onMovieClicked: (Int) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            if (moviesList.isNullOrEmpty()) return@LazyVerticalGrid
            items(moviesList.size) { index ->
                val movie = moviesList[index]
                DiscoverCardItemMolecule(
                    imageUrl = movie.getMoviePoster(),
                    title = movie.originalTitle.orEmpty(),
                    releaseDate = movie.releaseDate.orEmpty(),
                    movieId = movie.id,
                    onMovieClicked = onMovieClicked
                )
            }
        }
    )
}
package com.movies.discover.presentation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.movies.ui.compose.atoms.CoilImageAtomCrop

/**
 * Created by Pranav Bhoraskar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoverCardItemMolecule(
    imageUrl: String,
    title: String,
    releaseDate: String,
    movieId: Int?,
    onMovieClicked: (Int) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.height(height = 240.dp),
        onClick = {
            movieId?.let { onMovieClicked.invoke(it) }
        },
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            CoilImageAtomCrop(
                imageUrl = imageUrl,
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}
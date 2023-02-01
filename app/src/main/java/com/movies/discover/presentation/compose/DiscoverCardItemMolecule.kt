package com.movies.discover.presentation.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movies.ui.compose.atoms.CoilImageAtomCrop
import com.movies.ui.compose.atoms.SpacerVerticalAtom
import com.movies.ui.compose.atoms.TextAtomBold
import com.movies.ui.compose.atoms.TextAtomRegular

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
        modifier = Modifier.size(width = 140.dp, height = 240.dp),
        onClick = {
            movieId?.let { onMovieClicked.invoke(it) }
        },
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            CoilImageAtomCrop(
                imageUrl = imageUrl,
                modifier = Modifier.fillMaxSize(),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .align(Alignment.BottomStart)
                    .padding(all = 6.dp)
            ) {
                TextAtomBold(text = title, textColor = Color.White, fontSize = 14.sp)
                SpacerVerticalAtom(height = 2.dp)
                TextAtomRegular(text = releaseDate, textColor = Color.White, fontSize = 12.sp)
            }
        }
    }
}
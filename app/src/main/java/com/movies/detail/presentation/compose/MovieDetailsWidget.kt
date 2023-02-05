package com.movies.detail.presentation.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movies.detail.domain.model.MovieDetailResponse
import com.movies.ui.compose.atoms.CoilImageAtomCrop
import com.movies.ui.compose.atoms.SpacerVerticalAtom
import com.movies.ui.compose.atoms.TextAtomBold
import com.movies.ui.compose.atoms.TextAtomMedium
import com.movies.ui.compose.atoms.TextAtomRegular
import com.movies.ui.compose.atoms.TextAtomRegularMultipleLines
import com.movies.utils.getProcessedImageUrl

/**
 * Created by Pranav Bhoraskar
 */
@Composable
fun MovieDetailsWidget(movieDetailResponse: MovieDetailResponse?) {
    movieDetailResponse?.let { response ->
        Column(modifier = Modifier.fillMaxSize()) {
            CoilImageAtomCrop(
                imageUrl = response.backdropPath.getProcessedImageUrl(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            SpacerVerticalAtom(height = 16.dp)
            MovieDetailsMolecule(response)
        }
    }
}

@Composable
fun MovieDetailsMolecule(response: MovieDetailResponse) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        MovieTitleMolecule(response.title, response.tagline, response.status)
        SpacerVerticalAtom(height = 16.dp)
        MovieInfoMolecule(response)
        SpacerVerticalAtom(height = 12.dp)
        MovieOverviewMolecule(response.overview)
    }
}

@Composable
fun MovieOverviewMolecule(overview: String?) {
    TextAtomBold(
        text = "Overview",
        fontSize = 18.sp
    )
    SpacerVerticalAtom(height = 4.dp)
    TextAtomRegularMultipleLines(
        text = overview.orEmpty(),
        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
        textAlignCenter = false
    )
}

@Composable
fun MovieInfoMolecule(response: MovieDetailResponse) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CardComposable(response.releaseDate.orEmpty(), "Release Date")
        CardComposable(response.popularity.toString(), "Popularity")
        CardComposable(response.voteAverage.toString(), "Votes")
    }
}

@Composable
fun MovieTitleMolecule(title: String?, tagline: String?, status: String?) {
    TextAtomBold(
        text = title.orEmpty(),
        fontSize = 20.sp
    )
    SpacerVerticalAtom(height = 4.dp)
    TextAtomMedium(
        text = tagline.orEmpty(),
        fontSize = 14.sp
    )
}

@Composable
fun CardComposable(data: String, label: String) {
    Card(
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        modifier = Modifier.size(100.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextAtomMedium(
                text = data,
                fontSize = 14.sp
            )
            SpacerVerticalAtom(height = 4.dp)
            TextAtomRegular(
                text = label,
                fontSize = 14.sp
            )
        }
    }
}

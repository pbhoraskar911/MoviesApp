package com.movies.ui.compose.atoms

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

/**
 * Created by Pranav Bhoraskar
 */
@Composable
fun CoilImageAtomCrop(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "asyncImage",
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}

@Composable
fun CoilImageAtomCropRounded(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "asyncImage",
        contentScale = ContentScale.Crop,
        modifier = modifier.clip(CircleShape)
    )
}
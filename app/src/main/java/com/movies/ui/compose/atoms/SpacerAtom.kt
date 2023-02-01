package com.movies.ui.compose.atoms

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

/**
 * Created by Pranav Bhoraskar
 */
@Composable
fun SpacerVerticalAtom(height: Dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun SpacerHorizontalAtom(width: Dp) {
    Spacer(modifier = Modifier.width(width))
}
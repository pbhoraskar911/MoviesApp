package com.movies.detail.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.movies.detail.presentation.viewmodel.MovieDetailViewModel
import com.movies.ui.compose.atoms.TextAtomBold

/**
 * Created by Pranav Bhoraskar
 */
@Composable
fun MovieDetailScreen(
    viewModel: MovieDetailViewModel,
    navController: NavHostController
) {
    TextAtomBold(
        text = "MovieId -- ${viewModel.getClickedMovieId()}",
        textColor = Color.White,
        fontSize = 20.sp
    )
}
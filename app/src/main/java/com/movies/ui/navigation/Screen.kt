package com.movies.ui.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.movies.utils.Constants.KEY_MOVIE_ID

/**
 * Created by Pranav Bhoraskar
 */
sealed class Screen(open val route: String = "", val arguments: List<NamedNavArgument>) {

    object Discover : Screen("discover", emptyList())

    object MovieDetail : Screen(
        route = "movie_detail",
        arguments = listOf(navArgument(KEY_MOVIE_ID) {
            type = NavType.IntType
        })
    )
}
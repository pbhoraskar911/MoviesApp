@file:OptIn(ExperimentalMaterial3Api::class)

package com.movies.ui.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.movies.detail.presentation.screen.MovieDetailScreen
import com.movies.detail.presentation.viewmodel.MovieDetailViewModel
import com.movies.discover.presentation.screen.DiscoverScreen
import com.movies.discover.presentation.viewmodel.DiscoverViewModel
import com.movies.ui.navigation.Screen
import com.movies.ui.theme.MoviesTheme
import com.movies.utils.Constants.KEY_MOVIE_ID
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Pranav Bhoraskar
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviesTheme {
                MainScreen()
            }
        }
    }

}

@Composable
private fun MainScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.surface,
    ) {
        MoviesNavigation()
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun MoviesNavigation() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.Discover.route,
    ) {
        addDiscoverScreen(navController)
        addMovieDetailScreen(navController)
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addDiscoverScreen(navController: NavHostController) {
    composable(
        route = Screen.Discover.route,
        enterTransition = {
            when (initialState.destination.route) {
                Screen.MovieDetail.route ->
                    slideInHorizontally(
                        initialOffsetX = { 300 },
                        animationSpec = tween(300)
                    ) + fadeIn(animationSpec = tween(300))
                else -> null
            }
        },
        exitTransition = {
            when (targetState.destination.route) {
                Screen.MovieDetail.route ->
                    slideOutHorizontally(
                        targetOffsetX = { -300 },
                        animationSpec = tween(300)
                    ) + fadeOut(animationSpec = tween(300))
                else -> null
            }
        },
        popEnterTransition = {
            when (initialState.destination.route) {
                Screen.MovieDetail.route ->
                    slideInHorizontally(
                        initialOffsetX = { -300 },
                        animationSpec = tween(300)
                    ) + fadeIn(animationSpec = tween(300))
                else -> null
            }
        }
    ) {
        val discoverViewModel: DiscoverViewModel = hiltViewModel()
        DiscoverScreen(viewModel = discoverViewModel) { movieId ->
            navController.navigate("${Screen.MovieDetail.route}/${movieId}")
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.addMovieDetailScreen(navController: NavHostController) {
    composable(
        route = Screen.MovieDetail.route + "/{$KEY_MOVIE_ID}",
        enterTransition = {
            when (initialState.destination.route) {
                Screen.Discover.route ->
                    slideInHorizontally(
                        initialOffsetX = { 300 },
                        animationSpec = tween(300)
                    ) + fadeIn(animationSpec = tween(300))
                else -> null
            }
        },
        exitTransition = {
            when (targetState.destination.route) {
                Screen.Discover.route ->
                    slideOutHorizontally(
                        targetOffsetX = { -300 },
                        animationSpec = tween(300)
                    ) + fadeOut(animationSpec = tween(300))
                else -> null
            }
        },
        popExitTransition = {
            when (targetState.destination.route) {
                Screen.Discover.route ->
                    slideOutHorizontally(
                        targetOffsetX = { 300 },
                        animationSpec = tween(300)
                    ) + fadeOut(animationSpec = tween(300))
                else -> null
            }
        }
    ) {
        val movieDetailViewModel: MovieDetailViewModel = hiltViewModel()
        MovieDetailScreen(
            viewModel = movieDetailViewModel,
            navController = navController
        )
    }
}

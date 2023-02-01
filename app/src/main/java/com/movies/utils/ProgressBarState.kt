package com.movies.utils

/**
 * Created by Pranav Bhoraskar
 *
 * Util class to handle the state of Progress Bar
 */
sealed class ProgressBarState {
    object Loading : ProgressBarState()
    object Idle : ProgressBarState()
}
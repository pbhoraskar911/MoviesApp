package com.movies.detail.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movies.detail.domain.MovieDetailUseCase
import com.movies.utils.Constants.KEY_MOVIE_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Pranav Bhoraskar
 */
@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailUseCase: MovieDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var movieId = ""

    init {
        viewModelScope.launch {
            movieId = savedStateHandle.get<String>(KEY_MOVIE_ID).orEmpty()
//            movieDetailUseCase.fetchMovieDetails(movieId)
        }
    }


    fun getClickedMovieId() = movieId

}
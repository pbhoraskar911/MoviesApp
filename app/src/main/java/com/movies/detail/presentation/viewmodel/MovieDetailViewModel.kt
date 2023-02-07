package com.movies.detail.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movies.data.network.NetworkResult
import com.movies.detail.domain.model.MovieDetailResponse
import com.movies.detail.domain.usecase.MovieDetailUseCase
import com.movies.similarmovies.domain.model.SimilarMoviesResponse
import com.movies.similarmovies.domain.usecase.SimilarMoviesUseCase
import com.movies.utils.Constants.KEY_MOVIE_ID
import com.movies.utils.ProgressBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Pranav Bhoraskar
 */
@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailUseCase: MovieDetailUseCase,
    private val similarMoviesUseCase: SimilarMoviesUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _loadingState = MutableStateFlow<ProgressBarState>(ProgressBarState.Idle)
    val loadingState: StateFlow<ProgressBarState> get() = _loadingState

    private val _movieDetailResponseState = MutableStateFlow(MovieDetailScreenState())
    val movieDetailResponseState: StateFlow<MovieDetailScreenState> get() = _movieDetailResponseState

    private val _similarMoviesState = MutableStateFlow(SimilarMoviesState())
    val similarMoviesState: StateFlow<SimilarMoviesState> get() = _similarMoviesState

    init {
        fetchMovieDetails(savedStateHandle.get<String>(KEY_MOVIE_ID).orEmpty())
    }

    private fun fetchMovieDetails(movieId: String) = viewModelScope.launch {
        movieDetailUseCase.fetchMovieDetails(movieId).collect {
            when (val networkResult = NetworkResult.Success(it).data) {
                is NetworkResult.Success -> {
                    val movieDetailResponseState =
                        MovieDetailScreenState(movieDetailResponseState = networkResult.data)
                    _movieDetailResponseState.value = movieDetailResponseState
                    _loadingState.value = ProgressBarState.Idle
                    fetchSimilarMovies(
                        movieId = movieId,
                        isoSpokenLanguage = movieDetailResponseState.movieDetailResponseState?.spokenLanguages?.get(
                            0
                        )?.isoSpokenLanguage
                    )
                }
                is NetworkResult.Loading -> {
                    _loadingState.value = ProgressBarState.Loading
                }
                else -> {
                    _loadingState.value = ProgressBarState.Idle
                }
            }
        }
    }

    private suspend fun fetchSimilarMovies(movieId: String, isoSpokenLanguage: String?) {
        similarMoviesUseCase.fetchSimilarMovies(movieId = movieId, language = isoSpokenLanguage)
            .collect {
                when (val networkResult = NetworkResult.Success(it).data) {
                    is NetworkResult.Success -> {
                        val similarMoviesResponse =
                            SimilarMoviesState(similarMoviesResponseState = networkResult.data)
                        _similarMoviesState.value = similarMoviesResponse
                        _loadingState.value = ProgressBarState.Idle
                    }
                    is NetworkResult.Loading -> {
                        _loadingState.value = ProgressBarState.Loading
                    }
                    else -> {
                        _loadingState.value = ProgressBarState.Idle
                    }
                }
            }
    }
}

data class MovieDetailScreenState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val movieDetailResponseState: MovieDetailResponse? = null
)

data class SimilarMoviesState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val similarMoviesResponseState: SimilarMoviesResponse? = null
)
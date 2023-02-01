package com.movies.discover.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movies.data.network.NetworkResult
import com.movies.discover.domain.model.Results
import com.movies.discover.domain.usecase.DiscoverUseCase
import com.movies.utils.ProgressBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Pranav Bhoraskar
 */
@HiltViewModel
class DiscoverViewModel @Inject constructor(private val discoverUseCase: DiscoverUseCase) :
    ViewModel() {
    private val _loadingState = MutableStateFlow<ProgressBarState>(ProgressBarState.Idle)
    val loadingState: StateFlow<ProgressBarState> get() = _loadingState

    private val _discoverResponseState = MutableStateFlow(DiscoverScreenState())
    val discoverResponseState: StateFlow<DiscoverScreenState> get() = _discoverResponseState

    init {
        getDiscoverMovies()
    }

    private fun getDiscoverMovies() = viewModelScope.launch(Dispatchers.IO) {
        discoverUseCase.fetchMovies().collect {
            when (val networkResult: NetworkResult<List<Results>?> =
                NetworkResult.Success(it).data) {
                is NetworkResult.Success -> {
                    delay(2000)
                    val discoverScreenState = DiscoverScreenState(discoverResponseState = networkResult.data)
                    _discoverResponseState.value = discoverScreenState
                    _loadingState.value = ProgressBarState.Idle
                }
                is NetworkResult.Loading -> {
                    _loadingState.value = ProgressBarState.Loading
                }
                else -> {
                    _loadingState.value = ProgressBarState.Idle
                    null
                }
            }
        }
    }
}

data class DiscoverScreenState(
    val progressBarState: ProgressBarState = ProgressBarState.Idle,
    val discoverResponseState: List<Results>? = listOf()
)
package com.movies.domain.usecase

import com.movies.data.network.NetworkResult
import com.movies.data.repository.MovieDetailRepository
import com.movies.data.model.MovieDetailResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Pranav Bhoraskar
 */
interface MovieDetailUseCase {
    suspend fun fetchMovieDetails(movieId: String): Flow<NetworkResult<MovieDetailResponse?>>
}

class MovieDetailUseCaseImpl @Inject constructor(private val movieDetailRepository: MovieDetailRepository) :
    MovieDetailUseCase {
    override suspend fun fetchMovieDetails(movieId: String) =
        movieDetailRepository.fetchMovieDetails(movieId)
}
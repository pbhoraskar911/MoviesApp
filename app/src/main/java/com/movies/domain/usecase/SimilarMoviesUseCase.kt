package com.movies.domain.usecase

import com.movies.data.network.NetworkResult
import com.movies.data.repository.SimilarMoviesRepository
import com.movies.data.model.SimilarMoviesResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Pranav Bhoraskar
 */
interface SimilarMoviesUseCase {
    suspend fun fetchSimilarMovies(
        movieId: String,
        language: String?
    ): Flow<NetworkResult<SimilarMoviesResponse?>>
}

class SimilarMoviesUseCaseImpl @Inject constructor(private val similarMoviesRepository: SimilarMoviesRepository) :
    SimilarMoviesUseCase {
    override suspend fun fetchSimilarMovies(
        movieId: String,
        language: String?
    ) = similarMoviesRepository.fetchSimilarMovies(movieId = movieId, language = language)
}
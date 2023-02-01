package com.movies.detail.domain

import com.movies.data.network.NetworkResult
import com.movies.data.repository.MovieDetailRepository
import com.movies.discover.domain.model.Results
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Pranav Bhoraskar
 */
interface MovieDetailUseCase {
//    suspend fun fetchMovieDetails(movieId: String): Flow<NetworkResult<List<Results>?>>
}

class MovieDetailUseCaseImpl @Inject constructor(private val movieDetailRepository: MovieDetailRepository) :
    MovieDetailUseCase {
//    override suspend fun fetchMovieDetails(movieId: String) =
//        movieDetailRepository.fetchMovieDetails(movieId)
}
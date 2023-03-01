package com.movies.data.repository

import com.movies.data.network.NetworkResult
import com.movies.data.network.NetworkService
import com.movies.data.model.SimilarMoviesResponse
import com.movies.utils.queryParamHashMap
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by Pranav Bhoraskar
 */
interface SimilarMoviesRepository {
    suspend fun fetchSimilarMovies(
        movieId: String,
        language: String?
    ): Flow<NetworkResult<SimilarMoviesResponse?>>
}

class SimilarMoviesRepositoryImpl @Inject constructor(
    private val networkService: NetworkService
) : SimilarMoviesRepository {
    override suspend fun fetchSimilarMovies(
        movieId: String,
        language: String?
    ): Flow<NetworkResult<SimilarMoviesResponse?>> = flow {
        emit(NetworkResult.Loading)
        try {
            val response =
                networkService.fetchSimilarMovies(movieId, queryParamHashMap(language ?: "en"))
            if (response?.isSuccessful == true) emit(NetworkResult.Success(response.body()))
        } catch (e: Exception) {
            emit(NetworkResult.Error(e))
        }
    }
}
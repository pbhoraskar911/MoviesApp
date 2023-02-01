package com.movies.data.repository

import com.movies.data.network.NetworkResult
import com.movies.data.network.NetworkService
import com.movies.discover.domain.model.Results
import com.movies.utils.queryParamHashMap
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by Pranav Bhoraskar
 */
interface MovieDetailRepository {
//    suspend fun fetchMovieDetails(movieId: String): Flow<NetworkResult<List<Results>?>>
}

class MovieDetailRepositoryImpl @Inject constructor(
    private val networkService: NetworkService
) : MovieDetailRepository {
    /*override suspend fun fetchMovieDetails(movieId: String): Flow<NetworkResult<List<Results>?>> =
        flow {
            emit(NetworkResult.Loading)
            try {
                val response = networkService.fetchMoviesDetails(movieId, queryParamHashMap())
                if (response?.isSuccessful == true) emit(NetworkResult.Success(response.body()?.results))
            } catch (e: Exception) {
                emit(NetworkResult.Error(e))
            }
        }*/
}



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
interface DiscoverRepository {
    suspend fun fetchMovies(): Flow<NetworkResult<List<Results>?>>
}

class DiscoverRepositoryImpl @Inject constructor(
    private val networkService: NetworkService
) : DiscoverRepository {

    override suspend fun fetchMovies(): Flow<NetworkResult<List<Results>?>> = flow {
        emit(NetworkResult.Loading)
        try {
            val response = networkService.discoverMovies(queryParamHashMap())
            if (response?.isSuccessful == true) emit(NetworkResult.Success(response.body()?.results))
        } catch (e: Exception) {
            emit(NetworkResult.Error(e))
        }
    }
}

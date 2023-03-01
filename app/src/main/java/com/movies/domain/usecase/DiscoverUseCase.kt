package com.movies.domain.usecase

import com.movies.data.network.NetworkResult
import com.movies.data.repository.DiscoverRepository
import com.movies.data.model.Results
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Pranav Bhoraskar
 */
interface DiscoverUseCase {
    suspend fun fetchMovies(): Flow<NetworkResult<List<Results>?>>
}

class DiscoverUseCaseImpl @Inject constructor(private val discoverRepository: DiscoverRepository) :
    DiscoverUseCase {
    override suspend fun fetchMovies(): Flow<NetworkResult<List<Results>?>> {
        return discoverRepository.fetchMovies()
    }
}
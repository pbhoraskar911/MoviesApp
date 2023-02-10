package com.movies.di

import com.movies.data.network.NetworkService
import com.movies.data.repository.DiscoverRepository
import com.movies.data.repository.DiscoverRepositoryImpl
import com.movies.data.repository.MovieDetailRepository
import com.movies.data.repository.MovieDetailRepositoryImpl
import com.movies.data.repository.SimilarMoviesRepository
import com.movies.data.repository.SimilarMoviesRepositoryImpl
import com.movies.detail.domain.usecase.MovieDetailUseCase
import com.movies.detail.domain.usecase.MovieDetailUseCaseImpl
import com.movies.discover.domain.usecase.DiscoverUseCase
import com.movies.discover.domain.usecase.DiscoverUseCaseImpl
import com.movies.similarmovies.domain.usecase.SimilarMoviesUseCase
import com.movies.similarmovies.domain.usecase.SimilarMoviesUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Pranav Bhoraskar
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideDiscoverUseCase(
        repository: DiscoverRepository
    ): DiscoverUseCase {
        return DiscoverUseCaseImpl(repository)
    }

    @Singleton
    @Provides
    fun provideDiscoverRepository(
        networkService: NetworkService
    ): DiscoverRepository {
        return DiscoverRepositoryImpl(networkService)
    }

    @Singleton
    @Provides
    fun provideMovieDetailUseCase(
        repository: MovieDetailRepository
    ): MovieDetailUseCase {
        return MovieDetailUseCaseImpl(repository)
    }

    @Singleton
    @Provides
    fun provideMovieDetailRepository(
        networkService: NetworkService
    ): MovieDetailRepository {
        return MovieDetailRepositoryImpl(networkService)
    }

    @Singleton
    @Provides
    fun provideSimilarMoviesUseCase(
        repository: SimilarMoviesRepository
    ): SimilarMoviesUseCase {
        return SimilarMoviesUseCaseImpl(repository)
    }

    @Singleton
    @Provides
    fun provideSimilarMoviesRepository(
        networkService: NetworkService
    ): SimilarMoviesRepository {
        return SimilarMoviesRepositoryImpl(networkService)
    }
}
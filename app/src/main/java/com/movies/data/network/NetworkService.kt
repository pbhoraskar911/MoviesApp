package com.movies.data.network

import com.movies.data.model.MovieDetailResponse
import com.movies.data.model.DiscoverResponse
import com.movies.data.model.SimilarMoviesResponse
import com.movies.utils.Urls.DISCOVER_URL
import com.movies.utils.Urls.MOVIE_DETAIL_URL
import com.movies.utils.Urls.NOW_PLAYING_MOVIE_URL
import com.movies.utils.Urls.POPULAR_MOVIE_URL
import com.movies.utils.Urls.SIMILAR_MOVIE_URL
import com.movies.utils.Urls.TOP_RATED_MOVIE_URL
import com.movies.utils.Urls.UPCOMING_MOVIE_URL
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * Created by Pranav Bhoraskar
 */
interface NetworkService {

    @GET(DISCOVER_URL)
    suspend fun discoverMovies(@QueryMap queryMap: Map<String, String>): Response<DiscoverResponse?>?

    @GET(MOVIE_DETAIL_URL)
    suspend fun fetchMoviesDetails(
        @Path("movie_id") movieId: String,
        @QueryMap queryMap: Map<String, String>
    ): Response<MovieDetailResponse?>?

    @GET(SIMILAR_MOVIE_URL)
    suspend fun fetchSimilarMovies(
        @Path("movie_id") movieId: String,
        @QueryMap queryMap: Map<String, String> // send language from movie details
    ): Response<SimilarMoviesResponse?>?

    @GET(NOW_PLAYING_MOVIE_URL)
    suspend fun fetchNowPlayingMovies(
        @Path("movie_id") movieId: String,
        @QueryMap queryMap: Map<String, String> // send language from movie details, and region
    ): Response<DiscoverResponse?>?

    @GET(POPULAR_MOVIE_URL)
    suspend fun fetchPopularMovies(
        @Path("movie_id") movieId: String,
        @QueryMap queryMap: Map<String, String> // send language from movie details, and region
    ): Response<DiscoverResponse?>?

    @GET(TOP_RATED_MOVIE_URL)
    suspend fun fetchTopRatedMovies(
        @Path("movie_id") movieId: String,
        @QueryMap queryMap: Map<String, String> // send language from movie details, and region
    ): Response<DiscoverResponse?>?

    @GET(UPCOMING_MOVIE_URL)
    suspend fun fetchUpcomingMovies(
        @Path("movie_id") movieId: String,
        @QueryMap queryMap: Map<String, String> // send language from movie details, and region
    ): Response<DiscoverResponse?>?


}
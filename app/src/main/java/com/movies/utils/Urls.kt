package com.movies.utils

/**
 * Created by Pranav Bhoraskar
 */
object Urls {

    private const val API_VERSION = 3
    const val BASE_URL: String = "https://api.themoviedb.org/$API_VERSION/"
    const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500/"

    private const val MOVIE = "movie"
    private const val MOVIE_ID = "movie_id"
    const val DISCOVER_URL = "discover/$MOVIE"
    const val MOVIE_DETAIL_URL = "$MOVIE/{$MOVIE_ID}"
    const val SIMILAR_MOVIE_URL = "$MOVIE/{$MOVIE_ID}/similar"
    const val NOW_PLAYING_MOVIE_URL = "$MOVIE/now_playing"
    const val POPULAR_MOVIE_URL = "$MOVIE/popular"
    const val TOP_RATED_MOVIE_URL = "$MOVIE/top_rated"
    const val UPCOMING_MOVIE_URL = "$MOVIE/upcoming"

}
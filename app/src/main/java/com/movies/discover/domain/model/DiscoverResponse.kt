package com.movies.discover.domain.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Pranav Bhoraskar
 */
data class DiscoverResponse constructor(
    val pages: String? = null,
    val results: List<Results>? = null,
    @SerializedName("total_results") val totalResults: Int? = null,
    @SerializedName("total_pages") val totalPages: Int? = null
)

data class Results constructor(
    val id: Int? = null,
    val title: String? = null,
    val video: Boolean? = null,
    val adult: Boolean? = false,
    val overview: String? = null,
    val popularity: Double? = null,
    @SerializedName("poster_path") val posterPath: String? = null,
    @SerializedName("release_date") val releaseDate: String? = null,
    @SerializedName("genre_ids") val genreIds: List<Int>? = null,
    @SerializedName("original_title") val originalTitle: String? = null,
    @SerializedName("original_language") val originalLanguage: String? = null,
    @SerializedName("backdrop_path") val backdropPath: String? = null,
    @SerializedName("vote_count") val voteCount: Int? = null,
    @SerializedName("vote_average") val voteAverage: Double? = null
)

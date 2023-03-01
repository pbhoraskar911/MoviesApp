package com.movies.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Pranav Bhoraskar
 */
data class SimilarMoviesResponse(
    val pages: String? = null,
    val results: List<Results>? = null,
    @SerializedName("total_results") val totalResults: Int? = null,
    @SerializedName("total_pages") val totalPages: Int? = null
)
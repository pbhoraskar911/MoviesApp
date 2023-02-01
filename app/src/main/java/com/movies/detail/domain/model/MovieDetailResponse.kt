package com.movies.detail.domain.model

import com.google.gson.annotations.SerializedName


/**
 * Created by Pranav Bhoraskar
 */
data class MovieDetailResponse(
    val adult: Boolean?,
    @SerializedName("backdrop_path")
    val backdropPath: String,
    val budget: Int?,
    val genres: List<MovieGenres>?,
    val homepage: String?,
    @SerializedName("id") val movieId: Int?,
    @SerializedName("imdb_id") val imdbId: String?,
    @SerializedName("original_language") val originalLanguage: String?,
    @SerializedName("original_title") val originalTitle: String?,
    @SerializedName("poster_path") val posterPath: String?,
    val overview: String?,
    val popularity: Double?,
    @SerializedName("production_companies") val productionCompanies: List<ProductionCompanies>?,
    @SerializedName("production_countries") val productionCountries: List<ProductionCountries>?,
    @SerializedName("release_date") val releaseDate: String?,
    val runtime: Int?,
    val revenue: Int?,
    @SerializedName("spoken_languages") val spokenLanguages: List<SpokenLanguages>?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    @SerializedName("vote_average") val voteAverage: Double?,
    @SerializedName("vote_count") val voteCount: Double?
)

data class MovieGenres(
    val id: Int?,
    val name: String?
)

data class ProductionCompanies(
    val id: Int?,
    @SerializedName("logo_path") val logoPath: String?,
    val name: String?,
    @SerializedName("origin_country") val originCountry: String?,
)

data class ProductionCountries(
    @SerializedName("iso_3166_1") val isoProductionCountryName: String?,
    val name: String?
)

data class SpokenLanguages(
    @SerializedName("iso_639_1") val isoSpokenLanguage: String?,
    val name: String?
)

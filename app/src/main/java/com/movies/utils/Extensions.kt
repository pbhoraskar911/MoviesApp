package com.movies.utils

import com.movies.BuildConfig
import com.movies.utils.Constants.CONSTANT_API_KEY
import com.movies.utils.Constants.MOVIE_LANGUAGE
import java.math.RoundingMode

/**
 * Created by Pranav Bhoraskar
 */
fun String?.getProcessedImageUrl() = Urls.BASE_IMAGE_URL + this

fun Double?.sanitizeNumber(): Double {
    this ?: return 0.0
    return this.toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
}

fun queryParamHashMap(language: String = "en") = hashMapOf(
    CONSTANT_API_KEY to BuildConfig.API_KEY,
    MOVIE_LANGUAGE to language
)

fun Double?.orZero() = this ?: 0.0

fun Int?.orZero() = this ?: 0
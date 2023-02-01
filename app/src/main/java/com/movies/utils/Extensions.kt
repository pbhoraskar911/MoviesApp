package com.movies.utils

import com.movies.BuildConfig
import com.movies.discover.domain.model.Results
import com.movies.utils.Constants.CONSTANT_API_KEY

/**
 * Created by Pranav Bhoraskar
 */
fun Results.getMoviePoster() = Urls.BASE_IMAGE_URL + this.posterPath.orEmpty()

fun queryParamHashMap() = hashMapOf(CONSTANT_API_KEY to BuildConfig.API_KEY)
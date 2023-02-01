package com.movies.data.network

import com.movies.utils.Urls.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Pranav Bhoraskar
 */
object Networking {

    private const val NETWORK_CALL_TIMEOUT = 60L

    fun create(): NetworkService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttpClientBuilder().build())
            .build()
            .create(NetworkService::class.java)
    }

    private fun getOkHttpClientBuilder(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .connectTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(NETWORK_CALL_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
    }
}
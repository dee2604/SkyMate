package com.dee2604.skymate.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkBuilder {
    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer OPEN_AI_API_KEY").build()
            chain.proceed(request)
        }
        .build()

    val meteoApiService: MeteoApiService by lazy {
        Retrofit.Builder().baseUrl("https://api.open-meteo.com/").addConverterFactory(
            GsonConverterFactory.create()
        ).client(okHttpClient).build().create(MeteoApiService::class.java)

    }

    val geminiApiService: OpenAiService by lazy {
        Retrofit.Builder().baseUrl("https://api.openai.com/")
            .addConverterFactory(
                GsonConverterFactory.create()
            ).client(okHttpClient).build().create(OpenAiService::class.java)
    }

}
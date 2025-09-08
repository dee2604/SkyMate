package com.dee2604.skymate.network

import com.dee2604.skymate.models.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface MeteoApiService {

    @GET("v1/forecast")
    suspend fun weatherData(
        @Query("latitude") lat: Double,
        @Query("longitude") long: Double,
        @Query("hourly") time: String = "temperature_2m,precipitation",
        @Query("timezone") timeZone: String = "auto"
    ): WeatherData
}

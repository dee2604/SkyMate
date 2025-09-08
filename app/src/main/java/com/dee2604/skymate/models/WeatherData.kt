package com.dee2604.skymate.models

data class WeatherData(
    val hourly: HourlyData
)

data class HourlyData(
    val time: List<String>,
    val temperature_2m: List<Double>,
    val precipitation: List<Double>? = null
)
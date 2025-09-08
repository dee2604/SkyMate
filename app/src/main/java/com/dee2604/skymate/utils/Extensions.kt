package com.dee2604.skymate.utils

import com.dee2604.skymate.models.WeatherData

fun WeatherData.toReadableForecast(): String {
    val sb = StringBuilder()
    for (i in hourly.time.indices step 3) { // every 3 hours
        val time = hourly.time[i].substring(11, 16) // get HH:mm
        val temp = hourly.temperature_2m[i]
        val precip = hourly.precipitation?.getOrNull(i) ?: 0.0
        sb.append("$time - ${temp}°C, Rain: ${precip}mm\n")
    }
    return sb.toString()
}

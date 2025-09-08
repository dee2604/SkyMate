package com.dee2604.skymate.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dee2604.skymate.models.Message
import com.dee2604.skymate.models.OpenAIRequest
import com.dee2604.skymate.network.NetworkBuilder
import com.dee2604.skymate.utils.toReadableForecast
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _aiSummary = MutableStateFlow("Loading Current Weather")
    var aiSummary = _aiSummary.asStateFlow()

    fun loadWeatherDataAndSummary(lat: Double, long: Double) {
        viewModelScope.launch {
            try {
                val forecast = NetworkBuilder.meteoApiService.weatherData(lat, long).toReadableForecast()

                val request = OpenAIRequest(
                    messages = listOf(
                        Message(
                            role = "user",
                            content = "Summarize this forecast:\n$forecast"
                        )
                    )
                )
                val response = NetworkBuilder.geminiApiService.generateSummary(request)

                _aiSummary.value = response.choices.firstOrNull()?.message?.content ?: "No Summary"
            } catch (e: Exception) {
                e.printStackTrace()
            }


        }
    }

}
package com.dee2604.skymate.network

import com.dee2604.skymate.models.OpenAIRequest
import com.dee2604.skymate.models.OpenAIResponse
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface OpenAiService {
    @Headers("Content-Type: application/json")
    @POST("v1/chat/completions")
    suspend fun generateSummary(
        @Body request: OpenAIRequest
    ): OpenAIResponse
}
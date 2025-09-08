# SkyMate

**Weather + AI Predictions** — Android app combining Meteo.com weather data with OpenAI-generated insights. Built in Kotlin using Jetpack Compose and MVVM architecture.

---

##  Overview

SkyMate fetches weather forecasts via Meteo.com API and enriches the data with natural-language insights and probability-driven predictions using the OpenAI API. It features a slick, reactive UI powered by Jetpack Compose and adheres to clean architectural principles (MVVM) for maintainability and testability.

---

##  Key Features

| Feature | Description |
|---------|-------------|
| **Current Weather & Forecasts** | Retrieves current conditions and 7-day forecasts from Meteo.com. |
| **AI Enrichment** | Uses OpenAI to produce human-friendly summaries, predict anomalies, and provide actionable advice (weather alerts). |
| **Modern UI** | Built using Jetpack Compose for smooth and reactive UI rendering. |
| **Clean Architecture** | Implements MVVM (Repository → UseCases → ViewModel → UI) for separation of concerns and testability. |
| **Kotlin + Coroutines** | Leverages Kotlin Coroutines. |

---

##  Tech Stack

- **Language**: Kotlin  
- **UI**: Jetpack Compose  
- **Architecture**: MVVM  
- **Networking**: Retrofit + OkHttp  
- **AI**: OpenAI API  
- **Concurrency**: Coroutines

---

##  Project Structure


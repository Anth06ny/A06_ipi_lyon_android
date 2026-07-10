package com.amonteiro.a06_ipi_lyon_android.data.remote

import com.amonteiro.a06_ipi_lyon_android.domain.model.Weather
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

//Suspend sera expliqué dans le chapitre des coroutines
suspend fun main() {
    val cities = WeatherApiDataSourceEasy.loadWeather("nice")

    for(c in cities) {
        println(c)
    }


    WeatherApiDataSourceEasy.close()
}

object WeatherApiDataSourceEasy {
    private const val API_URL =
        "https://www.amonteiro.fr/api/weather?cityname="

    //Création et réglage du client
    private val client = HttpClient {
        install(Logging) {
            //(import io.ktor.client.plugins.logging.Logger)
            logger = object : Logger {
                override fun log(message: String) {
                    println(message)
                }
            }
            level = LogLevel.INFO  // TRACE, HEADERS, BODY, etc.
        }
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 5000
        }
        //engine { proxy = ProxyBuilder.http("monproxy:1234") }
    }


    suspend fun loadWeather(cityName :String): List<Weather> {
        val response = client.get(API_URL + cityName)
        if (!response.status.isSuccess()) {
            throw Exception("Erreur API: ${response.status} - ${response.bodyAsText()}")
        }

        val res =  response.body<List<Weather>>()

        res.forEach {
            it.icon = "https://openweathermap.org/img/wn/${it.icon}@4x.png"
        }

        return res

    }


    //Ferme le Client mais celui ci ne sera plus utilisable. Uniquement pour le main
    fun close() = client.close()
}



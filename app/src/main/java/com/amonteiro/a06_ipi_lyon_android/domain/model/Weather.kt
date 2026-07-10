package com.amonteiro.a06_ipi_lyon_android.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Weather(
    val id: Int,
    val name: String,
    val temp: Double,
    val speed: Double,
    val description: String,
    var icon: String
) {
    fun getResume() = """
        Il fait $temp° à $name (id=$id) avec un vent de $speed m/s
        -Description : $description
        -Icône : $icon
    """.trimIndent()
}
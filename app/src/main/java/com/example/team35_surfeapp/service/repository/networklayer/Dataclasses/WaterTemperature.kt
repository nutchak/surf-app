package com.example.team35_surfeapp.service.repository.networklayer.Dataclasses

data class WaterTemperature(
    val `data`: Data
) {
    data class Data(
        val tseries: List<Tsery>,
        val tstype: String
    ) {
        data class Tsery(
            val header: Header,
            val observations: Any
        ) {
            data class Header(
                val extra: Extra,
                val id: Id
            ) {
                data class Extra(
                    val name: String,
                    val pos: Pos
                ) {
                    data class Pos(
                        val lat: String,
                        val lon: String
                    )
                }

                data class Id(
                    val buoyid: String,
                    val parameter: String,
                    val source: String
                )
            }
        }
    }
}
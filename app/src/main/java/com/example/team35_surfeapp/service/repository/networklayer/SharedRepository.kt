package com.example.team35_surfeapp.service.repository.networklayer

import com.example.team35_surfeapp.service.repository.networklayer.Dataclasses.*

class SharedRepository {

    // WeatherApi
    suspend fun getWeather(latitude : Float, longitude : Float) : Weather? {
        val request = NetworkLayer.apiClientWeather.getWeather(latitude, longitude)

        if (request.failed) {
            return null
        }
        if (!request.isSuccessful){
            return null
        }
        return request.body
    }

    // NowCast
    suspend fun getNowCast(latitude : Float, longitude : Float) : NowCast? {
        val request = NetworkLayer.apiClientNowCast.getNowCast(latitude, longitude)

        if (request.failed) {
            return null
        }
        if (!request.isSuccessful) {
            return null
        }
        return request.body
    }

    // OceanForecast
    suspend fun getOceanForecast(latitude : Float, longitude : Float) : OceanForecast? {
        val request = NetworkLayer.apiClientOceanForecast.getOceanForecast(latitude, longitude)

        if (request.failed) {
            return null
        }
        if (!request.isSuccessful) {
            return null
        }
        return request.body
    }

    // Havvarsel-Frost
    suspend fun getWaterTemperature(): WaterTemperature? {
        val request = NetworkLayer.apiClientWaterTemperature.getWaterTemperature()

        if (request.failed) {
            return null
        }
        if (!request.isSuccessful) {
            return null
        }
        return request.body
    }

    // MetAlerts
    suspend fun getMetAlerts(latitude : Float, longitude : Float) : MetAlerts? {
        val request = NetworkLayer.apiClientMetAlerts.getMetAlerts(latitude, longitude)

        if (request.failed) {
            return null
        }
        if (!request.isSuccessful) {
            return null
        }
        return request.body
    }
}
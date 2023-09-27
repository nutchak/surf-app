package com.example.team35_surfeapp.service.repository.networklayer


import com.example.team35_surfeapp.service.repository.networklayer.Dataclasses.*
import retrofit2.Response

class ApiClient(private val apiService : ApiService) {


    // Havvarsel-Frost: Water Temperature
    // Don't need to use proxy
    suspend fun getWaterTemperature() : SimpleResponse<WaterTemperature> {
        return safeApiCall { apiService.getWaterTemperature() }
    }


    // MetAlerts: Warnings
    suspend fun getMetAlerts(latitude : Float, longitude : Float) : SimpleResponse<MetAlerts> {
        return safeApiCall { apiService.getMetAlerts(latitude, longitude) }
    }


    // NowCast
    suspend fun getNowCast(latitude : Float, longitude : Float) : SimpleResponse<NowCast> {
        return safeApiCall { apiService.getNowCast(latitude, longitude) }
    }


    // WeatherApi
    suspend fun getWeather(latitude : Float, longitude : Float) : SimpleResponse<Weather> {
        return safeApiCall { apiService.getWeather(latitude, longitude) }
    }


    // OceanForecast
    suspend fun getOceanForecast(latitude : Float, longitude : Float) : SimpleResponse<OceanForecast> {
        return safeApiCall { apiService.getOceanForecast(latitude, longitude) }
    }

    private inline fun <T> safeApiCall(apiCall: () -> Response<T>) : SimpleResponse<T> {
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e : Exception) {
            SimpleResponse.failure(e)
        }
    }

}
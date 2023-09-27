package com.example.team35_surfeapp.service.repository.networklayer

import com.example.team35_surfeapp.service.repository.networklayer.Dataclasses.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    /// Get water temperature
    // Get from all locations
    @GET("api/v1/obs/badevann/get")
    suspend fun getWaterTemperature() : Response<WaterTemperature>


    // Get warning
    // Get from all locations
    // XML
    @GET("weatherapi/metalerts/1.1?")
    suspend fun getMetAlerts(@Query("lat") latitude : Float, @Query("lon") longitude : Float) : Response<MetAlerts>


    // Get NowCast
    // Parameters: Latitude(Float) and Longitude(Float)
    @GET("complete?")
    suspend fun getNowCast(@Query("lat") latitude : Float, @Query("lon") longitude : Float) : Response<NowCast>


    // Get WeatherApi
    // Parameters: Latitude(Float) and Longitude(Float)
    @GET("complete?")
    suspend fun getWeather(@Query("lat") latitude : Float, @Query("lon") longitude : Float) : Response<Weather>


    // Get ocean forecast
    // Parameters: Latitude(Float) and Longitude(Float)
    @GET("complete?")
    suspend fun getOceanForecast(@Query("lat") latitude : Float, @Query("lon") longitude : Float) : Response<OceanForecast>


}
@file:Suppress("DEPRECATION")

package com.example.team35_surfeapp.service.repository.networklayer

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

object NetworkLayer {


    // Havvarsel-frost API(Water Temperature)
    private val retrofitWaterTemperature : Retrofit = Retrofit.Builder()
        .baseUrl("https://havvarsel-frost.met.no/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val waterTemperatureService : ApiService by lazy {
        retrofitWaterTemperature.create(ApiService::class.java)
    }

    val apiClientWaterTemperature = ApiClient(waterTemperatureService)


    // MetAlerts
    private val retrofitMetAlerts : Retrofit = Retrofit.Builder()
        .baseUrl("https://api.met.no/")
        .client(OkHttpClient())
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()

    private val metAlertsService : ApiService by lazy {
        retrofitMetAlerts.create(ApiService::class.java)
    }

    val apiClientMetAlerts = ApiClient(metAlertsService)


    // NowCast -> (classic/complete/coverage)
    private val retrofitNowCast : Retrofit = Retrofit.Builder()
        .baseUrl("https://in2000-apiproxy.ifi.uio.no/weatherapi/nowcast/2.0/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val nowCastService : ApiService by lazy {
        retrofitNowCast.create(ApiService::class.java)
    }

    val apiClientNowCast = ApiClient(nowCastService)


    // Weather API
    private val retrofitWeather : Retrofit = Retrofit.Builder()
        .baseUrl("https://in2000-apiproxy.ifi.uio.no/weatherapi/locationforecast/2.0/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val weatherService : ApiService by lazy {
        retrofitWeather.create(ApiService::class.java)
    }

    val apiClientWeather = ApiClient(weatherService)


    // Oceanforecast API
    private val retrofitOceanForecast : Retrofit = Retrofit.Builder()
        .baseUrl("https://in2000-apiproxy.ifi.uio.no/weatherapi/oceanforecast/2.0/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val oceanForecastService : ApiService by lazy {
        retrofitOceanForecast.create(ApiService::class.java)
    }

    val apiClientOceanForecast = ApiClient(oceanForecastService)

}
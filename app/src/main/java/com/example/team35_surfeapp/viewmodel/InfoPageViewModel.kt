package com.example.team35_surfeapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.team35_surfeapp.viewmodel.dataClasses.CardData
import com.example.team35_surfeapp.viewmodel.dataClasses.InfoPageData
import com.example.team35_surfeapp.service.repository.networklayer.Dataclasses.OceanForecast
import com.example.team35_surfeapp.service.repository.networklayer.Dataclasses.Weather
import com.example.team35_surfeapp.service.repository.networklayer.SharedRepository
import com.example.team35_surfeapp.service.utility.icons.FindIcon
import com.example.team35_surfeapp.view.ui.settings.Settings
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class InfoPageViewModel : ViewModel() {

    private val repository = SharedRepository()

    private lateinit var position : LatLng

    private val infoPageData: MutableLiveData<MutableList<InfoPageData>> by lazy {
        MutableLiveData<MutableList<InfoPageData>>().also {
            loadData()
        }
    }

    fun getData(position : LatLng) : LiveData<MutableList<InfoPageData>> {
        this.position = position
        return infoPageData
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            //fetches location forecast and ocean forecast
            val lat = String.format("%.4f", position.latitude).toFloat()
            val lon = String.format("%.4f", position.longitude).toFloat()
            val responseOcean = repository.getOceanForecast(lat, lon)
            val responseLocationForecast = repository.getWeather(lat, lon)

            //posts data returned from setUpData
            infoPageData.postValue(setUpData(responseOcean, responseLocationForecast))
        }
    }

    //puts the data fetched from apis in to an easy to work with class
    private fun setUpData(responseOceanForecast : OceanForecast?, responseLocationForecast : Weather?) : MutableList<InfoPageData> {

        //creates a list which will contain the data
        val list = mutableListOf<InfoPageData>()

        //make vars so less writing is necessary
        var weatherData: Weather.Properties.Timesery.Data?
        var oceanInstant: OceanForecast.Properties.Timesery.Data.Instant?

        //finds out how manny timeSeries there are
        val antNullW = responseLocationForecast?.properties?.timeseries?.size?.minus(1)
        val antNullO = responseOceanForecast?.properties?.timeseries?.size?.minus(1)
        val ant = findAnt(antNullW, antNullO)



        //iterates for every timeSeries
        var flag = false
        var j = 0
        var k = 0
        for (i in 0 until ant step 1) {
            //set the two vars
            weatherData = responseLocationForecast?.properties?.timeseries?.get(k)?.data
            oceanInstant = responseOceanForecast?.properties?.timeseries?.get(j)?.data?.instant
            j++
            k++
            while (responseLocationForecast?.properties?.timeseries?.get(k)?.time?.equals(responseOceanForecast?.properties?.timeseries?.get(j)?.time) != true){
                if (responseLocationForecast?.properties?.timeseries?.get(k)?.time?.compareTo(responseOceanForecast?.properties?.timeseries?.get(j)?.time.toString()) == -1){
                    k++
                    weatherData = responseLocationForecast.properties.timeseries[k].data
                }
                else{
                    j++
                    if (antNullO != null && j == antNullO - 1) {
                        flag = true
                        break
                    }
                    oceanInstant = responseOceanForecast?.properties?.timeseries?.get(j)?.data?.instant
                }
            }
            if (flag){
                break
            }


            //put data in infoData
            val infoPageData = InfoPageData(
                weatherData?.next_1_hours?.summary?.symbol_code?.let { FindIcon().findWeather(it) },
                "været",
                responseLocationForecast?.properties?.timeseries?.get(k)?.time?.let { makeTime(it) },
                mutableListOf()
            )
            //add card data
            addData(infoPageData, weatherData, oceanInstant)

            //check if units needs to bee converted
            changeUnit(infoPageData)
            changeTemp(infoPageData)

            //add data to list
            list.add(infoPageData)
        }
        //return the list
        return list

    }

    //check if units needs to bee converted
    private fun changeUnit(infoPageData : InfoPageData) {
        if (Settings.unit == "IMP") {
            infoPageData.cardData.forEach {
                if (it.unit == "mm" && it.data != "null") {
                    it.data = String.format("%.1f", it.data?.toDouble()?.times(0.03937))
                    it.unit = "inches"
                }
                else if (it.unit == "m") {
                    it.data = String.format("%.1f", it.data?.toDouble()?.times(3.2808))
                    it.unit = "feet"
                }
                else if (it.unit == "m/s") {
                    it.data = String.format("%.1f", it.data?.toDouble()?.times(2.2369))
                    it.unit = "mph"
                }
            }
        }
        if (Settings.unit == "UK") {
            infoPageData.cardData.forEach {
                if (it.unit == "mm" && it.data != "null") {
                    it.data = String.format("%.1f", it.data?.toDouble()?.times(2.117))
                    it.unit = "Poppyseed"
                }
                else if (it.unit == "m") {
                    it.data = String.format("%.1f", it.data?.toDouble()?.times(4.3744))
                    it.unit = "Span"
                }
                else if (it.unit == "m/s") {
                    it.data = String.format("%.1f", it.data?.toDouble()?.times(9.84251969))
                    //hands per second
                    it.unit = "hps"
                }
            }
        }
    }

    private fun changeTemp(infoPageData: InfoPageData) {
        if (Settings.tempUnit == "FAR") {
            infoPageData.cardData.forEach {
                if (it.unit == "⁰C") {
                    it.data = String.format("%.1f", it.data?.toDouble()?.times(1.8)?.plus(32))
                    it.unit = "⁰F"
                }
            }
        }
        if (Settings.tempUnit == "KEL") {
            infoPageData.cardData.forEach {
                if (it.unit == "⁰C") {
                    it.data = String.format("%.1f", it.data?.toDouble()?.plus(273))
                    it.unit = "K"
                }
            }
        }
    }

    //add card data
    private fun addData(infoPageData : InfoPageData, weatherData : Weather.Properties.Timesery.Data?, oceanInstant : OceanForecast.Properties.Timesery.Data.Instant?) {
        infoPageData.cardData.add(
            CardData(
                "Nedbør",
                weatherData?.next_1_hours?.details?.precipitation_amount.toString(),
                null,
                "mm",
                "drop"
            )
        )
        infoPageData.cardData.add(
            CardData(
                "Lufttemperatur",
                weatherData?.instant?.details?.air_temperature.toString(),
                null,
                "⁰C",
                "thermometer"
            )
        )
        infoPageData.cardData.add(
            CardData(
                "Vindhastighet",
                weatherData?.instant?.details?.wind_speed.toString(),
                weatherData?.instant?.details?.wind_from_direction,
                "m/s",
                "arrow"
            )
        )
        infoPageData.cardData.add(
            CardData(
                "Bølgehøyde",
                oceanInstant?.details?.sea_surface_wave_height.toString(),
                null,
                "m",
                "wave"
            )
        )
        infoPageData.cardData.add(
            CardData(
                "Havtemperatur",
                oceanInstant?.details?.sea_water_temperature.toString(),
                null,
                "⁰C",
                "water"
            )
        )
        infoPageData.cardData.add(
            CardData(
                "Havstrøm",
                oceanInstant?.details?.sea_water_speed.toString(),
                oceanInstant?.details?.sea_water_to_direction,
                "m/s",
                "arrow"
            )
        )
    }

    //finds out how manny timeSeries there are
    private fun findAnt(antNullW : Int?, antNullO : Int?) :  Int {
        var ant = 0
        if (antNullW != null && antNullO != null) {
            ant = antNullW
            if (ant > antNullO) {
                ant = antNullO
            }
        }
        return ant
    }

    //parses the date string to a Date object and gets the Calender object of the Date
    //then the offset based on the phones timezone is added and the time is returned
    private fun makeTime(intTime : String) : String {
        val format = "yyyy-MM-dd'T'HH:mm:ss'Z'"
        val offset = TimeZone.getDefault().rawOffset / 60000
        val date = SimpleDateFormat(format, Locale.ENGLISH).parse(intTime)
        val calender = Calendar.getInstance()
        if (date != null) {
            calender.time = date
        }
        calender.add(Calendar.MINUTE, offset)

        return SimpleDateFormat("HH:mm 'den' dd.MM", Locale.ENGLISH).format(calender.time)
    }
}
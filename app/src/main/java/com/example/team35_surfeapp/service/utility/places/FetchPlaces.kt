package com.example.team35_surfeapp.service.utility.places

import android.content.Context
import com.google.android.gms.maps.model.LatLng
import com.google.gson.Gson

class FetchPlaces {

    companion object {
        //fetches the surfSpots from the json file
         fun fetchSurfSpots(context : Context?) : MutableList<SurfSpotData>? {
            //opens the file
            val inputStream = context?.assets?.open("surfing_locations.json")
            //makes sure its found
            if (inputStream != null) {
                //reads from the the file to an array
                val arr = ByteArray(inputStream.available())
                inputStream.read(arr)
                val json = String(arr)
                // converts from json to to the position
                val positions = Gson().fromJson(json, Base::class.java)
                val ret = mutableListOf<SurfSpotData>()
                //iterates over the positions to put it inn to an easier format
                positions.surfing_locations.forEach {
                    ret.add(
                        SurfSpotData(
                            it.name,
                            LatLng(it.latitude.toDouble(), it.longitude.toDouble())
                        )
                    )
                }
                //returns
                return ret
            }
            return null
        }
    }
}
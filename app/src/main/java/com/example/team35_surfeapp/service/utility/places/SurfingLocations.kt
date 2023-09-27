package com.example.team35_surfeapp.service.utility.places

import com.google.gson.annotations.SerializedName

data class SurfingLocations (
    @SerializedName("name")
    val name : String,
    @SerializedName("latitude")
    val latitude : String,
    @SerializedName("longitude")
    val longitude : String
)

data class Base(
    @SerializedName("surfing_locations")
    val surfing_locations : List<SurfingLocations> = listOf()
)
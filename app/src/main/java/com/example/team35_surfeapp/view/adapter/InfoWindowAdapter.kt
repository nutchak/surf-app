package com.example.team35_surfeapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.example.team35_surfeapp.databinding.InfoWindowBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class InfoWindowAdapter(context : Context) : GoogleMap.InfoWindowAdapter {

    private val binding: InfoWindowBinding = InfoWindowBinding.inflate(LayoutInflater.from(context), null, false)

    override fun getInfoWindow(point : Marker) : View {

        setUpWindow(point)

        return binding.root
    }

    override fun getInfoContents(point : Marker) : View {

        setUpWindow(point)

        return binding.root
    }

    //add title to info window
    private fun setUpWindow(point : Marker) {
        binding.infoWindowName.text = point.title
    }


}
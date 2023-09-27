package com.example.team35_surfeapp.infoPage

import com.example.team35_surfeapp.viewmodel.dataClasses.CardData
import com.example.team35_surfeapp.view.adapter.InfoPageAdapter
import com.example.team35_surfeapp.viewmodel.InfoPageViewModel
import com.google.android.gms.maps.model.LatLng
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class InfoPageAdapterTest {

    val infoPageViewModel = InfoPageViewModel()
    val latLng = LatLng(4.2,7.4)

    @Test
    fun getDataTest() {
        val x = infoPageViewModel.getData(latLng)
        assertNotNull(x,"Test getData ")
    }

}
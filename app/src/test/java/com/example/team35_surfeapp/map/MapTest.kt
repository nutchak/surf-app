package com.example.team35_surfeapp.map

import com.example.team35_surfeapp.view.ui.map.Map
import com.google.android.gms.maps.model.LatLng
import junit.framework.Assert.assertNotNull
import org.junit.jupiter.api.Test

internal class MapTest {

    val mMap = Map()
    val x = LatLng(5.2, 6.5)
    val mapClusterItem = mMap.MapClusterItem(x,"ABCD")
    val position = mapClusterItem.position
    val positionResult = LatLng(5.2,6.5)

    @Test
    fun testPosition() {
        assertNotNull("$position : testing position", positionResult)
    }


    @Test
    //test map clauster
    fun mapClusterItemTest() {
        assertNotNull("Test mapClusterItem",mapClusterItem)

    }
}

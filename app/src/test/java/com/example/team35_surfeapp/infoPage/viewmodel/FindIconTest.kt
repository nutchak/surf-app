package com.example.team35_surfeapp.infoPage.viewmodel

import com.example.team35_surfeapp.service.utility.icons.FindIcon
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Test

internal class FindIconTest {

    private val findIcon = FindIcon()

    @Test
    fun findWeatherGood() {
        assertEquals("vaersymboler/13.png", findIcon.findWeather("snow"))
        assertEquals("vaersymboler/07d.png", findIcon.findWeather("sleetshowers_day"))
        assertEquals("vaersymboler/06n.png", findIcon.findWeather("rainshowersandthunder_night"))
        assertEquals("vaersymboler/28m.png", findIcon.findWeather("lightssnowshowersandthunder_polartwilight"))
    }

    @Test
    fun findWeatherBad() {
        assertNull(findIcon.findWeather("bad input"))
    }

    @Test
    fun findWarningGood() {
        assertEquals("faresymboler/icon-warning-rain-red.png", findIcon.findWarning("regn_rodt"))
        assertEquals("faresymboler/icon-warning-drivingconditions-orange.png", findIcon.findWarning("is_oransje"))
        assertEquals("faresymboler/icon-warning-forestfire-yellow.png", findIcon.findWarning("brann_gult"))
    }

    @Test
    fun findWarningBad() {
        assertEquals("faresymboler/icon-warning-extreme.png", findIcon.findWarning("this is an unknown warning"))
    }
}
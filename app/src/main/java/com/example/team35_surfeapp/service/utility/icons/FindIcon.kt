package com.example.team35_surfeapp.service.utility.icons

class FindIcon {

    private val vaerMap = hashMapOf(
        Pair("clearsky_day", "vaersymboler/01d.png"),
        Pair("clearsky_night", "vaersymboler/01n.png"),
        Pair("clearsky_polartwilight", "vaersymboler/01m.png"),
        Pair("cloudy", "vaersymboler/04.png"),
        Pair("fair_day", "vaersymboler/02d.png"),
        Pair("fair_night", "vaersymboler/02n.png"),
        Pair("fair_polartwilight", "vaersymboler/02m.png"),
        Pair("fog", "vaersymboler/15.png"),
        Pair("heavyrain", "vaersymboler/10.png"),
        Pair("heavyrainandthunder", "vaersymboler/11.png"),
        Pair("heavyrainshowers_day", "vaersymboler/41d.png"),
        Pair("heavyrainshowers_night", "vaersymboler/41n.png"),
        Pair("heavyrainshowers_polartwilight", "vaersymboler/41m.png"),
        Pair("heavyrainshowersandthunder_day", "vaersymboler/25d.png"),
        Pair("heavyrainshowersandthunder_night", "vaersymboler/25n.png"),
        Pair("heavyrainshowersandthunder_polartwilight", "vaersymboler/25m.png"),
        Pair("heavysleet", "vaersymboler/48.png"),
        Pair("heavysleetandthunder", "vaersymboler/32.png"),
        Pair("heavysleetshowers_day", "vaersymboler/43d.png"),
        Pair("heavysleetshowers_night", "vaersymboler/43n.png"),
        Pair("heavysleetshowers_polartwilight", "vaersymboler/43m.png"),
        Pair("heavysleetshowersandthunder_day", "vaersymboler/27d.png"),
        Pair("heavysleetshowersandthunder_night", "vaersymboler/27n.png"),
        Pair("heavysleetshowersandthunder_polartwilight", "vaersymboler/27m.png"),
        Pair("heavysnow", "vaersymboler/50.png"),
        Pair("heavysnowandthunder", "vaersymboler/34.png"),
        Pair("heavysnowshowers_day", "vaersymboler/45d.png"),
        Pair("heavysnowshowers_night", "vaersymboler/45n.png"),
        Pair("heavysnowshowers_polartwilight", "vaersymboler/45m.png"),
        Pair("heavysnowshowersandthunder_day", "vaersymboler/29d.png"),
        Pair("heavysnowshowersandthunder_night", "vaersymboler/29n.png"),
        Pair("heavysnowshowersandthunder_polartwilight", "vaersymboler/29m.png"),
        Pair("lightrain", "vaersymboler/46.png"),
        Pair("lightrainandthunder", "vaersymboler/30.png"),
        Pair("lightrainshowers_day", "vaersymboler/40d.png"),
        Pair("lightrainshowers_night", "vaersymboler/40n.png"),
        Pair("lightrainshowers_polartwilight", "vaersymboler/40m.png"),
        Pair("lightrainshowersandthunder_day", "vaersymboler/24d.png"),
        Pair("lightrainshowersandthunder_night", "vaersymboler/24n.png"),
        Pair("lightrainshowersandthunder_polartwilight", "vaersymboler/24m.png"),
        Pair("lightsleet", "vaersymboler/47.png"),
        Pair("lightsleetandthunder", "vaersymboler/31.png"),
        Pair("lightsleetshowers_day", "vaersymboler/42d.png"),
        Pair("lightsleetshowers_night", "vaersymboler/42n.png"),
        Pair("lightsleetshowers_polartwilight", "vaersymboler/42m.png"),
        Pair("lightsnow", "vaersymboler/49.png"),
        Pair("lightsnowandthunder", "vaersymboler/33.png"),
        Pair("lightsnowshowers_day", "vaersymboler/44d.png"),
        Pair("lightsnowshowers_night", "vaersymboler/44n.png"),
        Pair("lightsnowshowers_polartwilight", "vaersymboler/44m.png"),
        Pair("lightssleetshowersandthunder_day", "vaersymboler/26d.png"),
        Pair("lightssleetshowersandthunder_night", "vaersymboler/26n.png"),
        Pair("lightssleetshowersandthunder_polartwilight", "vaersymboler/26m.png"),
        Pair("lightssnowshowersandthunder_day", "vaersymboler/28d.png"),
        Pair("lightssnowshowersandthunder_night", "vaersymboler/28n.png"),
        Pair("lightssnowshowersandthunder_polartwilight", "vaersymboler/28m.png"),
        Pair("partlycloudy_day", "vaersymboler/03d.png"),
        Pair("partlycloudy_night", "vaersymboler/03n.png"),
        Pair("partlycloudy_polartwilight", "vaersymboler/03m.png"),
        Pair("rain", "vaersymboler/09.png"),
        Pair("rainandthunder", "vaersymboler/22.png"),
        Pair("rainshowers_day", "vaersymboler/05d.png"),
        Pair("rainshowers_night", "vaersymboler/05n.png"),
        Pair("rainshowers_polartwilight", "vaersymboler/05m.png"),
        Pair("rainshowersandthunder_day", "vaersymboler/06d.png"),
        Pair("rainshowersandthunder_night", "vaersymboler/06n.png"),
        Pair("rainshowersandthunder_polartwilight", "vaersymboler/06m.png"),
        Pair("sleet", "vaersymboler/12.png"),
        Pair("sleetandthunder", "vaersymboler/23.png"),
        Pair("sleetshowers_day", "vaersymboler/07d.png"),
        Pair("sleetshowers_night", "vaersymboler/07n.png"),
        Pair("sleetshowers_polartwilight", "vaersymboler/07m.png"),
        Pair("sleetshowersandthunder_day", "vaersymboler/20d.png"),
        Pair("sleetshowersandthunder_night", "vaersymboler/20n.png"),
        Pair("sleetshowersandthunder_polartwilight", "vaersymboler/20m.png"),
        Pair("snow", "vaersymboler/13.png"),
        Pair("snowandthunder", "vaersymboler/14.png"),
        Pair("snowshowers_day", "vaersymboler/08d.png"),
        Pair("snowshowers_night", "vaersymboler/08n.png"),
        Pair("snowshowers_polartwilight", "vaersymboler/08m.png"),
        Pair("snowshowersandthunder_day", "vaersymboler/21d.png"),
        Pair("snowshowersandthunder_night", "vaersymboler/21n.png"),
        Pair("snowshowersandthunder_polartwilight", "vaersymboler/21m.png")
    )

    private val fareMap = hashMapOf(
        Pair("sno_gult", "faresymboler/icon-warning-snow-yellow.png"),
        Pair("sno_oransje", "faresymboler/icon-warning-snow-orange.png"),
        Pair("sno_rodt", "faresymboler/icon-warning-snow-red.png"),
        Pair("vind_gult", "faresymboler/icon-warning-wind-yellow.png"),
        Pair("vind_oransje", "faresymboler/icon-warning-wind-orange.png"),
        Pair("vind_rodt", "faresymboler/icon-warning-wind-red.png"),
        Pair("regn_gult", "faresymboler/icon-warning-rain-yellow.png"),
        Pair("regn_oransje", "faresymboler/icon-warning-rain-orange.png"),
        Pair("regn_rodt", "faresymboler/icon-warning-rain-red.png"),
        Pair("styrtregn_gult", "faresymboler/icon-warning-rainflood-yellow.png"),
        Pair("styrtregn_oransje", "faresymboler/icon-warning-rainflood-orange.png"),
        Pair("styrtregn_rodt", "faresymboler/icon-warning-rainflood-red.png"),
        Pair("snoskred_gult", "faresymboler/icon-warning-avalanches-yellow.png"),
        Pair("snoskred_oransje", "faresymboler/icon-warning-avalanches-orange.png"),
        Pair("snoskred_rodt", "faresymboler/icon-warning-avalanches-red.png"),
        Pair("is_gult", "faresymboler/icon-warning-drivingconditions-yellow.png"),
        Pair("is_oransje", "faresymboler/icon-warning-drivingconditions-orange.png"),
        Pair("is_rodt", "faresymboler/icon-warning-drivingconditions-red.png"),
        Pair("ising_gult", "faresymboler/icon-warning-ice-yellow.png"),
        Pair("ising_oransje", "faresymboler/icon-warning-ice-orange.png"),
        Pair("ising_rodt", "faresymboler/icon-warning-ice-red.png"),
        Pair("extreme", "faresymboler/icon-warning-extreme.png"),
        Pair("flom_gult", "faresymboler/icon-warning-flood-yellow.png"),
        Pair("flom_oransje", "faresymboler/icon-warning-flood-orange.png"),
        Pair("flom_rodt", "faresymboler/icon-warning-flood-red.png"),
        Pair("brann_gult", "faresymboler/icon-warning-forestfire-yellow.png"),
        Pair("brann_oransje", "faresymboler/icon-warning-forestfire-orange.png"),
        Pair("brann_rodt", "faresymboler/icon-warning-forestfire-red.png"),
        Pair("generic_gult", "faresymboler/icon-warning-generic-yellow.png"),
        Pair("generic_oransje", "faresymboler/icon-warning-generic-orange.png"),
        Pair("generic_rodt", "faresymboler/icon-warning-generic-red.png"),
        Pair("jordskred_gult", "faresymboler/icon-warning-landslide-yellow.png"),
        Pair("jordskred_oransje", "faresymboler/icon-warning-landslide-orange.png"),
        Pair("jordskred_rodt", "faresymboler/icon-warning-landslide-red.png"),
        Pair("lyn_gult", "faresymboler/icon-warning-lightning-yellow.png"),
        Pair("lyn_oransje", "faresymboler/icon-warning-lightning-orange.png"),
        Pair("lyn_rodt", "faresymboler/icon-warning-lightning-red.png"),
        Pair("polar_gult", "faresymboler/icon-warning-polarlow-yellow.png"),
        Pair("polar_oransje", "faresymboler/icon-warning-polarlow-orange.png"),
        Pair("polar_rodt", "faresymboler/icon-warning-polarlow-red.png"),
        Pair("vannstand_gult", "faresymboler/icon-warning-stormsurge-yellow.png"),
        Pair("vannstand_oransje", "faresymboler/icon-warning-stormsurge-orange.png"),
        Pair("vannstand_rodt", "faresymboler/icon-warning-stormsurge-red.png")
    )

    //returns path to weather icon
    fun findWeather(symbolCode : String) : String? {
        return vaerMap[symbolCode.lowercase()]
    }

    //returns path to warning icon
    fun findWarning(title : String) : String? {
        return when {
            title.lowercase().contains("gult") -> {
                fareMap[findType(title) + "gult"]
            }
            title.lowercase().contains("oransje") -> {
                fareMap[findType(title) + "oransje"]
            }
            title.lowercase().contains("rodt") -> {
                fareMap[findType(title) + "rodt"]
            }
            else -> fareMap["extreme"]
        }
    }

    //helps inn finding the right warning type
    private fun findType(title : String) : String {
        return when {
            title.lowercase().contains("snøskred") -> "snoskred_"
            title.lowercase().contains("snø") && !title.lowercase().contains("snøfokk") -> "sno_"
            title.lowercase().contains("vind") || title.lowercase().contains("kuling") || title.lowercase().contains("storm") -> "vind_"
            title.lowercase().contains("styrtregn") -> "styrtregn_"
            title.lowercase().contains("regn") -> "regn_"
            title.lowercase().contains("ising") -> "ising_"
            title.lowercase().contains("is") -> "is_"
            title.lowercase().contains("flom") -> "flom_"
            title.lowercase().contains("brann") -> "brann_"
            title.lowercase().contains("jordskred") -> "jordskred_"
            title.lowercase().contains("lyn") -> "lyn_"
            title.lowercase().contains("polar") -> "polar_"
            title.lowercase().contains("flo") -> "vannstand_"
            else -> "generic_"
        }
    }

}
package com.example.team35_surfeapp.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.team35_surfeapp.service.utility.places.FetchPlaces
import com.example.team35_surfeapp.service.utility.places.SurfSpotData
import kotlinx.coroutines.*

class LoactionViewModel (application : Application?) : AndroidViewModel(application!!) {

    private var surfSpotDataList : MutableLiveData<MutableList<SurfSpotData>>? = null

    internal fun getSurfSpotDataList() : MutableLiveData<MutableList<SurfSpotData>> {
        if (surfSpotDataList == null) {
            surfSpotDataList = MutableLiveData()
            loadSurfSpotDataList()
        }
        return surfSpotDataList as MutableLiveData<MutableList<SurfSpotData>>
    }

    private fun loadSurfSpotDataList() {
        viewModelScope.launch(Dispatchers.IO) {
            val data : MutableList<SurfSpotData>? = FetchPlaces.fetchSurfSpots(getApplication())
            surfSpotDataList!!.postValue(data!!)
        }
    }
}

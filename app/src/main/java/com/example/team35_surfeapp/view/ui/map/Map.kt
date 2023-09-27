package com.example.team35_surfeapp.view.ui.map

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.team35_surfeapp.R
import com.example.team35_surfeapp.databinding.FragmentMapBinding
import com.example.team35_surfeapp.view.adapter.InfoWindowAdapter
import com.example.team35_surfeapp.viewmodel.LoactionViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.maps.android.clustering.ClusterItem
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer

class Map : Fragment(), OnMapReadyCallback {

    private lateinit var mMap : GoogleMap
    private lateinit var binding : FragmentMapBinding
    private lateinit var clusterManager: ClusterManager<MapClusterItem>
    private lateinit var locationViewModel: LoactionViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {
        // Inflate the layout for this fragment
        binding = FragmentMapBinding.inflate(inflater, container, false)
        locationViewModel = ViewModelProvider(this)[LoactionViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        supportMapFragment()
    }

    override fun onMapReady(googleMap : GoogleMap) {
        mMap = googleMap


        setBounds()
        setUpCluster()
    }


    //needed for map to load
    private fun supportMapFragment() {
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    private fun setUpCluster() {

        // Initialize the manager with the context and the map.
        // (Activity extends context, so we can pass 'this' in the constructor.)
        clusterManager = ClusterManager(context, mMap)
        clusterManager.renderer = ClusterRender(context, mMap, clusterManager)

        clearMap()

        // Point the map's listeners at the listeners implemented by the cluster
        // manager.
        mMap.setOnCameraIdleListener(clusterManager)
        clusterManager.markerCollection.setInfoWindowAdapter(context?.let { InfoWindowAdapter(it) })
        clusterManager.markerCollection.setOnInfoWindowClickListener {
            val bundle = bundleOf()
            //sends info and navigates to infoPage
            bundle.putDouble("lat", it.position.latitude)
            bundle.putDouble("lon", it.position.longitude)
            bundle.putString("name", it.title)
            view?.findNavController()?.navigate(R.id.action_mapFragment_to_infoPage, bundle)
        }
        // Add cluster items (markers) to the cluster manager.
        addInitialMarkers()
    }


    //function to add the surf places
    private fun addInitialMarkers() {
        locationViewModel.getSurfSpotDataList().observe(viewLifecycleOwner) { list ->
            list.forEach {
                clusterManager.addItem(MapClusterItem(it.position, it.name))
            }
        }

    }

    private fun clearMap() {
        mMap.clear()
        clusterManager.clearItems()
    }

    //setts the  bounds of the map
    private fun setBounds() {
        val bounds = LatLngBounds (
            LatLng(57.5, 3.8),
            LatLng(72.0, 34.0)
        )
        mMap.setLatLngBoundsForCameraTarget(bounds)
        mMap.setMinZoomPreference(4.45F)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(65.9, 16.2), 4.5F))
    }

    //code based on:
    //https://developers.google.com/maps/documentation/android-sdk/utility/marker-clustering#simple
    //https://github.com/googlemaps/android-maps-utils/blob/main/demo/src/v3/java/com/google/maps/android/utils/demo/CustomMarkerClusteringDemoActivity.java
    inner class MapClusterItem(
        private val position : LatLng,
        val name : String,
    ) : ClusterItem {


        override fun getPosition() : LatLng {
            return position
        }

        override fun getTitle() : String? {
            return null
        }

        override fun getSnippet() : String? {
            return null
        }

    }

    inner class ClusterRender(context : Context?,
                              map : GoogleMap?,
                              clusterManager : ClusterManager<MapClusterItem>?
    ) : DefaultClusterRenderer<MapClusterItem>(context, map, clusterManager) {

        override fun onBeforeClusterItemRendered(
            item : MapClusterItem,
            markerOptions : MarkerOptions
        ) {
            super.onBeforeClusterItemRendered(item, markerOptions)
            //sets the marker icon
            markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_surf)).title(item.name)
        }

    }
}

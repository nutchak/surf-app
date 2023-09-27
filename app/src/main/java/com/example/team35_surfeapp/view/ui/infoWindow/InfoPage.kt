package com.example.team35_surfeapp.view.ui.infoWindow

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team35_surfeapp.R
import com.example.team35_surfeapp.databinding.FragmentInfoPageBinding
import com.example.team35_surfeapp.view.adapter.InfoPageAdapter
import com.example.team35_surfeapp.viewmodel.dataClasses.InfoPageData
import com.example.team35_surfeapp.viewmodel.InfoPageViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

class InfoPage : Fragment(), OnMapReadyCallback {

    private lateinit var binding : FragmentInfoPageBinding
    private lateinit var mMap : GoogleMap
    private lateinit var pos : LatLng
    private val viewModel : InfoPageViewModel by viewModels()
    private lateinit var data : MutableList<InfoPageData>

    override fun onCreateView(
        inflater : LayoutInflater, container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {
        // Inflate the layout for this fragment
        binding = FragmentInfoPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //sets the layoutManager of the recycler view
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        //make sure that the toolbar can navigate up
        val navController = Navigation.findNavController(view)
        binding.backButton.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.backButton.setNavigationOnClickListener {
            navController.navigateUp()
        }

        //fetch arguments
        pos = arguments?.let { LatLng(it.getDouble("lat"), it.getDouble("lon")) }!!
        binding.backButton.title = arguments?.getString("name")
        //get info from the viewModel and displays it
        getInfoFromViewModel(pos)

        //sets the listener for the slider
        slidingListener()
        supportMapFragment()

    }

    override fun onMapReady(p0: GoogleMap) {
        //set up the map with one marker
        mMap = p0
        mMap.clear()
        val bounds = LatLngBounds (
            LatLng(57.5, 3.8),
            LatLng(72.0, 34.0)
        )
        mMap.setLatLngBoundsForCameraTarget(bounds)
        mMap.setMinZoomPreference(4.45F)
        mMap.addMarker(MarkerOptions().position(pos).icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_surf)))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pos, 12F))
    }

    //needed for map to load
    private fun supportMapFragment() {
        val mapFragment = childFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    //gets data form view model and displays it
    private fun getInfoFromViewModel(position : LatLng) {
        //observe the viewModel
        viewModel.getData(position).observe(viewLifecycleOwner) {
            //sets data to it
            data = it
            //sets the max value of the slider
            binding.slider.valueTo = it.size.toFloat() - 1
            //set the weather symbol
            it[0].weatherSymbolCode?.let { it1 -> setWeatherAsset(it1) }
            //sets the time
            val time = it[0].time
            if (time != null){
                binding.date.text = time
            }
            //sets the adapter for the infoPage with the first list
            val list = it[0].cardData.toList()
            binding.recyclerView.adapter = context?.let { it1 -> InfoPageAdapter(list, it1) }

        }
    }

    //sets weather icon
    private fun setWeatherAsset(path : String) {
        val icon = BitmapFactory.decodeStream(context?.assets?.open(path))
        binding.weatherImage.setImageBitmap(icon)
    }

    //set the listener for the slider
    private fun slidingListener() {
        binding.slider.addOnChangeListener { _, value, _ ->
            //updates the layout to the position the slider is on
            InfoPageAdapter.pos = 0
            val pos = value.toInt()
            data[pos].weatherSymbolCode?.let { it1 -> setWeatherAsset(it1) }
            val time = data[pos].time
            if (time != null){
                binding.date.text = time
            }
            val list = data[pos].cardData.toList()
            binding.recyclerView.adapter = context?.let { InfoPageAdapter(list, it) }
        }
    }

}
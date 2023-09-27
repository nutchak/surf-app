package com.example.team35_surfeapp.view.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.team35_surfeapp.R
import com.example.team35_surfeapp.databinding.FragmentListBinding
import com.example.team35_surfeapp.view.adapter.ListViewActivityAdapter
import com.example.team35_surfeapp.service.utility.places.SurfSpotData
import com.example.team35_surfeapp.viewmodel.LoactionViewModel

class ListFragment : Fragment(R.layout.fragment_list), ListViewActivityAdapter.OnItemClickListener {

    private var surfSpotDataLiveData = MutableLiveData<MutableList<SurfSpotData>>()
    private lateinit var surfSpotDataList: MutableList<SurfSpotData>
    private lateinit var binding : FragmentListBinding
    private lateinit var recyclerView : RecyclerView
    private var recyclerListViewActivityAdapter = ListViewActivityAdapter(surfSpotDataLiveData, this)
    private lateinit var loactionViewModel : LoactionViewModel

    override fun onCreateView(inflater : LayoutInflater, container : ViewGroup?, savedInstanceState : Bundle?) : View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        loactionViewModel = ViewModelProvider(this)[LoactionViewModel::class.java]
        loactionViewModel.getSurfSpotDataList().observe(viewLifecycleOwner) { surfLocationList ->
            surfSpotDataLiveData.value = surfLocationList
            surfSpotDataList = surfLocationList!!
            recyclerView.adapter = ListViewActivityAdapter(surfSpotDataLiveData, this)
        }
        this.setHasOptionsMenu(true)
        recyclerView = binding.recyclerView
        return binding.root
    }

    override fun onItemClick(position: Int) {
        val clickedLocationsItem : SurfSpotData = surfSpotDataList[position]
        val bundle = bundleOf()
        bundle.putDouble("lat", clickedLocationsItem.position.latitude)
        bundle.putDouble("lon", clickedLocationsItem.position.longitude)
        bundle.putString("name", clickedLocationsItem.name)
        view?.findNavController()?.navigate(R.id.action_list_to_infoPage, bundle)
        recyclerListViewActivityAdapter.notifyItemChanged(position)
    }

}
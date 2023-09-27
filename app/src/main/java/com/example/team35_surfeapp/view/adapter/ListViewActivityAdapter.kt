package com.example.team35_surfeapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.team35_surfeapp.databinding.ElementListFragmentBinding
import com.example.team35_surfeapp.service.utility.places.SurfSpotData

class ListViewActivityAdapter(
    private val data : MutableLiveData<MutableList<SurfSpotData>>,
    private val listener : OnItemClickListener
): RecyclerView.Adapter<ListViewActivityAdapter.ViewHolder>() {

    private lateinit var binding: ElementListFragmentBinding

    // When first created return ViewHolder
    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ViewHolder {
        binding = ElementListFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // Pass data to adapter
    override fun onBindViewHolder(viewHolder : ViewHolder, position : Int) {
        viewHolder.bind(data.value!![position])
    }

    override fun getItemCount() : Int {
        return data.value!!.size
    }

    // Class for ViewHolder extends RecyclerView.ViewHolder binding to elements_list_fragment.xml
    inner class ViewHolder(private val binding : ElementListFragmentBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private val tvSurfSpotDataName : TextView

        init {
            tvSurfSpotDataName = binding.tvSurfSpotDataName
            binding.tvSurfSpotDataName.setOnClickListener(this)
        }

        fun bind(surfSpotData: SurfSpotData) {
            val name = binding.tvSurfSpotDataName
            name.text = surfSpotData.name
        }

        override fun onClick(view : View?) {
            val position : Int = bindingAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position : Int)
    }

}
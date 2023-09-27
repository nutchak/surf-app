package com.example.team35_surfeapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.team35_surfeapp.R
import com.example.team35_surfeapp.databinding.InfopageCardBinding
import com.example.team35_surfeapp.viewmodel.dataClasses.CardData

class InfoPageAdapter(private val dataSet : List<CardData>, private val context : Context) : RecyclerView.Adapter<InfoPageAdapter.CardViewHolder>() {

    class CardViewHolder(val binding : InfopageCardBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : CardViewHolder {
        val binding = InfopageCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder : CardViewHolder, position : Int) {
        //finds icon and sets the image
        val drawableID = findIcon(dataSet[position].icon)
        if (drawableID != null){
            holder.binding.image.setBackgroundResource(drawableID)
        }
        //if there is no precipitation the text is set to utiljengelig
        //else it just puts the data
        if (dataSet[position].data == "null") {
            holder.binding.unit.text = context.getString(R.string.utigjengelig)
        } else {
            holder.binding.data.text = dataSet[position].data
            holder.binding.unit.text = dataSet[position].unit
        }
        //sets the background color
        holder.binding.title.text = dataSet[position].title
        if (pos % 2 == 0) {
            holder.binding.background.setBackgroundResource(R.color.infoC1)
        } else {
            holder.binding.background.setBackgroundResource(R.color.infoC2)
        }
        pos++

        //checks if it is the arrow which needs to bee turned in the right direction
        if (dataSet[position].icon == "arrow") {
            val dir = dataSet[position].exstraData?.toFloat()
            if (dir != null) {
                if(dir + 180F > 360) {
                    holder.binding.image.rotation = (dir + 180F) - 360F
                } else {
                    holder.binding.image.rotation = dir + 180F
                }
            }
        }

    }

    override fun getItemCount() = dataSet.size



    companion object {

        //the position is to help decide which background color to use
        var pos = 0

        //finds the right icon
        fun findIcon(iconHint : String) : Int? {
            return when(iconHint){
                "drop" -> R.drawable.ic_baseline_water_drop
                "wave" -> R.drawable.ic_baseline_wave
                "water" -> R.drawable.ic_baseline_water
                "thermometer" -> R.drawable.ic_baseline_thermostat
                "arrow" -> R.drawable.arrow
                else -> {null}
            }
        }
    }

}
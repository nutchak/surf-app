package com.example.team35_surfeapp.view.ui.settings

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.team35_surfeapp.databinding.FragmentSettingsBinding

class Settings : Fragment() {

    private lateinit var binding : FragmentSettingsBinding

    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when(tempUnit) {
            "CEL" -> binding.cel.isChecked = true
            "FAR" -> binding.far.isChecked = true
            "KEL" -> binding.kel.isChecked = true
        }

        when(unit) {
            "MET" -> binding.met.isChecked = true
            "IMP" -> binding.imp.isChecked = true
            "UK" -> binding.uk.isChecked = true
        }

        clickListeners()
    }

    private fun clickListeners() {

        binding.cel.setOnClickListener {
            tempUnit = "CEL"
        }

        binding.far.setOnClickListener {
            tempUnit = "FAR"
        }

        binding.kel.setOnClickListener {
            tempUnit = "KEL"
        }

        binding.met.setOnClickListener {
            unit = "MET"
        }

        binding.imp.setOnClickListener {
            unit = "IMP"
        }

        binding.uk.setOnClickListener {
            unit = "UK"
        }


    }

    companion object {
        var tempUnit = "CEL"
        var unit = "MET"
    }
}
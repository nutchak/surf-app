package com.example.team35_surfeapp.view.ui.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.team35_surfeapp.R

class FirstScreen : Fragment() {


    override fun onCreateView(
        inflater : LayoutInflater,
        container: ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_first_screen, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)

        view.findViewById<Button>(R.id.next_screen1).setOnClickListener {
            viewPager?.currentItem = 1

        }


        return view



    }

}
package com.example.team35_surfeapp.view.ui.onboarding.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.team35_surfeapp.R


class ThirdScreen : Fragment() {

    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third_screen, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)

        view.findViewById<Button>(R.id.previous_screen3).setOnClickListener {
            viewPager?.currentItem = 1

        }


        view.findViewById<Button>(R.id.next_screen3).setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_navigate_map)
            onBoardingFinished()

        }


        return view
    }


    private fun onBoardingFinished() {
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }
}
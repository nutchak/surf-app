package com.example.team35_surfeapp.view.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.team35_surfeapp.view.adapter.ViewPagerAdapter
import com.example.team35_surfeapp.R
import com.example.team35_surfeapp.view.ui.onboarding.screens.FirstScreen
import com.example.team35_surfeapp.view.ui.onboarding.screens.SecondScreen
import com.example.team35_surfeapp.view.ui.onboarding.screens.ThirdScreen

class ViewPagerFragment : Fragment() {


    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        savedInstanceState : Bundle?
    ) : View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )
        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        view.findViewById<ViewPager2>(R.id.view_pager).adapter = adapter


        return view

    }


}
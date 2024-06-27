package com.dash.cgpacalculator.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dash.cgpacalculator.ViewPagerAdapter
import com.dash.cgpacalculator.databinding.FragmentViewPagerBinding


class ViewPagerFragment : Fragment() {
    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        val view = binding.root

        val fragmentList = arrayListOf<Fragment>(

            OnboardingOne(),
            Onboardingtwo(),
            OnboardingThree(),
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager, lifecycle
        )
        binding.viewPager.adapter = adapter
        binding.dotsIndicator.attachTo(binding.viewPager)

        return view
    }


}
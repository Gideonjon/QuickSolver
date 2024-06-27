package com.dash.cgpacalculator

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.dash.cgpacalculator.databinding.FragmentSplashScreenBinding


class SplashScreen : Fragment() {
    private var _binding: FragmentSplashScreenBinding? = null
    private val binding get() = _binding!!
    private var progressStatus = 0
    private var handler = Handler()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        val view = binding.root

        Handler().postDelayed({
            progressKickstart()
            Navigation.findNavController(view)
                .navigate(R.id.action_splashScreen_to_viewPagerFragment)

        }, 5000)



        return view
    }

    private fun progressKickstart() {

        Thread(Runnable {
            while (progressStatus < 100) {
                // update progress status
                progressStatus += 1

                // sleep the thread for 100 milliseconds
                Thread.sleep(1000)

                // update the progress bar
                handler.post {
                    binding.progressBar.progress = progressStatus
                }
            }
        }).start()

    }


}
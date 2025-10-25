package com.unsoed.responsi1mobileh1d023114.ui

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.unsoed.responsi1mobileh1d023114.R
import com.unsoed.responsi1mobileh1d023114.databinding.ActivityMainBinding
import com.unsoed.responsi1mobileh1d023114.ui.CoachFragment
import com.unsoed.responsi1mobileh1d023114.ui.HistoryFragment
import com.unsoed.responsi1mobileh1d023114.ui.SquadFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol History
        binding.btnHistory.setOnClickListener {
            openFragment(HistoryFragment())
        }

        // Tombol Coach
        binding.btnCoach.setOnClickListener {
            openFragment(CoachFragment())
        }

        // Tombol Squad
        binding.btnSquad.setOnClickListener {
            openFragment(SquadFragment())
        }

        // Tombol Back / Swipe Back modern
        onBackPressedDispatcher.addCallback(this) {
            if (binding.fragmentContainerView.visibility == View.VISIBLE) {
                binding.fragmentContainerView.visibility = View.GONE
                binding.homeScroll.visibility = View.VISIBLE
            } else {
                finish()
            }
        }
    }

    private fun openFragment(fragment: Fragment) {
        binding.homeScroll.visibility = View.GONE
        binding.fragmentContainerView.visibility = View.VISIBLE

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragment)
            .commit()
    }
}

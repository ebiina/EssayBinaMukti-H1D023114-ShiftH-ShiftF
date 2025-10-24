package com.unsoed.responsi1mobileh1d023114

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unsoed.responsi1mobileh1d023114.databinding.ActivityMainBinding
import com.unsoed.responsi1mobileh1d023114.ui.fragment.CoachFragment
import com.unsoed.responsi1mobileh1d023114.ui.fragment.HistoryFragment
import com.unsoed.responsi1mobileh1d023114.ui.fragment.SquadFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Tombol History
        binding.btnHistory.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, HistoryFragment())
                .addToBackStack(null)
                .commit()
        }

        // Tombol Coach
        binding.btnCoach.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, CoachFragment())
                .addToBackStack(null)
                .commit()
        }

        // Tombol Squad
        binding.btnSquad.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, SquadFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}

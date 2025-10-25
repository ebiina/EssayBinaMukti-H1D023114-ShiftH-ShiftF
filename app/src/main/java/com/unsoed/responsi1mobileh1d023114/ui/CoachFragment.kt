package com.unsoed.responsi1mobileh1d023114.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.unsoed.responsi1mobileh1d023114.databinding.FragmentCoachBinding
import com.unsoed.responsi1mobileh1d023114.viewmodel.MainViewModel
import com.bumptech.glide.Glide
import com.unsoed.responsi1mobileh1d023114.R

class CoachFragment : Fragment() {

    // View Binding
    private var _binding: FragmentCoachBinding? = null
    private val binding get() = _binding!!

    // ViewModel
    private val viewModel: MainViewModel by activityViewModels()

    // ID tim RC Celta de Vigo
    private val teamId = 558

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoachBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ambil data dari API
        viewModel.fetchTeamDetails(teamId)

        // Observasi hasil LiveData dari ViewModel
        viewModel.teamDetails.observe(viewLifecycleOwner) { team ->
            team?.coach?.let { coach ->
                binding.tvCoachName.text = coach.name ?: "N/A"
                binding.tvCoachDob.text = coach.dateOfBirth ?: "N/A"
                binding.tvCoachNationality.text = coach.nationality ?: "N/A"

                // Tampilkan foto coach lokal
                Glide.with(requireContext())
                    .load(R.drawable.coach)
                    .centerCrop()
                    .into(binding.ivCoach)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

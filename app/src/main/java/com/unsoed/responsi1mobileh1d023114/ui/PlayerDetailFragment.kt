package com.unsoed.responsi1mobileh1d023114.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.unsoed.responsi1mobileh1d023114.databinding.FragmentPlayerDetailBinding

class PlayerDetailFragment : DialogFragment() {

    private var _binding: FragmentPlayerDetailBinding? = null
    private val binding get() = _binding!!

    private var name: String? = null
    private var position: String? = null
    private var dob: String? = null
    private var nationality: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            name = bundle.getString(ARG_NAME)
            position = bundle.getString(ARG_POSITION)
            dob = bundle.getString(ARG_DOB)
            nationality = bundle.getString(ARG_NATIONALITY)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set data ke view
        binding.tvDetailPlayerName.text = name ?: "N/A"
        binding.tvDetailPlayerPosition.text = position ?: "N/A"
        binding.tvDetailPlayerDob.text = dob ?: "N/A"
        binding.tvDetailPlayerNationality.text = nationality ?: "N/A"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_NAME = "arg_name"
        private const val ARG_POSITION = "arg_position"
        private const val ARG_DOB = "arg_dob"
        private const val ARG_NATIONALITY = "arg_nationality"

        fun newInstance(
            name: String,
            position: String,
            dob: String,
            nationality: String
        ) = PlayerDetailFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_NAME, name)
                putString(ARG_POSITION, position)
                putString(ARG_DOB, dob)
                putString(ARG_NATIONALITY, nationality)
            }
        }
    }
}

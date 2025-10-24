package com.unsoed.responsi1mobileh1d023114.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.unsoed.responsi1mobileh1d023114.data.model.Player
import com.unsoed.responsi1mobileh1d023114.databinding.FragmentSquadBinding
import com.unsoed.responsi1mobileh1d023114.ui.adapter.OnPlayerClickListener
import com.unsoed.responsi1mobileh1d023114.ui.adapter.PlayerAdapter
import com.unsoed.responsi1mobileh1d023114.viewmodel.MainViewModel

class SquadFragment : Fragment(), OnPlayerClickListener {

    private var _binding: FragmentSquadBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var playerAdapter: PlayerAdapter
    private val teamId = 558

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSquadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playerAdapter = PlayerAdapter(emptyList(), this)

        binding.rvPlayers.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = playerAdapter
        }

        viewModel.fetchTeamDetails(teamId)
        observeSquadData()
    }

    private fun observeSquadData() {
        viewModel.teamDetails.observe(viewLifecycleOwner) { teamResponse ->
            val squadList: List<Player> = teamResponse?.squad ?: emptyList()
            playerAdapter.setData(squadList)
        }
    }

    override fun onPlayerClick(player: Player) {
        val fragment = PlayerDetailFragment.newInstance(
            name = player.name ?: "N/A",
            position = player.position ?: "N/A",
            dob = player.dateOfBirth ?: "N/A",
            nationality = player.nationality ?: "N/A"
        )
        fragment.show(parentFragmentManager, "PlayerDetailFragmentTag")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

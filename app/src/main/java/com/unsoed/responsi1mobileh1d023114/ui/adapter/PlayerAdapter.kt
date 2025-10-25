package com.unsoed.responsi1mobileh1d023114.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.unsoed.responsi1mobileh1d023114.R
import com.unsoed.responsi1mobileh1d023114.data.model.Player
import com.unsoed.responsi1mobileh1d023114.databinding.ItemPlayerBinding

class PlayerAdapter(
    private var players: List<Player>,
    private val listener: OnPlayerClickListener
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(private val binding: ItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(player: Player) {
            binding.tvPlayerName.text = player.name ?: "Unknown"
            binding.tvPlayerNationality.text = player.nationality ?: "-"

            val position = player.position?.lowercase() ?: ""
            val card = binding.cardPlayer

            // Deteksi posisi berdasarkan berbagai variasi dari API
            val colorRes = when {
                position.contains("keeper") -> R.color.yellow_card   // Goalkeeper
                position.contains("defender") ||
                        position.contains("defence") ||
                        position.contains("back") -> R.color.blue_card       // Defender
                position.contains("midfield") -> R.color.green_card  // Midfielder
                position.contains("forward") ||
                        position.contains("offence") ||
                        position.contains("wing") ||
                        position.contains("striker") ||
                        position.contains("attacker") -> R.color.red_card    // Forward
                else -> R.color.white                                // Tidak terdeteksi
            }

            card.setCardBackgroundColor(card.context.getColor(colorRes))

            // Klik pemain -> buka detail
            binding.root.setOnClickListener {
                listener.onPlayerClick(player)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ItemPlayerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.bind(players[position])
    }

    override fun getItemCount(): Int = players.size

    fun setData(newPlayers: List<Player>) {
        players = newPlayers
        notifyDataSetChanged()
    }
}

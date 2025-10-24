package com.unsoed.responsi1mobileh1d023114.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.unsoed.responsi1mobileh1d023114.R
import com.unsoed.responsi1mobileh1d023114.data.model.Player
import com.unsoed.responsi1mobileh1d023114.databinding.ItemPlayerBinding

class PlayerAdapter(
    private var players: List<Player>,
    private val listener: OnPlayerClickListener
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(val binding: ItemPlayerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val binding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    override fun getItemCount(): Int = players.size

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]

        holder.binding.tvPlayerName.text = player.name ?: "N/A"
        holder.binding.tvPlayerNationality.text = player.nationality ?: "N/A"

        // Tentukan kategori posisi pemain
        val playerCategory = when (player.position) {
            "Goalkeeper" -> "Goalkeeper"
            "Defence", "Centre-Back", "Left-Back", "Right-Back" -> "Defender"
            "Central Midfield", "Defensive Midfield", "Attacking Midfield" -> "Midfielder"
            "Offence", "Right Winger", "Centre-Forward", "Left Winger" -> "Forward"
            else -> "Unknown"
        }

        // Ganti warna card sesuai kategori
        val colorRes = when (playerCategory) {
            "Goalkeeper" -> R.color.yellow
            "Defender" -> R.color.blue
            "Midfielder" -> R.color.green
            "Forward" -> R.color.red
            else -> R.color.gray
        }

        holder.binding.cardPlayer.setCardBackgroundColor(
            ContextCompat.getColor(holder.itemView.context, colorRes)
        )

        // Klik item
        holder.binding.root.setOnClickListener {
            listener.onPlayerClick(player)
        }
    }

    fun setData(newPlayers: List<Player>) {
        players = newPlayers
        notifyDataSetChanged()
    }
}
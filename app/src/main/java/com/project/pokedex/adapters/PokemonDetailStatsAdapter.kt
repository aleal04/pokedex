package com.project.pokedex.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.pokedex.R
import com.skydoves.progressview.ProgressView
import com.project.pokedex.network.models.StatsDescription


class PokemonDetailStatsAdapter : RecyclerView.Adapter<PokemonDetailStatsAdapter.StatsPokemonViewHolder>(){
    private var statsList: List<StatsDescription> = emptyList()

    fun setData(list: List<StatsDescription>){
        statsList = list
        notifyDataSetChanged()
    }

    inner class StatsPokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var statsNameTextView: TextView = itemView.findViewById(R.id.textViewStatsName)
        private var statsProgressBar: ProgressView = itemView.findViewById(R.id.progressBarStats)

        fun bind(model: StatsDescription){
            statsNameTextView.text = model.stat.name?.replaceFirstChar { it.uppercase() }
            statsProgressBar.progress = model.base_stat.toFloat()
            statsProgressBar.labelText = "${model.base_stat.toFloat()} / 255"
        }
    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): PokemonDetailStatsAdapter.StatsPokemonViewHolder {
        val holderView = LayoutInflater.from(parent.context).inflate(R.layout.stats_list, parent , false)
        return StatsPokemonViewHolder(holderView)
    }

    override fun onBindViewHolder( holder: PokemonDetailStatsAdapter.StatsPokemonViewHolder, position: Int ) {
        holder.bind(statsList[position])
    }

    override fun getItemCount(): Int= statsList.size


}
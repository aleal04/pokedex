package com.project.pokedex.views.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.pokedex.R
import com.project.pokedex.network.models.StatsDescription
import com.project.pokedex.network.models.ability
import com.skydoves.progressview.ProgressView

class PokemonDetailAdapter : RecyclerView.Adapter<PokemonDetailAdapter.AbilitiesPokemonViewHolder>(){

    var abilitiesList: List<ability> = emptyList()

    fun setData(list: List<ability>){
        abilitiesList = list
        notifyDataSetChanged()
    }

    inner class AbilitiesPokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var abilityTextView: TextView = itemView.findViewById(R.id.textViewAbilities)

        fun bind(model: ability){
            abilityTextView.text = model.ability.name?.replaceFirstChar { it.uppercase() }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbilitiesPokemonViewHolder {
        val holderView = LayoutInflater.from(parent.context).inflate(R.layout.abilities_list, parent , false)
        return AbilitiesPokemonViewHolder(holderView)
    }

    override fun onBindViewHolder(holder: AbilitiesPokemonViewHolder, position: Int) {
        holder.bind(abilitiesList[position])
    }

    override fun getItemCount(): Int= abilitiesList.size
}

class PokemonDetailStatsAdapter : RecyclerView.Adapter<PokemonDetailStatsAdapter.StatsPokemonViewHolder>(){
    var statsList: List<StatsDescription> = emptyList()

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonDetailStatsAdapter.StatsPokemonViewHolder {
        val holderView = LayoutInflater.from(parent.context).inflate(R.layout.stats_list, parent , false)
        return StatsPokemonViewHolder(holderView)
    }

    override fun onBindViewHolder( holder: PokemonDetailStatsAdapter.StatsPokemonViewHolder, position: Int ) {
        holder.bind(statsList[position])
    }

    override fun getItemCount(): Int= statsList.size
}
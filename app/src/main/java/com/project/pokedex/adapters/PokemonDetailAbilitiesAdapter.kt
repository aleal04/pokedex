package com.project.pokedex.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.pokedex.R
import com.project.pokedex.network.models.ability

class PokemonDetailAbilitiesAdapter : RecyclerView.Adapter<PokemonDetailAbilitiesAdapter.AbilitiesPokemonViewHolder>() {

    private var abilitiesList: List<ability> = emptyList()

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
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokemonDetailAbilitiesAdapter.AbilitiesPokemonViewHolder {
        val holderView = LayoutInflater.from(parent.context).inflate(R.layout.abilities_list, parent , false)
        return AbilitiesPokemonViewHolder(holderView)
    }

    override fun onBindViewHolder(
        holder: PokemonDetailAbilitiesAdapter.AbilitiesPokemonViewHolder,
        position: Int
    ) {
        holder.bind(abilitiesList[position])
    }

    override fun getItemCount(): Int = abilitiesList.size
}
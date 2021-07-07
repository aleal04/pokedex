package com.project.pokedex.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.pokedex.R
import com.project.pokedex.views.models.AllPokemon

class AllPokemonAdapter: RecyclerView.Adapter<AllPokemonAdapter.AllPokemonViewHolder>() {

    var pokeAllList: List<AllPokemon> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }


    inner class AllPokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var namePokeTextView: TextView = itemView.findViewById(R.id.textViewCellPokeNameAll)
        private var typePokeTextView: TextView = itemView.findViewById(R.id.textViewCellPokeDescAll)
        private var imageViewPoke : ImageView = itemView.findViewById(R.id.imageViewCellPokeAll)


        fun bind(model: AllPokemon){
            namePokeTextView.text = model.name
            typePokeTextView.text = model.Type
            //

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllPokemonViewHolder {
        val holderView = LayoutInflater.from(parent.context).inflate(R.layout.item_all_cell, parent , false)
        return AllPokemonViewHolder(holderView)
    }

    override fun onBindViewHolder(holder: AllPokemonViewHolder, position: Int) {
        holder.bind(pokeAllList[position])
    }

    override fun getItemCount(): Int= pokeAllList.size

}
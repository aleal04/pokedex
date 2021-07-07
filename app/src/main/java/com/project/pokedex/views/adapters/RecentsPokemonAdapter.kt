package com.project.pokedex.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.pokedex.R
import com.project.pokedex.views.models.RecentsPokemon

class RecentsPokemonAdapter : RecyclerView.Adapter<RecentsPokemonAdapter.RecentsPokemonViewHolder>(){
    var pokeRecentList: List<RecentsPokemon> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    inner class RecentsPokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var namePokeTextView: TextView = itemView.findViewById(R.id.textViewCellPokeNameRec)
        private var typePokeTextView: TextView = itemView.findViewById(R.id.textViewCellPokeDescRec)
        private var imageViewPoke : ImageView = itemView.findViewById(R.id.imageViewCellPokeRec)


        fun bind(model: RecentsPokemon){
            namePokeTextView.text = model.name
            typePokeTextView.text = model.Type
            //

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentsPokemonViewHolder {
        val holderView = LayoutInflater.from(parent.context).inflate(R.layout.item_recent_cell, parent , false)
        return RecentsPokemonViewHolder(holderView)
    }

    override fun onBindViewHolder(holder: RecentsPokemonViewHolder, position: Int) {
        holder.bind(pokeRecentList[position])
    }

    override fun getItemCount():  Int = pokeRecentList.size
}
package com.project.pokedex.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.pokedex.R
import com.project.pokedex.views.models.FavoritesPokemon


class FavoritesPokemonAdapter: RecyclerView.Adapter<FavoritesPokemonAdapter.FavoritesPokemonViewHolder>() {

    var pokeFavoritesList: List<FavoritesPokemon> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    inner class FavoritesPokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var namePokeTextView: TextView = itemView.findViewById(R.id.textViewCellPokeNameFav)
        private var typePokeTextView: TextView = itemView.findViewById(R.id.textViewCellPokeDescFav)
        private var imageViewPoke : ImageView = itemView.findViewById(R.id.imageViewCellPokeFav)


        fun bind(model: FavoritesPokemon){
            namePokeTextView.text = model.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesPokemonViewHolder {
        val holderView = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite_cell, parent , false)
        return FavoritesPokemonViewHolder(holderView)
    }

    override fun onBindViewHolder(holder: FavoritesPokemonViewHolder, position: Int) {
        holder.bind(pokeFavoritesList[position])
    }

    override fun getItemCount(): Int = pokeFavoritesList.size


}
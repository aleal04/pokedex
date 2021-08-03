package com.project.pokedex.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.pokedex.R
import com.project.pokedex.db.entity.PokeRecent
import com.squareup.picasso.Picasso

class PokemonRecentsAdapter : RecyclerView.Adapter<PokemonRecentsAdapter.RecentsPokemonViewHolder>(){
    var pokeRecentList: List<PokeRecent> = emptyList()


    fun setData(list: List<PokeRecent>){
        pokeRecentList = list
        notifyDataSetChanged()
    }

    inner class RecentsPokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var numberPokeTextView: TextView = itemView.findViewById(R.id.textViewCellPokeNumberRec)
        private var namePokeTextView: TextView = itemView.findViewById(R.id.textViewCellPokeNameRec)
        private var imageViewPoke : ImageView = itemView.findViewById(R.id.imageViewCellPokeRec)


        fun bind(pokeRecent : PokeRecent){
            namePokeTextView.text = pokeRecent.pokeName.replaceFirstChar { it.uppercase() }
            numberPokeTextView.text = "N.° " + String.format("%04d", pokeRecent.pokeNumber);
            Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + pokeRecent.pokeNumber +".png").into(imageViewPoke)

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
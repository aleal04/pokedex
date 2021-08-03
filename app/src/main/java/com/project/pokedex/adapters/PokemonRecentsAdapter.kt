package com.project.pokedex.adapters

import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.project.pokedex.databinding.ItemRecentCellBinding
import com.project.pokedex.db.entity.PokeRecent
import com.squareup.picasso.Picasso

class PokemonRecentsAdapter : RecyclerView.Adapter<PokemonRecentsAdapter.PokemonPokemonRecentViewHolder>() {
    var pokeRecentList: List<PokeRecent> = emptyList()

        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class PokemonPokemonRecentViewHolder(private val binding: ItemRecentCellBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(model: PokeRecent){
            binding.textViewCellPokeNameRec.text = model.pokeName.replaceFirstChar { it.uppercase() }
            binding.textViewCellPokeNumberRec.text = "N.° " + String.format("%04d", model.pokeNumber);
            Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + model.pokeNumber +".png").into(binding.imageViewCellPokeRec)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonPokemonRecentViewHolder {
        val binding = ItemRecentCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonPokemonRecentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonPokemonRecentViewHolder, position: Int) {
        holder.bind(pokeRecentList[position])
    }

    override fun getItemCount(): Int= pokeRecentList.size
}
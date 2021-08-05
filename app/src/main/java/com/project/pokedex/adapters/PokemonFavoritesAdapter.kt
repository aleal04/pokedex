package com.project.pokedex.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.pokedex.databinding.ItemAllCellBinding
import com.project.pokedex.databinding.ItemFavoriteCellBinding
import com.project.pokedex.db.entity.PokeFavorite
import com.squareup.picasso.Picasso

class PokemonFavoritesAdapter(val onPokemonDelete: ((Int) -> (Unit)), val onPokemonDetail: ((Int) -> (Unit))) : RecyclerView.Adapter<PokemonFavoritesAdapter.PokemonListViewHolder>() {
    var pokeList: List<PokeFavorite> = emptyList()

        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class PokemonListViewHolder(private val binding: ItemFavoriteCellBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(model: PokeFavorite){
            binding.textViewCellPokeNameFav.text = model.pokeName.replaceFirstChar { it.uppercase() }
            binding.textViewCellPokeNumberFav.text = "N.° " + String.format("%04d", model.pokeNumber);
            Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + model.pokeNumber +".png").into(binding.imageViewCellPokeFav)

            binding.imageButtonPokeFavorite.setOnClickListener {
                onPokemonDelete.invoke(model.pokeNumber)
            }

            binding.imageViewCellPokeFav.setOnClickListener{
                onPokemonDetail?.invoke(model.pokeNumber)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        val binding = ItemFavoriteCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        holder.bind(pokeList[position])
    }

    override fun getItemCount(): Int= pokeList.size
}
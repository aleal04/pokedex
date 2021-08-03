package com.project.pokedex.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.pokedex.databinding.ItemAllCellBinding
import com.project.pokedex.network.models.PokeResult
import com.squareup.picasso.Picasso

class PokemonListAdapter(val onPokemonClicked: ((PokeResult) -> (Unit))? = null): RecyclerView.Adapter<PokemonListAdapter.PokemonListViewHolder>() {
    var pokeList: List<PokeResult> = emptyList()

    fun setData(list: List<PokeResult>){
        pokeList = list
        notifyDataSetChanged()
    }

    inner class PokemonListViewHolder(private val binding: ItemAllCellBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(model: PokeResult){
            binding.textViewCellPokeNameAll.text = model.name.replaceFirstChar { it.uppercase() }
            binding.textViewCellPokeNumberAll.text = "N.° " + String.format("%04d", model.number);
            Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + model.number +".png").into(binding.imageViewCellPokeAll)

            itemView.setOnClickListener{
                onPokemonClicked?.invoke(model)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        val binding = ItemAllCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        holder.bind(pokeList[position])
    }

    override fun getItemCount(): Int= pokeList.size
}
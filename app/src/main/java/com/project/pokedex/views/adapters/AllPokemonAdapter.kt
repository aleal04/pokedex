package com.project.pokedex.views.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.pokedex.R
import com.project.pokedex.network.models.PokeResult
import com.squareup.picasso.Picasso


class AllPokemonAdapter(val onPokemonClicked: ((PokeResult) -> (Unit))? = null): RecyclerView.Adapter<AllPokemonAdapter.AllPokemonViewHolder>() {

    var pokeAllList: List<PokeResult> = emptyList()

    fun setData(list: List<PokeResult>){
        pokeAllList = list
        notifyDataSetChanged()
    }


    inner class AllPokemonViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private var namePokeTextView: TextView = itemView.findViewById(R.id.textViewCellPokeNameAll)
        private var imageViewPoke : ImageView = itemView.findViewById(R.id.imageViewCellPokeAll)
        private var numberPokeTextView : TextView = itemView.findViewById(R.id.textViewCellPokeNumberAll)


        fun bind(model: PokeResult){
            namePokeTextView.text = model.name.replaceFirstChar { it.uppercase() }
            numberPokeTextView.text = "N.° " + String.format("%04d", model.number);
            itemView.setOnClickListener{onPokemonClicked?.invoke(model)}
            Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + model.number +".png").into(imageViewPoke)
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
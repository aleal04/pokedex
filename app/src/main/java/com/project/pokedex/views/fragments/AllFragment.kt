package com.project.pokedex.views.fragments

import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.project.pokedex.R
import com.project.pokedex.views.adapters.AllPokemonAdapter
import com.project.pokedex.views.adapters.RecentsPokemonAdapter
import com.project.pokedex.views.models.AllPokemon
import com.project.pokedex.views.models.RecentsPokemon


class AllFragment : Fragment(R.layout.fragment_all) {
    private lateinit var allRecyclerView: RecyclerView

    private val adapter = AllPokemonAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        allRecyclerView = view.findViewById(R.id.recyclerViewAll)
        allRecyclerView.addItemDecoration(DividerItemDecoration(requireContext() , ClipDrawable.VERTICAL))
        allRecyclerView.adapter = adapter
    }

    private fun getDummyAllPokemons() : List<AllPokemon>{
        return listOf(
            AllPokemon("Pikachu" , "Electrico" , ""),
            AllPokemon("Charizard" , "Fuego" , ""),
            AllPokemon("Charmander" , "Fuego" , ""),
            AllPokemon("Mew" , "Psiquico" , ""),
            AllPokemon("Diglett" , "Tierra" , ""),
            AllPokemon("Ditto" , "Normal" , ""),
            AllPokemon("Ekans" , "Veneno" , ""),
        )
    }
}
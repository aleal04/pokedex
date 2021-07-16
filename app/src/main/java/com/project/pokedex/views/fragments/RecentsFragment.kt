package com.project.pokedex.views.fragments

import android.os.Bundle
import android.view.View
import com.project.pokedex.R
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import com.project.pokedex.views.adapters.RecentsPokemonAdapter
import com.project.pokedex.views.models.RecentsPokemon


class RecentsFragment : Fragment(R.layout.fragment_recents) {

    private lateinit var recentsRecyclerView: RecyclerView

    private val adapter = RecentsPokemonAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recentsRecyclerView = view.findViewById(R.id.recyclerViewRecent)
        recentsRecyclerView.addItemDecoration(DividerItemDecoration(requireContext() , VERTICAL))
        recentsRecyclerView.adapter = adapter

        adapter.pokeRecentList = getDummyRecentsPokemons()

    }

    private fun getDummyRecentsPokemons() : List<RecentsPokemon>{
        return listOf(
            RecentsPokemon("Pikachu" , "Electrico" , ""),
            RecentsPokemon("Charizard" , "Fuego" , ""),
            RecentsPokemon("Charmander" , "Fuego" , ""),
            RecentsPokemon("Mew" , "Psiquico" , ""),
            RecentsPokemon("Diglett" , "Tierra" , ""),
            RecentsPokemon("Ditto" , "Normal" , ""),
            RecentsPokemon("Ekans" , "Veneno" , ""),
        )
    }




}
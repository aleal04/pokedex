package com.project.pokedex.views.fragments

import android.graphics.drawable.ClipDrawable.VERTICAL
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.project.pokedex.R
import com.project.pokedex.views.adapters.FavoritesPokemonAdapter
import com.project.pokedex.views.models.AllPokemon
import com.project.pokedex.views.models.FavoritesPokemon

class FavoritesFragment : Fragment(R.layout.fragment_favorites) {

    private lateinit var favoriteRecyclerView: RecyclerView

    private val adapter = FavoritesPokemonAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favoriteRecyclerView = view.findViewById(R.id.recyclerViewFav)
        favoriteRecyclerView.addItemDecoration(DividerItemDecoration(requireContext() , VERTICAL))
        favoriteRecyclerView.adapter = adapter
    }

    private fun getDummyFavoritesPokemons() : List<FavoritesPokemon>{
        return listOf(
            FavoritesPokemon("Pikachu" , "Electrico" , ""),
            FavoritesPokemon("Charizard" , "Fuego" , ""),
            FavoritesPokemon("Charmander" , "Fuego" , ""),
            FavoritesPokemon("Mew" , "Psiquico" , ""),
            FavoritesPokemon("Diglett" , "Tierra" , ""),
            FavoritesPokemon("Ditto" , "Normal" , ""),
            FavoritesPokemon("Ekans" , "Veneno" , ""),
        )
    }
}
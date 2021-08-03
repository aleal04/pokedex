package com.project.pokedex.views.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.rxbinding4.view.visibility
import com.project.pokedex.R
import com.project.pokedex.adapters.PokemonFavoritesAdapter
import com.project.pokedex.databinding.FragmentPokemonFavoritesBinding
import com.project.pokedex.viewmodels.ListPokemonFavoritesViewModel

class PokemonFavoritesFragment : Fragment(){

    private var _binding: FragmentPokemonFavoritesBinding  ? = null
    private val binding get() = _binding!!

    private lateinit var sharedPref: SharedPreferences


    private lateinit var productRecyclerView: RecyclerView
    private lateinit var viewModel: ListPokemonFavoritesViewModel


    private val adapter = PokemonFavoritesAdapter { pokemonListFav ->
        viewModel.deletePokeFavorites(pokemonListFav.toInt())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        viewModel = ViewModelProvider(this).get(ListPokemonFavoritesViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokeTrainer = sharedPref.getString("TRAINER_NAME", "") ?: ""

        productRecyclerView = view.findViewById(R.id.recyclerViewFav)
        productRecyclerView.adapter = adapter

        viewModel.fetchPokeFavorites(pokeTrainer).observe(viewLifecycleOwner) {
            binding.emptyWidgetFavoritesPokemon.visibility = if(it.size > 0) View.GONE else View.VISIBLE
            adapter.pokeList = it
        }
    }
}
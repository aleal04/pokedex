package com.project.pokedex.views.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.project.pokedex.R

import com.project.pokedex.viewmodels.PokemonInfoViewModel

class PokemonDetailFragment : Fragment(R.layout.fragment_pokemon_detail){

    private val args: PokemonDetailFragmentArgs by navArgs()

    private lateinit var auxTextVIew: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auxTextVIew = view.findViewById(R.id.auxtextView)
        auxTextVIew.text = args.pokemonSelected.name

    }



}
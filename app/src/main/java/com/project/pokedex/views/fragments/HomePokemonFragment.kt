package com.project.pokedex.views.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.pokedex.R
import com.project.pokedex.databinding.FragmentHomePokemonBinding
import com.project.pokedex.databinding.FragmentPokemonDetailBinding


class HomePokemonFragment : Fragment(R.layout.fragment_home_pokemon) {

    private var _binding: FragmentHomePokemonBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomePokemonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostFragment = childFragmentManager.findFragmentById(R.id.nav_host_fragment_pokemon_list) as NavHostFragment
        val navController = navHostFragment.navController
        binding.pokeBottomNavigationView.setupWithNavController(navController)

    }
}
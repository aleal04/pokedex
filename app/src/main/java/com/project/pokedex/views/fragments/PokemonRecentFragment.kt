package com.project.pokedex.views.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.project.pokedex.R
import com.project.pokedex.adapters.PokemonRecentsAdapter
import com.project.pokedex.databinding.FragmentPokemonRecentBinding
import com.project.pokedex.viewmodels.ListPokemonRecentViewModel


class PokemonRecentFragment : Fragment(R.layout.fragment_pokemon_recent) {


    private lateinit var recentsRecyclerView: RecyclerView
    /*View Binding*/
    private var _binding: FragmentPokemonRecentBinding? = null
    private val binding get() = _binding!!
    /*View Model*/
    private lateinit var viewModel: ListPokemonRecentViewModel
    /*Shared Preferences*/
    private lateinit var sharedPref: SharedPreferences
    /*Adapter*/
    private val adapter = PokemonRecentsAdapter(){
        val action = PokemonRecentFragmentDirections.actionPokemonRecentFragmentToPokemonDetailFragment(it)
        findNavController().navigate(action)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        viewModel = ViewModelProvider(this).get(ListPokemonRecentViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonRecentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokeTrainer = sharedPref.getString("TRAINER_NAME", "") ?: ""

        recentsRecyclerView = view.findViewById(R.id.recyclerViewRecent)
        recentsRecyclerView.addItemDecoration(DividerItemDecoration(requireContext() , DividerItemDecoration.VERTICAL))
        recentsRecyclerView.adapter = adapter

        viewModel.getPokemonRecentsByTrainer(pokeTrainer).observe(viewLifecycleOwner){
            binding.emptyWidgetRecentsPokemon.visibility = if(it.size > 0) View.GONE else View.VISIBLE
            adapter.pokeRecentList = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
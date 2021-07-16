package com.project.pokedex.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.pokedex.R
import com.project.pokedex.viewmodels.PokemonAllViewModel
import com.project.pokedex.views.adapters.AllPokemonAdapter


class AllFragment : Fragment(R.layout.fragment_all) {

    private var offset = 0
    private lateinit var allRecyclerView: RecyclerView
    private lateinit var viewModel: PokemonAllViewModel

    private val adapter = AllPokemonAdapter{ pokemonInformation ->
        val action = AllFragmentDirections.actionAllFragment2ToPokemonDetailFragment2(pokemonInformation)
        findNavController().navigate(action)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PokemonAllViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        allRecyclerView = view.findViewById(R.id.recyclerViewAll)
        allRecyclerView.addItemDecoration(DividerItemDecoration(requireContext() , VERTICAL))
        allRecyclerView.adapter = adapter

        viewModel.getPokemonList(offset)

        viewModel.pokemonAllLiveData.observe(viewLifecycleOwner) { list ->
            adapter.setData(list)
        }

        allRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if(dy > 0){
                    val visibleItemCount : Int=  (allRecyclerView.layoutManager as LinearLayoutManager).childCount
                    val totalItemCount : Int= (allRecyclerView.layoutManager as LinearLayoutManager).itemCount
                    val pastVisibleItem : Int = (allRecyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                    if((visibleItemCount + pastVisibleItem) >= totalItemCount){
                        offset += 10
                        viewModel.getPokemonList(offset)
                    }
                }
            }
        })




    }

}
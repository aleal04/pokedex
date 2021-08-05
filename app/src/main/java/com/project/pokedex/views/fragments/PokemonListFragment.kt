package com.project.pokedex.views.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.project.pokedex.R
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.project.pokedex.adapters.PokemonListAdapter
import com.project.pokedex.viewmodels.PokemonAllViewModel

class PokemonListFragment : Fragment(R.layout.fragment_pokemon_list) {

    private var offset = 0
    private lateinit var allRecyclerView: RecyclerView
    private lateinit var viewModel: PokemonAllViewModel
    /*Progress Bar*/
    private lateinit var progressBarLoading: ProgressBar

    private lateinit var sharedPref: SharedPreferences

    private val adapter = PokemonListAdapter { pokemonInformation ->
        val action = PokemonListFragmentDirections.actionPokemonListFragmentToPokemonDetailFragment(pokemonInformation)
        findNavController().navigate(action)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        viewModel = ViewModelProvider(this).get(PokemonAllViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBarLoading = view.findViewById(R.id.progressBarPokemonList)

        allRecyclerView = view.findViewById(R.id.recyclerViewAll)
        allRecyclerView.adapter = adapter

        viewModel.getPokemonList(offset)

        viewModel.pokemonAllLiveData.observe(viewLifecycleOwner) { list ->
            adapter.setData(list)
        }

        viewModel.isLoading.observe(viewLifecycleOwner){
            progressBarLoading.visibility = if(it) View.VISIBLE else View.GONE
        }

        viewModel.serverError.observe(viewLifecycleOwner){
            Snackbar.make(view, requireContext().getString(R.string.server_error_message), Snackbar.LENGTH_LONG).show()
        }



       allRecyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener(){

           override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
               super.onScrollStateChanged(recyclerView, newState)
               if(!allRecyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE){
                   Log.e("Final" , "END OF RECYCLER VIEW")

                   offset += 15
                   viewModel.getPokemonList(offset)
               }
           }

            /*override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(dy > 0){
                    val visibleItemCount : Int=  (allRecyclerView.layoutManager as LinearLayoutManager).childCount
                    val totalItemCount : Int= (allRecyclerView.layoutManager as LinearLayoutManager).itemCount
                    val pastVisibleItem : Int = (allRecyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()

                    if((visibleItemCount + pastVisibleItem) >= totalItemCount){
                        offset += 10
                        viewModel.getPokemonList(offset)
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }*/


        })
    }
}
package com.project.pokedex.views.fragments

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import com.project.pokedex.R
import com.project.pokedex.adapters.PokemonDetailAbilitiesAdapter
import com.project.pokedex.adapters.PokemonDetailStatsAdapter
import com.project.pokedex.databinding.FragmentPokemonDetailBinding
import com.project.pokedex.viewmodels.PokemonInfoViewModel
import com.project.pokedex.viewmodels.StorePokemonFavoriteViewModel
import com.project.pokedex.viewmodels.StorePokemonRecentViewModel


class PokemonDetailFragment : Fragment(R.layout.fragment_pokemon_detail){
    /*Safe Args*/
    private val args: PokemonDetailFragmentArgs by navArgs()
    /*Adapter*/
    private val adapter = PokemonDetailAbilitiesAdapter()
    private val adapterStat = PokemonDetailStatsAdapter()
    /*View Model*/
    private lateinit var viewModel: PokemonInfoViewModel
    private lateinit var viewModelRecent : StorePokemonRecentViewModel
    private lateinit var viewModelFavorite : StorePokemonFavoriteViewModel
    /*Recycler View*/
    private lateinit var abilitiesRecyclerView: RecyclerView
    private lateinit var statsRecyclerView: RecyclerView
    /*View Binding*/
    private var _binding: FragmentPokemonDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        viewModel = ViewModelProvider(this).get(PokemonInfoViewModel::class.java)
        viewModelRecent = ViewModelProvider(this).get(StorePokemonRecentViewModel::class.java)
        viewModelFavorite = ViewModelProvider(this).get(StorePokemonFavoriteViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokeTrainer = sharedPref.getString("TRAINER_NAME", "") ?: ""

        viewModel.getPokemonDetail(args.pokemonID)

        abilitiesRecyclerView = binding.abilitiesRecyclerView
        abilitiesRecyclerView.adapter = adapter

        statsRecyclerView =  binding.recyclerViewStats
        statsRecyclerView.adapter = adapterStat

        viewModel.pokemonInfo.observe(viewLifecycleOwner) { list ->
            adapter.setData(list.abilities)
            adapterStat.setData(list.stats)
        }

        viewModel.pokemonInfo.observe(viewLifecycleOwner, { pokemon->
            binding.textViewPokeDetailHeight.text = "${pokemon.height/10.0} m"
            binding.textViewPokeDetailWeight.text =  "${pokemon.weight/10.0} kg"
            binding.textViewPokeDetailName.text = pokemon.name.replaceFirstChar { it.uppercase() }
            Glide.with(this).load(pokemon.sprites.front_default).into(binding.imageViewPokeDetailSprite)
            binding.textViewPokeDetailType1.text = pokemon.types[0].type.name.replaceFirstChar { it.uppercase() }
            binding.textViewPokeDetailNumber.text = "# " + String.format("%04d", pokemon.id);
            binding.textViewPokeDetailType1.setBackgroundColor(Color.parseColor(BackGroundColorByType(pokemon.types[0].type.name.replaceFirstChar { it.uppercase() })))
            binding.headerPokemon.setBackgroundColor(Color.parseColor(BackGroundColorByType(pokemon.types[0].type.name.replaceFirstChar { it.uppercase() })))

            if(pokemon.types.size > 1){
                binding.textViewPokeDetailType2.visibility = View.VISIBLE
                binding.textViewPokeDetailType2.text = pokemon.types[1].type.name.replaceFirstChar { it.uppercase() }
                binding.textViewPokeDetailType2.setBackgroundColor(Color.parseColor(BackGroundColorByType(pokemon.types[1].type.name.replaceFirstChar { it.uppercase() })))
            }
            else{
                binding.textViewPokeDetailType2.visibility = View.GONE
            }

            binding.iamgeButtonAddFavorite.setOnClickListener{
                viewModelFavorite.insert(pokemon.id , pokemon.name , pokeTrainer)
                binding.iamgeButtonAddFavorite.setImageResource(R.drawable.star_on)

                val snackbar: Snackbar = Snackbar.make(view, requireContext().getString(R.string.pokemon_add_favorites), Snackbar.LENGTH_LONG);
                snackbar.anchorView = view.findViewById(R.id.pokeBottomNavigationView)
                snackbar.show()
            }
            viewModelRecent.insert(pokemon.id , pokemon.name , pokeTrainer)
        })

        viewModel.isLoading.observe(viewLifecycleOwner){
            binding.progressBarLoading.visibility = if(it) View.VISIBLE else View.GONE
        }

        viewModel.serverError.observe(viewLifecycleOwner){
            Snackbar.make(view, requireContext().getString(R.string.server_error_message), Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



    private fun BackGroundColorByType(type: String = "Fire"): String{
        var color: String = "#EA7A3C"
        when (type) {
            "Fire" -> {
                color = "#EA7A3C"
            }
            "Water" -> {
                color =  "#539AE2"
            }
            "Steel" -> {
                color =  "#539AE2"
            }
            "Rock" -> {
                color =  "#B2A061"
            }
            "Psychic" -> {
                color =  "#E5709B"
            }
            "Poison" -> {
                color =  "#B468B7"
            }
            "Normal" -> {
                color =  "#AAB09F"
            }
            "Ice" -> {
                color =  "#70CBD4"
            }
            "Ground" -> {
                color =  "#CC9F4F"
            }
            "Grass" -> {
                color =  "#71C558"
            }
            "Ghost" -> {
                color =  "#846AB6"
            }
            "Flying" -> {
                color =  "#7DA6DE"
            }
            "Fighting" -> {
                color =  "#CB5F48"
            }
            "Fairy" -> {
                color =  "#E397D1"
            }
            "Electric" -> {
                color =  "#E5C531"
            }
            "Dragon" -> {
                color =  "#6A7BAF"
            }
            "Dark" -> {
                color =  "#736C75"
            }
            "Bug" -> {
                color =  "#94BC4A"
            }
        }

        return color
    }
}
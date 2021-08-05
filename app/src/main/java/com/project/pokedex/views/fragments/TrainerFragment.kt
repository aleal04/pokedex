package com.project.pokedex.views.fragments


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.jakewharton.rxbinding4.view.clicks
import com.jakewharton.rxbinding4.widget.textChanges
import com.project.pokedex.R
import com.project.pokedex.databinding.FragmentTrainerBinding
import com.project.pokedex.viewmodels.DeletePokemonRecentViewModel
import com.project.pokedex.viewmodels.PokemonInfoViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

class TrainerFragment : Fragment(R.layout.fragment_trainer){

    /*Binding*/
    private var _binding: FragmentTrainerBinding? = null
    private val binding get() = _binding!!
    //RX
    private val disposable = CompositeDisposable()
    //SharedPreferences
    private lateinit var sharedPref: SharedPreferences
    //ViewModel
    private lateinit var viewModel: DeletePokemonRecentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTrainerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        viewModel = ViewModelProvider(this).get(DeletePokemonRecentViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        disposable.add(
            binding.editTextTrainerName.textChanges()
                .debounce ( 250 ,  TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{
                binding.bntEntry.isEnabled = it.toString().isNotEmpty()
            }
        )

        disposable.add(
            binding.bntEntry.clicks()
                .throttleFirst(2000, TimeUnit.MILLISECONDS)
                .subscribe {
                    Log.d("CLICK EVENT", "Clickeado")
                }
        )

        binding.bntEntry.setOnClickListener{
            sharedPref.edit {
                putString("TRAINER_NAME", binding.editTextTrainerName.text.toString().uppercase())
                apply()
            }
            viewModel.delete(binding.editTextTrainerName.text.toString().uppercase())

            val action = TrainerFragmentDirections.actionTrainerFragmentToHomePokemonFragment()
            findNavController().navigate(action)
        }


    }

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
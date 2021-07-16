package com.project.pokedex.views.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.project.pokedex.R;

public class RecentsFragmentDirections {
  private RecentsFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionRecentsFragmentToPokemonDetailFragment() {
    return new ActionOnlyNavDirections(R.id.action_recentsFragment_to_pokemonDetailFragment);
  }
}

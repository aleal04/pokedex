package com.project.pokedex.views.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.project.pokedex.R;

public class FavoritesFragmentDirections {
  private FavoritesFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionFavoritesFragmentToPokemonDetailFragment() {
    return new ActionOnlyNavDirections(R.id.action_favoritesFragment_to_pokemonDetailFragment);
  }
}

package com.project.pokedex.views.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.project.pokedex.R;
import com.project.pokedex.network.models.PokeResult;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class AllFragmentDirections {
  private AllFragmentDirections() {
  }

  @NonNull
  public static ActionAllFragment2ToPokemonDetailFragment2 actionAllFragment2ToPokemonDetailFragment2(
      @NonNull PokeResult pokemonSelected) {
    return new ActionAllFragment2ToPokemonDetailFragment2(pokemonSelected);
  }

  public static class ActionAllFragment2ToPokemonDetailFragment2 implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionAllFragment2ToPokemonDetailFragment2(@NonNull PokeResult pokemonSelected) {
      if (pokemonSelected == null) {
        throw new IllegalArgumentException("Argument \"pokemon_selected\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("pokemon_selected", pokemonSelected);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionAllFragment2ToPokemonDetailFragment2 setPokemonSelected(
        @NonNull PokeResult pokemonSelected) {
      if (pokemonSelected == null) {
        throw new IllegalArgumentException("Argument \"pokemon_selected\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("pokemon_selected", pokemonSelected);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("pokemon_selected")) {
        PokeResult pokemonSelected = (PokeResult) arguments.get("pokemon_selected");
        if (Parcelable.class.isAssignableFrom(PokeResult.class) || pokemonSelected == null) {
          __result.putParcelable("pokemon_selected", Parcelable.class.cast(pokemonSelected));
        } else if (Serializable.class.isAssignableFrom(PokeResult.class)) {
          __result.putSerializable("pokemon_selected", Serializable.class.cast(pokemonSelected));
        } else {
          throw new UnsupportedOperationException(PokeResult.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_allFragment2_to_pokemonDetailFragment2;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public PokeResult getPokemonSelected() {
      return (PokeResult) arguments.get("pokemon_selected");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionAllFragment2ToPokemonDetailFragment2 that = (ActionAllFragment2ToPokemonDetailFragment2) object;
      if (arguments.containsKey("pokemon_selected") != that.arguments.containsKey("pokemon_selected")) {
        return false;
      }
      if (getPokemonSelected() != null ? !getPokemonSelected().equals(that.getPokemonSelected()) : that.getPokemonSelected() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getPokemonSelected() != null ? getPokemonSelected().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionAllFragment2ToPokemonDetailFragment2(actionId=" + getActionId() + "){"
          + "pokemonSelected=" + getPokemonSelected()
          + "}";
    }
  }
}

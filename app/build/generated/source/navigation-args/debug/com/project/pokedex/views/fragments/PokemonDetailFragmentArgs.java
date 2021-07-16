package com.project.pokedex.views.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import com.project.pokedex.network.models.PokeResult;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class PokemonDetailFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private PokemonDetailFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private PokemonDetailFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static PokemonDetailFragmentArgs fromBundle(@NonNull Bundle bundle) {
    PokemonDetailFragmentArgs __result = new PokemonDetailFragmentArgs();
    bundle.setClassLoader(PokemonDetailFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("pokemon_selected")) {
      PokeResult pokemonSelected;
      if (Parcelable.class.isAssignableFrom(PokeResult.class) || Serializable.class.isAssignableFrom(PokeResult.class)) {
        pokemonSelected = (PokeResult) bundle.get("pokemon_selected");
      } else {
        throw new UnsupportedOperationException(PokeResult.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (pokemonSelected == null) {
        throw new IllegalArgumentException("Argument \"pokemon_selected\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("pokemon_selected", pokemonSelected);
    } else {
      throw new IllegalArgumentException("Required argument \"pokemon_selected\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public PokeResult getPokemonSelected() {
    return (PokeResult) arguments.get("pokemon_selected");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    PokemonDetailFragmentArgs that = (PokemonDetailFragmentArgs) object;
    if (arguments.containsKey("pokemon_selected") != that.arguments.containsKey("pokemon_selected")) {
      return false;
    }
    if (getPokemonSelected() != null ? !getPokemonSelected().equals(that.getPokemonSelected()) : that.getPokemonSelected() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getPokemonSelected() != null ? getPokemonSelected().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "PokemonDetailFragmentArgs{"
        + "pokemonSelected=" + getPokemonSelected()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(PokemonDetailFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull PokeResult pokemonSelected) {
      if (pokemonSelected == null) {
        throw new IllegalArgumentException("Argument \"pokemon_selected\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("pokemon_selected", pokemonSelected);
    }

    @NonNull
    public PokemonDetailFragmentArgs build() {
      PokemonDetailFragmentArgs result = new PokemonDetailFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setPokemonSelected(@NonNull PokeResult pokemonSelected) {
      if (pokemonSelected == null) {
        throw new IllegalArgumentException("Argument \"pokemon_selected\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("pokemon_selected", pokemonSelected);
      return this;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public PokeResult getPokemonSelected() {
      return (PokeResult) arguments.get("pokemon_selected");
    }
  }
}

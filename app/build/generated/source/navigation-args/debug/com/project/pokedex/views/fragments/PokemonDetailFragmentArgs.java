package com.project.pokedex.views.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
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
    if (bundle.containsKey("pokemon_ID")) {
      int pokemonID;
      pokemonID = bundle.getInt("pokemon_ID");
      __result.arguments.put("pokemon_ID", pokemonID);
    } else {
      throw new IllegalArgumentException("Required argument \"pokemon_ID\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getPokemonID() {
    return (int) arguments.get("pokemon_ID");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("pokemon_ID")) {
      int pokemonID = (int) arguments.get("pokemon_ID");
      __result.putInt("pokemon_ID", pokemonID);
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
    if (arguments.containsKey("pokemon_ID") != that.arguments.containsKey("pokemon_ID")) {
      return false;
    }
    if (getPokemonID() != that.getPokemonID()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getPokemonID();
    return result;
  }

  @Override
  public String toString() {
    return "PokemonDetailFragmentArgs{"
        + "pokemonID=" + getPokemonID()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(PokemonDetailFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(int pokemonID) {
      this.arguments.put("pokemon_ID", pokemonID);
    }

    @NonNull
    public PokemonDetailFragmentArgs build() {
      PokemonDetailFragmentArgs result = new PokemonDetailFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setPokemonID(int pokemonID) {
      this.arguments.put("pokemon_ID", pokemonID);
      return this;
    }

    @SuppressWarnings("unchecked")
    public int getPokemonID() {
      return (int) arguments.get("pokemon_ID");
    }
  }
}

package com.project.pokedex.views.fragments;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.project.pokedex.R;

public class TrainerFragmentDirections {
  private TrainerFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionTrainerFragmentToManageFragment() {
    return new ActionOnlyNavDirections(R.id.action_trainerFragment_to_manageFragment);
  }
}

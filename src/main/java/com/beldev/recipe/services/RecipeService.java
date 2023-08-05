package com.beldev.recipe.services;

import com.beldev.recipe.models.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> listRecipes();
    Recipe createRecipe(Recipe recipe);
    Recipe getRecipe(Long id);
    Recipe updateRecipe(Long id, Recipe recipe);
    void deleteRecipe(Long id);
}

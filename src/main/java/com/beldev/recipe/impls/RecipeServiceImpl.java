package com.beldev.recipe.impls;

import com.beldev.recipe.models.Recipe;
import com.beldev.recipe.repositories.RecipeJpaRepository;
import com.beldev.recipe.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeJpaRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeJpaRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> listRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe getRecipe(Long id) {
        //return recipeRepository.getReferenceById(id);

        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        return optionalRecipe.orElse(null);
    }

    @Override
    public Recipe updateRecipe(Long id, Recipe recipe) {

        if (recipeRepository.existsById(id)){
            recipe.setId(id);
            return recipeRepository.save(recipe);
        }
        return null;
    }

    @Override
    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}

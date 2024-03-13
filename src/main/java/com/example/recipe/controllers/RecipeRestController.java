package com.example.recipe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.recipe.models.Recipe;
import com.example.recipe.repositories.RecipeJpaRepository;

@RestController
@RequestMapping ("api/v1/recipes")
public class RecipeRestController {

  @Autowired
  private RecipeJpaRepository repository;

  @GetMapping ("")
  public List<Recipe> listRecipes () {
    return repository.findAll ();
  }

  @GetMapping ("/{id}")
  public Recipe getRecipe (@PathVariable Long id) {
    return repository.getById (id);
  }

  @PostMapping ("")
  public Recipe createRecipe (@RequestBody Recipe recipe) {
    return repository.save (recipe);
  }

  @PutMapping ("/{id}")
  public Recipe changeRecipe (@RequestBody Recipe recipe,
                              @PathVariable Long id) {
    Recipe r = repository.save (recipe);
    r.setName (recipe.getName ());
    r.setDescription (recipe.getDescription ());
    return repository.save (r);
  }

  @DeleteMapping ("/{id}")
  public void deleteRecipe (@PathVariable Long id) {
    repository.deleteById (id);
  }

}

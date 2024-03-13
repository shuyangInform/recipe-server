package com.example.recipe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.recipe.models.Recipe;

@Repository
public interface RecipeJpaRepository extends JpaRepository<Recipe, Long> {

}

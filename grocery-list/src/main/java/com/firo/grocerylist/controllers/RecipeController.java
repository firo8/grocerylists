package com.firo.grocerylist.controllers;

import com.firo.grocerylist.models.Recipe;
import com.firo.grocerylist.repositories.RecipeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by User on 07-Aug-20.
 */

@RestController
@RequestMapping("/recipes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RecipeController {
    @Autowired
    private RecipeRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/")
    public List<Recipe> getRecipes() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{recipeId}")
    public Recipe getRecipeById(@PathVariable("recipeId") ObjectId id) {
        return repository.findBy_id(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{recipeId}")
    public void modifyRecipeById(@PathVariable("recipeId") ObjectId id, @RequestBody Recipe recipe) {
        recipe.set_id(id);
        repository.save(recipe);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/")
    public Recipe createRecipe(@Validated @RequestBody Recipe recipe) {
        System.out.print(recipe);
        recipe.set_id(ObjectId.get());
        repository.save(recipe);
        return recipe;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}

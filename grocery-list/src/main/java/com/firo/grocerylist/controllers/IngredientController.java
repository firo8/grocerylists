package com.firo.grocerylist.controllers;

import com.firo.grocerylist.models.Ingredient;
import com.firo.grocerylist.repositories.IngredientRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by User on 09-Aug-20.
 */

@RestController
@RequestMapping("/ingredients")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IngredientController {
    @Autowired
    private IngredientRepository repository;

    @GetMapping("/")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Ingredient> getIngredients() {
        return repository.findAll();
    }

    @GetMapping("/{ingredientId}")
    @CrossOrigin(origins = "http://localhost:8000", allowedHeaders = "*")
    public Ingredient getIngredientById(@PathVariable("ingredientId")ObjectId id) {
        return repository.findBy_id(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{ingredientId}")
    public void modifyIngredientById(@PathVariable("ingredientId") ObjectId id, @Validated @RequestBody Ingredient ingredient) {
        ingredient.set_id(id);
        repository.save(ingredient);
    }

    @CrossOrigin(origins = "http://localhost:8000", allowedHeaders = "*")
    @PostMapping("/")
    public Ingredient createIngredient(@Validated @RequestBody Ingredient ingredient) {
        ingredient.set_id(ObjectId.get());
        repository.save(ingredient);
        return ingredient;
    }

    @CrossOrigin(origins = "http://localhost:8000", allowedHeaders = "*")
    @DeleteMapping("/{ingredientId}")
    public void deleteIngredient(@PathVariable("ingredientId") ObjectId id) {
        repository.delete(repository.findBy_id(id));
    }
}

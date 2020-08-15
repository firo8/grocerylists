package com.firo.grocerylist.repositories;

import com.firo.grocerylist.models.Ingredient;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by User on 09-Aug-20.
 */
public interface IngredientRepository extends MongoRepository<Ingredient, String> {
    Ingredient findBy_id(ObjectId id);
}

package com.firo.grocerylist.repositories;

import com.firo.grocerylist.models.Recipe;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by User on 07-Aug-20.
 */
public interface RecipeRepository extends MongoRepository<Recipe, String> {
    Recipe findBy_id(ObjectId _id);


}

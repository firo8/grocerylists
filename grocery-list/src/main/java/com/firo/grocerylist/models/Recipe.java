package com.firo.grocerylist.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rob Hoek on 07-Aug-20.
 *
 * This is the model for all recipes to be added to the database
 */

public class Recipe {

    @Id
    private ObjectId _id;

    private String name;
    private Integer prepTime, cookTime, serves; // Times in minutes

    private List<Object> ingredients = new ArrayList<Object>();
    private List<Object> instructions = new ArrayList<Object>();

    public Recipe() {
    }

    public Recipe(String name) {
        this.name = name;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public String getName() {
        return name;
    }

    public void set_id(ObjectId id) {
        this._id = _id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Integer prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServes() { return serves; }

    public void setServes(Integer serves) { this.serves = serves; }

    public List<Object> getIngredients() {
        return ingredients;
    }

    public List<Object> getInstructions() {
        return instructions;
    }

    public void setIngredients(List<Object> ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(List<Object> instructions) {
        this.instructions = instructions;
    }
}

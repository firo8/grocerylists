package com.firo.grocerylist.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * Created by User on 09-Aug-20.
 */
public class Ingredient {

    @Id
    private ObjectId _id;

    private String name;
    private String qtyType;

    public Ingredient(String name, String qtyType) {
        this.name = name;
        this.qtyType = qtyType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQtyType() {
        return qtyType;
    }

    public void setQtyType(String qtyType) {
        this.qtyType = qtyType;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }
}

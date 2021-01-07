package com.cookies.cookbook.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Recipe extends BaseRecipe {
    @SerializedName("ingredients")
    private List<Ingredient> ingredients;

    @SerializedName("steps")
    private List<Step> steps;

    public Recipe(int id, String name, List<Category> categories,
                  List<Ingredient> ingredients, List<Step> steps) {
        super(id, name, categories);
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public Recipe() {

    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}

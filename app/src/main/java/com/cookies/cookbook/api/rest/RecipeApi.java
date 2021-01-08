package com.cookies.cookbook.api.rest;

import com.cookies.cookbook.api.model.BaseRecipe;
import com.cookies.cookbook.api.model.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RecipeApi {
    @GET("/recipes/get-all")
    Call<List<BaseRecipe>> getAll();

    @POST("/recipes/add-recipe")
    Call<Recipe> addRecipe(@Body Recipe recipe);

    @GET("/recipes/get-base-by-categories-and-products")
    Call<List<BaseRecipe>> getBaseRecipesByCategoriesAndProducts(@Query("categoryIds") List<Integer> categoryIds,
                                                                 @Query("productIds") List<Integer> productIds);

    @GET("/recipes/get-by-id")
    Call<Recipe> getById(@Query("id") int id);
}

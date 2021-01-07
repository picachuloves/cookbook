package com.cookies.cookbook.api.rest;

import com.cookies.cookbook.api.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryApi {
    @GET("/categories/get-all")
    Call<List<Category>> getAll();
}

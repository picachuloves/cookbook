package com.cookies.cookbook.api.rest;

import com.cookies.cookbook.api.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ProductApi {
    @GET("/products/get-all")
    Call<List<Product>> getAll();

    @POST("/products/add")
    Call<Product> addProduct(@Body Product product);

    @GET("/products/get-by-name-part")
    Call<Product> getProductsByNamePart(@Query("namePart") String namePart);
}

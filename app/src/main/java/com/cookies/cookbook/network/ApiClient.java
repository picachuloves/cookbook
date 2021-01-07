package com.cookies.cookbook.network;

import com.cookies.cookbook.api.rest.CategoryApi;
import com.cookies.cookbook.api.rest.MeasureApi;
import com.cookies.cookbook.api.rest.ProductApi;
import com.cookies.cookbook.api.rest.RecipeApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static ApiClient apiClient;
    private Retrofit retrofit;
    private static final String BASE_URL = "http://10.0.2.2:10000/";

    private ApiClient() {
        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiClient getInstance() {
        if (apiClient == null) {
            apiClient = new ApiClient();
        }
        return apiClient;
    }

    public CategoryApi getCategoryJsonApi() {
        return retrofit.create(CategoryApi.class);
    }

    public MeasureApi getMeasureJsonApi() {
        return retrofit.create(MeasureApi.class);
    }

    public ProductApi getProductJsonApi() {
        return retrofit.create(ProductApi.class);
    }

    public RecipeApi getRecipeJsonApi() {
        return retrofit.create(RecipeApi.class);
    }
}

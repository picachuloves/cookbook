package com.cookies.cookbook.api.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MeasureApi {
    @GET("/measure/get-all")
    Call<List<String>> getAll();
}

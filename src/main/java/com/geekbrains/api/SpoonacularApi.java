package com.geekbrains.api;

import com.geekbrains.spoonaccular.model.AutoCompleteProductResponse;
import com.geekbrains.spoonaccular.model.SearchGroceryProductsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SpoonacularApi {

    @GET("food/products/search")
    Call<SearchGroceryProductsResponse> findAllProducts(
            @Query("apiKey") String apiKey,
            @Query("query") String query,
            @Query("minCalories") Long minCalories,
            @Query("maxCalories") Long maxCalories,
            @Query("minCarbs") Long minCarbs,
            @Query("maxCarbs") Long maxCarbs,
            @Query("minProtein") Long minProtein,
            @Query("maxProtein") Long maxProtein,
            @Query("minFat") Long minFat,
            @Query("maxFat") Long maxFat,
            @Query("offset") Long offset,
            @Query("number") Long number
    );

    @GET("food/products/suggest")
    Call<AutoCompleteProductResponse> autocomplete(
            @Query("apiKey") String apiKey,
            @Query("query") String query,
            @Query("number") Long number
    );

}
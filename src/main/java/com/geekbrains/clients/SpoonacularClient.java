package com.geekbrains.clients;

import com.geekbrains.api.ResponseUtils;
import com.geekbrains.api.SpoonacularApi;
import com.geekbrains.spoonaccular.model.AutoCompleteProductResponse;
import com.geekbrains.spoonaccular.model.SearchGroceryProductsRequest;
import com.geekbrains.spoonaccular.model.SearchGroceryProductsResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SpoonacularClient {

    private static final String API_URL = "https://api.spoonacular.com/";
    private static final String API_KEY = "0970f5c615f14a2a91942df5a213e41c";

    private SpoonacularApi api;

    public SpoonacularClient() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(1000, TimeUnit.MILLISECONDS)
                .readTimeout(1000, TimeUnit.MILLISECONDS)
                .writeTimeout(1000, TimeUnit.MILLISECONDS)
                .callTimeout(Duration.ofSeconds(1))
                .addInterceptor(loggingInterceptor)
                .build();



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        this.api = retrofit.create(SpoonacularApi.class);
    }

    public SearchGroceryProductsResponse findAllProducts(
            SearchGroceryProductsRequest request
    ) {
        Call<SearchGroceryProductsResponse> responseCall = api.findAllProducts(
                API_KEY,
                request.getQuery(),
                request.getMinCalories(),
                request.getMaxCalories(),
                request.getMinCarbs(),
                request.getMaxCarbs(),
                request.getMinProtein(),
                request.getMaxProtein(),
                request.getMinFat(),
                request.getMaxFat(),
                request.getOffset(),
                request.getNumber()
        );
        return ResponseUtils.executeCall(responseCall);
    }

    public AutoCompleteProductResponse autocomplete(
            String query,
            Long number
    ) {
        Call<AutoCompleteProductResponse> responseCall = api.autocomplete(API_KEY, query, number);
        return ResponseUtils.executeCall(responseCall);
    }


}
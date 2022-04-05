package com.geekbrains;

import com.geekbrains.clients.SpoonacularClient;
import com.geekbrains.spoonaccular.model.AutoCompleteProductResponse;
import com.geekbrains.spoonaccular.model.ProductView;
import com.geekbrains.spoonaccular.model.SearchGroceryProductsRequest;
import com.geekbrains.spoonaccular.model.SearchGroceryProductsResponse;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        SpoonacularClient client = new SpoonacularClient();

        AutoCompleteProductResponse pasta = client.autocomplete("pasta", 3L);

        System.out.println(pasta);

        SearchGroceryProductsResponse products = client.findAllProducts(
                SearchGroceryProductsRequest.builder()
                        .query("pasta")
                        .minCalories(10L)
                        .maxCalories(1000L)
                        .number(3L)
                        .build()
        );

        products.getProducts().forEach(System.out::println);
    }
}
package com.geekbrains.spoonaccular.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AutoCompleteProductResponse {

    private List<ProductViewLight> results;

}
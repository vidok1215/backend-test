package com.geekbrains.spoonaccular.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutoCompleteRecipeItem {

    private Long id;

    private String title;

    private String imageType;

}
package com.geekbrains.spoonaccular.model;

import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@ToString
public class RecipesSearchResponse implements Serializable {

    private List<RecipesSearchResponseItem> results;
    private Integer offset;
    private Integer number;
    private Integer totalResults;

    public RecipesSearchResponse() {
    }

    public List<RecipesSearchResponseItem> getResults() {
        return results;
    }

    public void setResults(List<RecipesSearchResponseItem> results) {
        this.results = results;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }
}
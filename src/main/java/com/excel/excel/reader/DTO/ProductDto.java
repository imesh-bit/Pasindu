package com.excel.excel.reader.DTO;

import javax.persistence.Column;

public class ProductDto {
    private Long id;
    private String pnumber;
    private String ingredients;


    public ProductDto() {
    }

    public ProductDto(Long id, String pnumber, String ingredients) {
        this.id = id;
        this.pnumber = pnumber;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", pnumber='" + pnumber + '\'' +
                ", ingredients='" + ingredients + '\'' +
                '}';
    }
}

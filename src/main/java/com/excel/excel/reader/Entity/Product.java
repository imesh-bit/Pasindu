package com.excel.excel.reader.Entity;

import javax.persistence.*;

@Entity

public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",length = 255)
    private Long id;

    @Id
    @Column(name ="pnumber")
    private String pnumber;

    @Column(name ="ingredients")
    private String ingredients;

    public Product() {
    }

    public Product(Long id, String pnumber, String ingredients) {
        this.id = id;
        this.pnumber = pnumber;
        this.ingredients = ingredients;
    }

    public Product(String pnumber, String ingredients) {
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
}

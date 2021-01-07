package com.cookies.cookbook.api.model;

import com.google.gson.annotations.SerializedName;

public class Ingredient {
    @SerializedName("id")
    private int id;

    @SerializedName("amount")
    private int amount;

    @SerializedName("measure")
    private String measure;

    @SerializedName("productDto")
    private Product product;

    public Ingredient(int id, int amount, String measure, Product product) {
        this.id = id;
        this.amount = amount;
        this.measure = measure;
        this.product = product;
    }

    public Ingredient() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

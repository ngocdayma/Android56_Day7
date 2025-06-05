package com.example.android56_day7.models;


public class Product {
    private String name;
    private String description;
    private String price;
    private String imageProduct;

    public Product(String name, String description, String price, String imageProduct) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageProduct = imageProduct;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }
}

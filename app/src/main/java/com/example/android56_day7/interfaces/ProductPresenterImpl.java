package com.example.android56_day7.interfaces;

public interface ProductPresenterImpl {
    void getAllProduct();

    void getAllProduct(int limit);

    void getProductById(int id);

    void searchProduct(String productName);

    void getAllCategory();
}

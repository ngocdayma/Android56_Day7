package com.example.android56_day7.interfaces;

import com.example.android56_day7.models.Product;

import java.util.List;

public interface ProductViewImpl {
    void showLoading();

    void hideLoading();

    void showProducts(List<Product> products);

    void showProduct(Product product);

    void showCategories(List<String> categories);

    void showError(String message);

}

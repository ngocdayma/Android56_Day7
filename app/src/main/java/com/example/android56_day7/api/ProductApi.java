package com.example.android56_day7.api;

import com.example.android56_day7.constains.ConstantApi;
import com.example.android56_day7.models.AllProductResponse;
import com.example.android56_day7.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductApi {
    @GET(ConstantApi.GET_ALL_PRODUCTS)
    Call<AllProductResponse> getAllProducts();

    @GET(ConstantApi.GET_ALL_PRODUCTS)
    Call<AllProductResponse> getLimitProduct(@Query("limit") int limit);

    @GET(ConstantApi.GET_SINGLE_PRODUCT)
    Call<Product> getProductById(@Path("id") int id);

    @GET(ConstantApi.GET_ALL_CATEGORIES)
    Call<List<String>> getAllCategories();

    @GET(ConstantApi.SEARCH_PRODUCTS)
    Call<AllProductResponse> searchProducts(@Query("q") String prodcutName);
}

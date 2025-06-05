package com.example.android56_day7.api;

import com.example.android56_day7.constains.ConstantApi;
import com.example.android56_day7.models.AllProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductApi {
    @GET(ConstantApi.GET_ALL_PRODUCTS)
    Call<AllProductResponse> getAllProducts();

    @GET(ConstantApi.SEARCH_PRODUCTS)
    Call<AllProductResponse> searchProducts(@Query("q") String prodcutName);
}

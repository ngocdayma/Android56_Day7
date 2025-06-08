package com.example.android56_day7.Retrofit;

import com.example.android56_day7.api.ProductApi;
import com.example.android56_day7.constants.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit instance;

    public static Retrofit getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return instance;
    }

    public static ProductApi getProductApi() {
        return getInstance().create(ProductApi.class);
    }
}


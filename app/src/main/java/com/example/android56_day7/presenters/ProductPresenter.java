package com.example.android56_day7.presenters;

import com.example.android56_day7.Retrofit.RetrofitClient;
import com.example.android56_day7.api.ProductApi;
import com.example.android56_day7.interfaces.ProductPresenterImpl;
import com.example.android56_day7.interfaces.ProductViewImpl;
import com.example.android56_day7.models.AllProductResponse;
import com.example.android56_day7.models.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductPresenter implements ProductPresenterImpl {

    private ProductViewImpl mProductView;
    private ProductApi mProductApi;

    public ProductPresenter(ProductViewImpl productView) {
        this.mProductView = productView;
        if (mProductApi == null) {
            mProductApi = RetrofitClient.getProductApi();
        }
    }

    @Override
    public void getAllProduct() {
        mProductView.showLoading();
        mProductApi.getAllProducts().enqueue(new Callback<AllProductResponse>() {
            @Override
            public void onResponse(Call<AllProductResponse> call, Response<AllProductResponse> response) {
                mProductView.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    mProductView.showProducts(response.body().getProducts());
                } else {
                    mProductView.showError("Không có sản phẩm nào.");
                }
            }

            @Override
            public void onFailure(Call<AllProductResponse> call, Throwable t) {
                mProductView.hideLoading();
                mProductView.showError("Lỗi: " + t.getMessage());
            }
        });
    }

    @Override
    public void getAllProduct(int limit) {
//        mProductView.showLoading();
//        mProductApi.getLimitProduct(limit).enqueue(new Callback<AllProductResponse>() {
//            @Override
//            public void onResponse(Call<AllProductResponse> call, Response<AllProductResponse> response) {
//                mProductView.hideLoading();
//                if (response.isSuccessful() && response.body() != null) {
//                    mProductView.showProducts(response.body().getProducts());
//                } else {
//                    mProductView.showError("Không có sản phẩm nào.");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<AllProductResponse> call, Throwable t) {
//                mProductView.hideLoading();
//                mProductView.showError("Lỗi: " + t.getMessage());
//            }
//        });
    }

    @Override
    public void getProductById(int id) {
//        mProductView.showLoading();
//        mProductApi.getProductById(id).enqueue(new Callback<Product>() {
//            @Override
//            public void onResponse(Call<Product> call, Response<Product> response) {
//                mProductView.hideLoading();
//                if (response.isSuccessful() && response.body() != null) {
//                    mProductView.showProduct(response.body());
//                } else {
//                    mProductView.showError("Không tìm thấy sản phẩm.");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Product> call, Throwable t) {
//                mProductView.hideLoading();
//                mProductView.showError("Lỗi: " + t.getMessage());
//            }
//        });
    }

    @Override
    public void searchProduct(String productName) {
        mProductView.showLoading();
        mProductApi.searchProducts(productName).enqueue(new Callback<AllProductResponse>() {
            @Override
            public void onResponse(Call<AllProductResponse> call, Response<AllProductResponse> response) {
                mProductView.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    List<Product> allResults = response.body().getProducts();
                    List<Product> filteredByTitle = new ArrayList<>();

                    for (Product p : allResults) {
                        if (p.getTitle().toLowerCase().contains(productName.toLowerCase())) {
                            filteredByTitle.add(p);
                        }
                    }

                    mProductView.showProducts(filteredByTitle);
                } else {
                    mProductView.showError("Không tìm thấy sản phẩm phù hợp.");
                }
            }

            @Override
            public void onFailure(Call<AllProductResponse> call, Throwable t) {
                mProductView.hideLoading();
                mProductView.showError("Lỗi: " + t.getMessage());
            }
        });
    }

    @Override
    public void getAllCategory() {
//        mProductView.showLoading();
//        mProductApi.getAllCategories().enqueue(new Callback<List<String>>() {
//            @Override
//            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
//                mProductView.hideLoading();
//                if (response.isSuccessful() && response.body() != null) {
//                    mProductView.showCategories(response.body());
//                } else {
//                    mProductView.showError("Không có danh mục nào.");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<String>> call, Throwable t) {
//                mProductView.hideLoading();
//                mProductView.showError("Lỗi: " + t.getMessage());
//            }
//        });
    }
}

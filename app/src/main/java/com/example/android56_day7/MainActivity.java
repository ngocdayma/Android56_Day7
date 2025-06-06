package com.example.android56_day7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.android56_day7.Retrofit.RetrofitClient;
import com.example.android56_day7.adapters.ProductAdapter;
import com.example.android56_day7.api.ProductApi;
import com.example.android56_day7.interfaces.ProductClickListener;
import com.example.android56_day7.models.AllProductResponse;
import com.example.android56_day7.models.Product;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private RecyclerView reDemo;
    private ProductAdapter mProductAdapter;
    private List<Product> fullProductList = new ArrayList<>();

    private EditText edtSearch;
    private Button btnSearch;
    private ProductApi productApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        reDemo = findViewById(R.id.reDemo);
        edtSearch = findViewById(R.id.edtSearch);
        btnSearch = findViewById(R.id.btnSearch);

        productApi = RetrofitClient.getProductApi();

        reDemo.setLayoutManager(new GridLayoutManager(this, 2));

        productApi.getAllProducts().enqueue(new Callback<AllProductResponse>() {
            @Override
            public void onResponse(Call<AllProductResponse> call, Response<AllProductResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    fullProductList = response.body().getProducts();

                    List<Product> topProducts = fullProductList.subList(0, Math.min(10, fullProductList.size()));
                    mProductAdapter = new ProductAdapter(new ArrayList<>(topProducts));
                    reDemo.setAdapter(mProductAdapter);

                    mProductAdapter.setProductClickListener(new ProductClickListener() {
                        @Override
                        public void onItemClickListener(int position, Product product) {
                            Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
                            intent.putExtra("name", product.getTitle());
                            intent.putExtra("description", product.getDescription());
                            intent.putExtra("price", product.getPrice().toString());
                            intent.putExtra("image", product.getThumbnail());
                            startActivity(intent);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<AllProductResponse> call, Throwable t) {
                Log.e(TAG, "API failed: " + t.getMessage());
            }
        });

        btnSearch.setOnClickListener(v -> {
            String keyword = edtSearch.getText().toString().trim().toLowerCase();
            List<Product> filteredList = new ArrayList<>();

            for (Product p : fullProductList) {
                if (p.getTitle().toLowerCase().contains(keyword)) {
                    filteredList.add(p);
                }
            }

            mProductAdapter.updateData(filteredList);
        });
    }
}
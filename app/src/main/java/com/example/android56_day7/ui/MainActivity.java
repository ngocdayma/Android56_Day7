package com.example.android56_day7.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.android56_day7.R;
import com.example.android56_day7.adapters.ProductAdapter;
import com.example.android56_day7.interfaces.ProductViewImpl;
import com.example.android56_day7.models.Product;
import com.example.android56_day7.presenters.ProductPresenter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements ProductViewImpl {

    private static final String TAG = "MainActivity";

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private ProductPresenter mProductPresenter;
    private EditText edtSearch;
    private Button btnSearch;
    private List<Product> fullProductList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    public void initView() {
        recyclerView = findViewById(R.id.reDemo);
        edtSearch = findViewById(R.id.edtSearch);
        btnSearch = findViewById(R.id.btnSearch);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mProductPresenter = new ProductPresenter(this);
        mProductPresenter.getAllProduct();

        btnSearch.setOnClickListener(v -> {
            String keyword = edtSearch.getText().toString().trim();
            if (!keyword.isEmpty()) {
                mProductPresenter.searchProduct(keyword);
            } else {
                mProductPresenter.getAllProduct();
            }
        });
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showProducts(List<Product> products) {
        fullProductList = products;
        productAdapter = new ProductAdapter(new ArrayList<>(products));
        recyclerView.setAdapter(productAdapter);

        productAdapter.setProductClickListener((position, product) -> {
            Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
            intent.putExtra("name", product.getTitle());
            intent.putExtra("description", product.getDescription());
            intent.putExtra("price", product.getPrice().toString());
            intent.putExtra("image", product.getThumbnail());
            startActivity(intent);
        });
    }

    @Override
    public void showProduct(Product product) {
    }

    @Override
    public void showCategories(List<String> categories) {
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
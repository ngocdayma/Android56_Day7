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


import com.example.android56_day7.adapters.ProductAdapter;
import com.example.android56_day7.interfaces.ProductClickListener;
import com.example.android56_day7.models.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private RecyclerView reDemo;
    private ArrayList<Product> mListProduct;

    private ProductAdapter mProductAdapter;

    private EditText edtPosition;
    private Button btnAdd;
    private Button btnRemove;
    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initView() {
        reDemo = findViewById(R.id.reDemo);
        edtPosition = findViewById(R.id.edtPosition);
        btnAdd = findViewById(R.id.btnAdd);
        btnRemove = findViewById(R.id.btnRemove);
        btnUpdate = findViewById(R.id.btnUpdate);

        mProductAdapter = new ProductAdapter(mListProduct);

        RecyclerView recyclerView = findViewById(R.id.reDemo);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        reDemo.setAdapter(mProductAdapter);

        mProductAdapter.setProductClickListener(new ProductClickListener() {
            @Override
            public void onItemClickListener(int position, Product product) {
                Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
                intent.putExtra("name", product.getName());
                intent.putExtra("description", product.getDescription());
                intent.putExtra("price", product.getPrice());
                intent.putExtra("image", product.getImageProduct());
                startActivity(intent);
                Log.d(TAG, "onItemClickListener: " + position);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String positionStr = edtPosition.getText().toString().trim();
                try {
                    int position = Integer.parseInt(positionStr);
                    if (isValidPosition(position)) {
                        addProduct(position);
                    } else {
                        Toast.makeText(getApplicationContext(), "Vị trí không hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập một số nguyên hợp lệ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String positionStr = edtPosition.getText().toString().trim();
                try {
                    int position = Integer.parseInt(positionStr);
                    if (isValidPosition(position)) {
                        addProduct(position);
                    } else {
                        Toast.makeText(getApplicationContext(), "Vị trí không hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập một số nguyên hợp lệ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnUpdate.setOnClickListener(view -> {
            String positionStr = edtPosition.getText().toString().trim();
            try {
                int position = Integer.parseInt(positionStr);
                if (isValidPosition(position)) {
                    addProduct(position);
                } else {
                    Toast.makeText(getApplicationContext(), "Vị trí không hợp lệ", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Vui lòng nhập một số nguyên hợp lệ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateProduct(int position) {
        Product product = mListProduct.get(position);
        String newProductName = product.getName() + "Update";
        product.setName(newProductName);
        mListProduct.set(position, product);
        mProductAdapter.notifyItemChanged(position);
    }

    private void removeProduct(int position) {
        mListProduct.remove(position);
        mProductAdapter.notifyItemRemoved(position);
    }

    private void addProduct(int position) {
        Product product = new Product();
        product.setName("Product " + position);
        product.setDescription("Description " + position);
        product.setPrice("₹999");
        product.setImageProduct("data:image/jpeg;base64,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");

        mListProduct.add(position, product);
        mProductAdapter.notifyItemInserted(position);
    }

    private boolean isValidPosition(int position) {
        return position >= 0 && position < mListProduct.size();
    }

    private void initData() {
        mListProduct = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setName("Product " + i);
            product.setDescription("Description " + i);
            product.setPrice("₹999");
            product.setImageProduct("data:image/jpeg;base64,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");
            mListProduct.add(product);
        }
    }


}
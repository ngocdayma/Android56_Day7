package com.example.android56_day7.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.android56_day7.R;
import com.example.android56_day7.databases.CartDatabaseHelper;
import com.example.android56_day7.interfaces.db_product_listener.InsertProductListener;
import com.example.android56_day7.models.Product;

import android.widget.Button;
import android.widget.Toast;


public class ProductDetailActivity extends AppCompatActivity {

    private ImageView imgProduct;
    private TextView txtName, txtDescription, txtPrice;
    private Button btnAddToCart;

    private CartDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgProduct = findViewById(R.id.imgProduct);
        txtName = findViewById(R.id.txtName);
        txtDescription = findViewById(R.id.txtDescription);
        txtPrice = findViewById(R.id.txtPrice);
        btnAddToCart = findViewById(R.id.btnAddToCart);

        db = new CartDatabaseHelper(this);

        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        String price = getIntent().getStringExtra("price");
        String imageUrl = getIntent().getStringExtra("image");

        txtName.setText(name);
        txtDescription.setText(description);
        txtPrice.setText(price);
        Glide.with(this).load(imageUrl).into(imgProduct);

        btnAddToCart.setOnClickListener(v -> {
            Product product = new Product();
            product.setTitle(name);
            product.setDescription(description);
            product.setPrice(Double.parseDouble(price));
            product.setThumbnail(imageUrl);

            CartDatabaseHelper db = new CartDatabaseHelper(this);
            db.insertProduct(product, new InsertProductListener() {
                @Override
                public void onInsertSuccess() {
                    Toast.makeText(ProductDetailActivity.this, "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onInsertFail(String error) {
                    Toast.makeText(ProductDetailActivity.this, "Thêm thất bại: " + error, Toast.LENGTH_SHORT).show();
                }
            });
        });

    }
}


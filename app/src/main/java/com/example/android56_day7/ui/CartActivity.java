package com.example.android56_day7.ui;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android56_day7.R;
import com.example.android56_day7.adapters.CartAdapter;
import com.example.android56_day7.models.CartItem;
import com.example.android56_day7.models.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private ListView lvCartItems;
    private TextView txtTotalPrice;
    private Button btnBuyNow;
    private CartAdapter cartAdapter;
    private List<CartItem> cartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        lvCartItems = findViewById(R.id.lvCartItems);
        txtTotalPrice = findViewById(R.id.txtTotalPrice);
        btnBuyNow = findViewById(R.id.btnBuyNow);

        Product p1 = new Product();
        p1.setTitle("Adidas Runner");
        p1.setPrice(59.99);
        p1.setThumbnail("https://via.placeholder.com/150");

        Product p2 = new Product();
        p2.setTitle("Puma Black Bag");
        p2.setPrice(32.00);
        p2.setThumbnail("https://via.placeholder.com/150");

        cartList = new ArrayList<>(Arrays.asList(
                new CartItem(p1, 1),
                new CartItem(p2, 2)
        ));

        cartAdapter = new CartAdapter(this, cartList, this::updateTotalPrice);
        lvCartItems.setAdapter(cartAdapter);

        updateTotalPrice();

        btnBuyNow.setOnClickListener(v -> {
            Toast.makeText(this, "Bạn đã đặt hàng thành công!", Toast.LENGTH_SHORT).show();
        });
    }

    private void updateTotalPrice() {
        double total = cartAdapter.calculateTotal();
        txtTotalPrice.setText(String.format("Tổng: $%.2f", total));
    }
}

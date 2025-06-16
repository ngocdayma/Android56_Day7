package com.example.android56_day7.ui;

import android.os.Bundle;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android56_day7.R;
import com.example.android56_day7.adapters.CartAdapter;
import com.example.android56_day7.databases.CartDatabaseHelper;
import com.example.android56_day7.models.CartItem;
import com.example.android56_day7.models.Product;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView rvCartItems;
    private TextView txtTotalPrice;
    private Button btnBuyNow;
    private CartAdapter cartAdapter;
    private List<CartItem> cartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        rvCartItems = findViewById(R.id.rvCartItems);
        txtTotalPrice = findViewById(R.id.txtTotalPrice);
        btnBuyNow = findViewById(R.id.btnBuyNow);

        // Lấy từ SQLite
        CartDatabaseHelper db = new CartDatabaseHelper(this);
        List<Product> products = db.getAllProductFromLocal();

        cartList = new ArrayList<>();
        for (Product p : products) {
            cartList.add(new CartItem(p, 1));
        }

        cartAdapter = new CartAdapter(this, cartList, this::updateTotalPrice);
        rvCartItems.setLayoutManager(new LinearLayoutManager(this));
        rvCartItems.setAdapter(cartAdapter);

        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView,
                                  @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int pos = viewHolder.getAdapterPosition();
                cartAdapter.removeItem(pos);
                Toast.makeText(CartActivity.this, "Đã xóa sản phẩm", Toast.LENGTH_SHORT).show();
            }
        };

        new ItemTouchHelper(callback).attachToRecyclerView(rvCartItems);

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

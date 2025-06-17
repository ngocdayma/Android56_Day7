package com.example.android56_day7.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android56_day7.R;
import com.example.android56_day7.adapters.CartAdapter;
import com.example.android56_day7.databases.CartDatabaseHelper;
import com.example.android56_day7.models.CartItem;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private RecyclerView rvCartItems;
    private TextView txtTotalPrice;
    private Button btnBuyNow;
    private CartAdapter cartAdapter;
    private CartDatabaseHelper dbHelper;
    private ArrayList<CartItem> cartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        rvCartItems = findViewById(R.id.rvCartItems);
        txtTotalPrice = findViewById(R.id.txtTotalPrice);
        btnBuyNow = findViewById(R.id.btnBuyNow);
        dbHelper = new CartDatabaseHelper(this);

        cartList = dbHelper.getAllCartItemsFromLocal();

        cartAdapter = new CartAdapter(this, cartList, this::updateTotalPrice, dbHelper);
        rvCartItems.setLayoutManager(new LinearLayoutManager(this));
        rvCartItems.setAdapter(cartAdapter);

        ItemTouchHelper.SimpleCallback swipeToDelete = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
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
        new ItemTouchHelper(swipeToDelete).attachToRecyclerView(rvCartItems);

        btnBuyNow.setOnClickListener(v -> {
            if (cartAdapter.getItemCount() == 0) {
                Toast.makeText(this, "Giỏ hàng trống!", Toast.LENGTH_SHORT).show();
                return;
            }

            dbHelper.clearCart();
            cartList.clear();
            cartAdapter.notifyDataSetChanged();
            updateTotalPrice();

            Toast.makeText(this, "Bạn đã đặt hàng thành công!", Toast.LENGTH_SHORT).show();
        });

        updateTotalPrice();
    }

    private void updateTotalPrice() {
        double total = cartAdapter.calculateTotal();
        txtTotalPrice.setText(String.format("Tổng: $%.2f", total));
    }
}

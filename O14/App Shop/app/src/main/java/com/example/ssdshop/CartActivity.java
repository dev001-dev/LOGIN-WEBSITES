package com.example.ssdshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    private ListView cartListView;
    private TextView totalPrice;
    private Button checkoutButton;
    private Button backButton;
    private Cart cart;
    private CartItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartListView = findViewById(R.id.cartListView);
        totalPrice = findViewById(R.id.totalPrice);
        checkoutButton = findViewById(R.id.checkoutButton);
        backButton = findViewById(R.id.backButton);

        cart = new Cart();
        List<CartItem> items = cart.getItems();
        
        adapter = new CartItemAdapter(this, items, cart);
        cartListView.setAdapter(adapter);

        updateTotal();

        cartListView.setOnItemClickListener((parent, view, position, id) -> {
            // Item clicked, can be used for editing quantity
        });

        checkoutButton.setOnClickListener(v -> {
            if (cart.getItems().size() > 0) {
                Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
                intent.putExtra("total", cart.getTotal());
                startActivity(intent);
            } else {
                android.widget.Toast.makeText(CartActivity.this, "Cart is empty", android.widget.Toast.LENGTH_SHORT).show();
            }
        });

        backButton.setOnClickListener(v -> finish());
    }

    private void updateTotal() {
        totalPrice.setText("Total: ₹" + String.format("%.2f", cart.getTotal()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
        updateTotal();
    }
}

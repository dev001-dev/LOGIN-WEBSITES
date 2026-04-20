package com.example.ssdshop;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {
    private TextView productName, productPrice, productDescription;
    private EditText quantityInput;
    private Button addToCartBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        productName = findViewById(R.id.detailProductName);
        productPrice = findViewById(R.id.detailProductPrice);
        productDescription = findViewById(R.id.detailProductDescription);
        quantityInput = findViewById(R.id.quantityInput);
        addToCartBtn = findViewById(R.id.detailAddToCartBtn);
        backBtn = findViewById(R.id.detailBackBtn);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString("product_name");
            double price = extras.getDouble("product_price");
            String description = extras.getString("product_description");

            productName.setText(name);
            productPrice.setText("₹" + String.format("%.2f", price));
            productDescription.setText(description);
        }

        addToCartBtn.setOnClickListener(v -> {
            String qty = quantityInput.getText().toString();
            if (!qty.isEmpty()) {
                int quantity = Integer.parseInt(qty);
                android.widget.Toast.makeText(ProductDetailActivity.this, 
                    quantity + " items added to cart", android.widget.Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        backBtn.setOnClickListener(v -> finish());
    }
}

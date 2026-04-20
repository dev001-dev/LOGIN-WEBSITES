package com.example.ssdshop;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CheckoutActivity extends AppCompatActivity {
    private TextView totalAmount;
    private EditText nameInput, emailInput, phoneInput, addressInput;
    private Button placeOrderBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        totalAmount = findViewById(R.id.totalAmount);
        nameInput = findViewById(R.id.nameInput);
        emailInput = findViewById(R.id.emailInput);
        phoneInput = findViewById(R.id.phoneInput);
        addressInput = findViewById(R.id.addressInput);
        placeOrderBtn = findViewById(R.id.placeOrderBtn);
        backBtn = findViewById(R.id.checkoutBackBtn);

        double total = getIntent().getDoubleExtra("total", 0);
        totalAmount.setText("Total: ₹" + String.format("%.2f", total));

        placeOrderBtn.setOnClickListener(v -> {
            String name = nameInput.getText().toString();
            String email = emailInput.getText().toString();
            String phone = phoneInput.getText().toString();
            String address = addressInput.getText().toString();

            if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !address.isEmpty()) {
                android.widget.Toast.makeText(CheckoutActivity.this, 
                    "Order placed successfully!", android.widget.Toast.LENGTH_SHORT).show();
                
                new Cart().clear();
                finish();
            } else {
                android.widget.Toast.makeText(CheckoutActivity.this, 
                    "Please fill all fields", android.widget.Toast.LENGTH_SHORT).show();
            }
        });

        backBtn.setOnClickListener(v -> finish());
    }
}

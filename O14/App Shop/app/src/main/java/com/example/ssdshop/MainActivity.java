package com.example.ssdshop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductAdapter.OnProductClickListener {
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<Product> products;
    private Cart cart;
    private Button cartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cart = new Cart();
        
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        cartButton = findViewById(R.id.cartButton);
        cartButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            intent.putExtra("cart_size", cart.getItems().size());
            startActivity(intent);
        });

        products = getSampleProducts();
        adapter = new ProductAdapter(products, this, this);
        recyclerView.setAdapter(adapter);
    }

    private List<Product> getSampleProducts() {
        List<Product> list = new ArrayList<>();
        
        list.add(new Product(1, "Samsung 970 EVO Plus", "Samsung", "500GB", 5999.99, 
                "NVMe M.2", 3500, "High performance NVMe SSD", 5, 15));
        list.add(new Product(2, "WD Blue SN570", "Western Digital", "1TB", 8999.99,
                "NVMe M.2", 3400, "Reliable and fast SSD", 5, 20));
        list.add(new Product(3, "Crucial P3 Plus", "Crucial", "2TB", 16999.99,
                "NVMe M.2", 5100, "Cost-effective with great speed", 4, 10));
        list.add(new Product(4, "Kingston A3000", "Kingston", "256GB", 2999.99,
                "NVMe M.2", 3000, "Budget-friendly SSD", 4, 25));
        list.add(new Product(5, "Sabrent Rocket", "Sabrent", "1TB", 7999.99,
                "NVMe M.2", 4950, "High-speed performance", 5, 12));
        list.add(new Product(6, "Intel 760p", "Intel", "512GB", 4999.99,
                "NVMe M.2", 3100, "Trusted Intel quality", 4, 8));
        list.add(new Product(7, "Samsung 860 EVO", "Samsung", "1TB", 6999.99,
                "SATA 2.5\"", 550, "Reliable SATA SSD", 4, 18));
        list.add(new Product(8, "Seagate Barracuda", "Seagate", "2TB", 14999.99,
                "SATA 2.5\"", 540, "High capacity SATA", 4, 5));
        
        return list;
    }

    @Override
    public void onProductClick(Product product) {
        Intent intent = new Intent(MainActivity.this, ProductDetailActivity.class);
        intent.putExtra("product_id", product.id);
        intent.putExtra("product_name", product.name);
        intent.putExtra("product_price", product.price);
        intent.putExtra("product_description", product.description);
        startActivity(intent);
    }

    @Override
    public void onAddToCart(Product product) {
        cart.addItem(new CartItem(product, 1));
        cartButton.setText("Cart (" + cart.getItems().size() + ")");
        // Show toast or notification
        android.widget.Toast.makeText(this, product.name + " added to cart", android.widget.Toast.LENGTH_SHORT).show();
    }
}

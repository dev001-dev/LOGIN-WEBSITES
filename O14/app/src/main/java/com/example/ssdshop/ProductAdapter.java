package com.example.ssdshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private List<Product> products;
    private Context context;
    private OnProductClickListener listener;

    public interface OnProductClickListener {
        void onProductClick(Product product);
        void onAddToCart(Product product);
    }

    public ProductAdapter(List<Product> products, Context context, OnProductClickListener listener) {
        this.products = products;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = products.get(position);
        holder.productName.setText(product.name);
        holder.productBrand.setText(product.brand);
        holder.productCapacity.setText(product.capacity);
        holder.productPrice.setText("₹" + String.format("%.2f", product.price));
        holder.productType.setText(product.type);
        holder.productSpeed.setText(product.speed + " Mbps");
        
        holder.itemView.setOnClickListener(v -> listener.onProductClick(product));
        holder.addToCartBtn.setOnClickListener(v -> listener.onAddToCart(product));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView productName, productBrand, productCapacity, productPrice, productType, productSpeed;
        Button addToCartBtn;

        public ProductViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.productName);
            productBrand = itemView.findViewById(R.id.productBrand);
            productCapacity = itemView.findViewById(R.id.productCapacity);
            productPrice = itemView.findViewById(R.id.productPrice);
            productType = itemView.findViewById(R.id.productType);
            productSpeed = itemView.findViewById(R.id.productSpeed);
            addToCartBtn = itemView.findViewById(R.id.addToCartBtn);
        }
    }
}

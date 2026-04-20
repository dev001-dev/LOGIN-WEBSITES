package com.example.ssdshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;

public class CartItemAdapter extends ArrayAdapter<CartItem> {
    private Context context;
    private List<CartItem> items;
    private Cart cart;

    public CartItemAdapter(Context context, List<CartItem> items, Cart cart) {
        super(context, 0, items);
        this.context = context;
        this.items = items;
        this.cart = cart;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        }

        CartItem cartItem = items.get(position);

        TextView productName = convertView.findViewById(R.id.cartProductName);
        TextView productPrice = convertView.findViewById(R.id.cartProductPrice);
        TextView quantity = convertView.findViewById(R.id.quantity);
        Button removeBtn = convertView.findViewById(R.id.removeBtn);

        productName.setText(cartItem.product.name);
        productPrice.setText("₹" + String.format("%.2f", cartItem.product.price));
        quantity.setText("Qty: " + cartItem.quantity);

        removeBtn.setOnClickListener(v -> {
            cart.removeItem(cartItem.product.id);
            items.remove(position);
            notifyDataSetChanged();
        });

        return convertView;
    }
}

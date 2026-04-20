package com.example.ssdshop;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static List<CartItem> items = new ArrayList<>();

    public void addItem(CartItem item) {
        // Check if product already exists in cart
        for (CartItem cartItem : items) {
            if (cartItem.product.id == item.product.id) {
                cartItem.quantity += item.quantity;
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(int productId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).product.id == productId) {
                items.remove(i);
                return;
            }
        }
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    public void clear() {
        items.clear();
    }
}

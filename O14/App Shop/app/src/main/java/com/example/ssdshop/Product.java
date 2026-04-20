package com.example.ssdshop;

public class Product {
    public int id;
    public String name;
    public String brand;
    public String capacity;
    public double price;
    public String type; // NVMe, SATA, M.2
    public double speed; // in Mbps
    public String description;
    public int rating;
    public int stock;

    public Product(int id, String name, String brand, String capacity, double price, 
                   String type, double speed, String description, int rating, int stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.capacity = capacity;
        this.price = price;
        this.type = type;
        this.speed = speed;
        this.description = description;
        this.rating = rating;
        this.stock = stock;
    }
}

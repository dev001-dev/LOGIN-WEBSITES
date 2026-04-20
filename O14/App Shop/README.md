# SSD Shop - Android Shopping Application

A complete Android shopping application for buying SSDs (Solid State Drives).

## Features
- Browse SSD products with detailed specifications
- View product details (capacity, speed, type)
- Add products to shopping cart
- Manage cart items (add/remove)
- Checkout with delivery information
- Multiple SSD types (NVMe, SATA, M.2)
- Sample products from popular brands (Samsung, WD, Crucial, Kingston, etc.)

## Project Structure
```
SSDShop/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/ssdshop/
│   │   │   ├── MainActivity.java
│   │   │   ├── ProductDetailActivity.java
│   │   │   ├── CartActivity.java
│   │   │   ├── CheckoutActivity.java
│   │   │   ├── Product.java
│   │   │   ├── CartItem.java
│   │   │   ├── Cart.java
│   │   │   ├── ProductAdapter.java
│   │   │   └── CartItemAdapter.java
│   │   ├── res/
│   │   │   ├── layout/ (XML layout files)
│   │   │   ├── values/ (colors, strings, themes)
│   │   │   └── drawable/ (drawable resources)
│   │   └── AndroidManifest.xml
│   └── build.gradle
├── build.gradle (root)
└── settings.gradle
```

## How to Build and Run

1. **Open in Android Studio**
   - File → Open → Select the SSDShop folder
   - Let Gradle sync complete

2. **Build the Project**
   - Build → Make Project (Ctrl+F9)

3. **Run on Emulator or Device**
   - Run → Run 'app' (Shift+F10)
   - Select emulator or connected device

## Key Activities

- **MainActivity**: Browse all SSD products in a RecyclerView
- **ProductDetailActivity**: View detailed specifications and add items to cart
- **CartActivity**: View cart items and proceed to checkout
- **CheckoutActivity**: Enter delivery information and place order

## Sample Products

The app includes 8 pre-loaded SSD products:
- Samsung 970 EVO Plus (500GB, ₹5,999.99)
- WD Blue SN570 (1TB, ₹8,999.99)
- Crucial P3 Plus (2TB, ₹16,999.99)
- Kingston A3000 (256GB, ₹2,999.99)
- Sabrent Rocket (1TB, ₹7,999.99)
- Intel 760p (512GB, ₹4,999.99)
- Samsung 860 EVO (1TB, ₹6,999.99)
- Seagate Barracuda (2TB, ₹14,999.99)

## Dependencies

- AndroidX AppCompat
- Material Components
- RecyclerView
- OkHttp3 (for networking)
- Gson (for JSON parsing)

## Future Enhancements

- Connect to real backend API
- User authentication and login
- Payment gateway integration
- Order history and tracking
- Product reviews and ratings
- Filter and search functionality
- Wishlist feature

package com.example.assignment2;

import android.util.Log;

import java.util.ArrayList;

public class StoreManager {
    ArrayList<Product> listOfProduct = new ArrayList<>();
   // ArrayList<HistoryProduct> historyArrayList = new ArrayList<>();
    private static final String TAG = "abc";
//
//    Product firstProduct = new Product("  Apple 🍎", 1.99, 400);
//    Product secondProduct = new Product("  Banana 🍌", .99, 700);
//    Product thirdProduct = new Product("   Milk  🥛", 8.99, 90);

    double total = 0;

    public StoreManager() {

        Product firstProduct = new Product("  Apple 🍎", 1.99, 400);
        Product secondProduct = new Product("  Banana 🍌", .99, 700);
        Product thirdProduct = new Product("   Milk  🥛", 8.99, 90);

        listOfProduct.add(firstProduct);
        listOfProduct.add(secondProduct);
        listOfProduct.add(thirdProduct);

    }

    public ArrayList<Product> getListOfProduct() {
        return listOfProduct;
    }

    public void setListOfProduct(ArrayList<Product> listOfProduct) {
        this.listOfProduct = listOfProduct;
    }
//Setter function for setting a variables(change) each time when the customer buy a product
//    public void setFirstProduct(Product firstProduct) {
//        this.firstProduct = firstProduct;
//        if (firstProduct.getQuantity() > 400) {
//            Log.d(TAG, "This quantity is not available in the store. Please enter a small quantity");
//        }
//    }
//
//    public void setSecondProduct(Product secondProduct) {
//        this.secondProduct = secondProduct;
//        if (firstProduct.getQuantity() > 700) {
//            Log.d(TAG, "This quantity is not available in the store. Please enter a small quantity");
//        }
//    }
//
//    public void setThirdProduct(Product thirdProduct) {
//        this.thirdProduct = thirdProduct;
//        if (thirdProduct.getQuantity() > 90) {
//            Log.d(TAG, "This quantity is not available in the store. Please enter a small quantity");
//        }
    }
//}
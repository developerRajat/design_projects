package com.vending.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    private static Map<Integer, Integer> inventorySnapshot = new HashMap<>();
    private static Map<Integer, Product> productMap = new HashMap<>();

    public static void deductInventory(Integer productId) {
        Integer inventoryCount = inventorySnapshot.get(productId);
        if (inventoryCount > 0) {
            inventorySnapshot.put(productId, inventoryCount-1);
        } else {
            System.out.println("Inventory is already 0");
        }
    }

    public static boolean hasInventory(Integer productId) {
        if(inventorySnapshot.get(productId) != null && inventorySnapshot.get(productId) > 0) {
            return true;
        }
        return false;
    }

    public static void addInventory(Integer productId) {
        Integer oldValue = inventorySnapshot.computeIfAbsent(productId, k -> {
            return 0;
        });
        inventorySnapshot.put(productId, oldValue + 1);
    }

    public static List<Product> getListOfAvailableProducts() {
        Product p1 = new Product(1, "COKE", 30L);
        Product p2 = new Product(2, "Kit Kat", 10L);
        Product p3 = new Product(3, "Bourbon", 25L);
        productMap.put(1, p1);
        productMap.put(2, p2);
        productMap.put(3, p3);
        List<Product> allProducts = new ArrayList<>();
        allProducts.add(p1);
        allProducts.add(p2);
        allProducts.add(p3);

        return allProducts;
    }

    public static Product getProductById(Integer productId) {
        return productMap.get(productId);
    }
}
package com.vending.services;

import com.vending.VendingMachine;
import com.vending.entity.Inventory;
import com.vending.entity.Pair;
import com.vending.entity.Product;
import com.vending.exception.ProductNotFoundException;

import java.util.List;

public class VendingMachineImpl implements VendingMachine {


    @Override
    public List<Product> getAllProducts() {
        return Inventory.getListOfAvailableProducts();
    }

    @Override
    public Pair<Product, Long> selectAndPay(Integer productId, long amount) throws ProductNotFoundException {
        if(Inventory.hasInventory(productId)) {
            Product product = Inventory.getProductById(productId);
            if(product != null) {
                long change = amount - product.getPrice();
                if(change < 0) {
                    throw new RuntimeException("Change cannot be negative");
                }
                Inventory.deductInventory(productId);
                return new Pair<>(product, change);
            } else {
                throw new ProductNotFoundException("Product not found");
            }
        } else {
            throw new RuntimeException("Inventory not found");
        }
    }

}
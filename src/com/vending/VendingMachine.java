package com.vending;

import com.vending.entity.Pair;
import com.vending.entity.Product;
import com.vending.exception.ProductNotFoundException;

import java.util.List;

public interface VendingMachine {

    List<Product> getAllProducts();
    Pair<Product, Long> selectAndPay(Integer productId, long amount) throws ProductNotFoundException;

}

package com.vending.entity;

public class Product {

    Integer productId;
    String name;
    Long price;

    public Product(Integer productId, String name, Long price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
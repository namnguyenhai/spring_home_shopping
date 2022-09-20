package com.example.spring_home_shopping.service;

import com.example.spring_home_shopping.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductSetvice {
    public Product addProduct(Product product);
    public List<Product> getAllProduct();
    public String deleteProduct(List<Integer> id);
    public String updateProduct(int id, Product product);
    public Optional<Product> findProduct(int id);
}

package com.example.spring_home_shopping.service;

import com.example.spring_home_shopping.model.Product;
import com.example.spring_home_shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductSetvice{
    @Autowired
    public ProductRepository productRepository;

    @Override
    public Product addProduct(Product product) {
        return  productRepository.save(product);

    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public String deleteProduct(List<Integer> id) {
        for (Integer i:id){
            productRepository.deleteById(i);
        }
        return "Delete selected rows";
    }

    @Override
    public String updateProduct(int id, Product product) {
        if (productRepository.existsById(id)==true){
            productRepository.save(product);
            return "Updated";
        }
        else {
            return "Invalid Id";
        }
    }

    @Override
    public Optional<Product> findProduct(int id) {
        return productRepository.findById(id);
    }
}

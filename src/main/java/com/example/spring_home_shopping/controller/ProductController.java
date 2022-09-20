package com.example.spring_home_shopping.controller;

import com.example.spring_home_shopping.model.Product;
import com.example.spring_home_shopping.service.ProductSetvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Autowired
    public ProductSetvice productService;

    @PostMapping("/add")
    public String add_Product(@RequestBody Product product){
        productService.addProduct(product);
        return "Product added";
    }

    @GetMapping("/getALlProduct")
    public List<Product> get_All_Product(){
        return  productService.getAllProduct();
    }

    @DeleteMapping("/deleteProduct/{id}")
    public String delete_Products(@PathVariable List<Integer> id){
        return  productService.deleteProduct(id);
    }


    @PutMapping("/updateProducts/{id}")
    public String update_Product(@PathVariable int id, @RequestBody Product product ){
        Product productFind = productService.findProduct(id).get();
        product.setProductId(id);
        if (product.getNameProduct()!=null){
            product.setNameProduct(product.getNameProduct());
        }
        else {
            product.setNameProduct(productFind.getNameProduct());
        }
        if (product.getQuantityOfProduct()!=null){
            product.setQuantityOfProduct(product.getQuantityOfProduct());
        }
        else {
            product.setQuantityOfProduct(productFind.getQuantityOfProduct());
        }
        if (product.getNameImageProduct()!=null){
            product.setNameImageProduct(product.getNameImageProduct());
        }
        else {
            product.setNameImageProduct(productFind.getNameImageProduct());
        }
        if (product.getPrice()!=null){
            product.setPrice(product.getPrice());
        }
        else {
            product.setPrice(productFind.getPrice());
        }
        return  productService.updateProduct(id,product);
    }
}

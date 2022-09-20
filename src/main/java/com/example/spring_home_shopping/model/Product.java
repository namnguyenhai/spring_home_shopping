package com.example.spring_home_shopping.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  int productId;
    private String nameProduct;
    private BigDecimal price;
    private Integer quantityOfProduct;
    private String nameImageProduct;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ShoppingCart> cart = new ArrayList<>();
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "order_detail",
        joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private Set<Order> order = new HashSet<>();
    public Product(int productId, String nameProduct, BigDecimal price, Integer quantityOfProduct, String nameImageProduct) {
        this.productId = productId;
        this.nameProduct = nameProduct;
        this.price = price;
        this.quantityOfProduct = quantityOfProduct;
        this.nameImageProduct = nameImageProduct;
    }

    public Product() {
    }

    public Integer getQuantityOfProduct() {
        return quantityOfProduct;
    }

    public void setQuantityOfProduct(Integer quantityOfProduct) {
        this.quantityOfProduct = quantityOfProduct;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getNameImageProduct() {
        return nameImageProduct;
    }

    public void setNameImageProduct(String nameImageProduct) {
        this.nameImageProduct = nameImageProduct;
    }
}

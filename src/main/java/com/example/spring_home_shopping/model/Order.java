package com.example.spring_home_shopping.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orderProducts")
public class Order {
    @Id
    @GeneratedValue
    private int id;

    @ManyToMany(mappedBy = "order")
    private Set<Product> products = new HashSet<>();
}

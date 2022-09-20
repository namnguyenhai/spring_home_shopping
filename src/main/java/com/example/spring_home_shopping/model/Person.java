package com.example.spring_home_shopping.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    private String userName;

    private String namePerson;
    private int phoneNumber;
    private String address;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    private List<ShoppingCart> cart = new ArrayList<>();
}

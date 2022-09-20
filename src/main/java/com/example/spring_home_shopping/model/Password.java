package com.example.spring_home_shopping.model;

import javax.persistence.*;

@Entity
public class Password {

    @Id
    private  String id;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Person person;
    private String passWord;
}

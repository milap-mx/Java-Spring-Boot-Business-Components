package com.example.Quiz2.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String province;
    private String country;

    @JsonBackReference
    @OneToOne(mappedBy = "address")
    private Person person;

}

package com.example.Quiz2.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private LocalDateTime localDateTime;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Person person;


}

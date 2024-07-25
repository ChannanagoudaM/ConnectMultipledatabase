package com.example.demo.EntityPackagePost;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fruits {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer fruitId;
    private String fruitName;
    private String fruitColor;
}

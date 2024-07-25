package com.example.demo.EntityPackageOracle;


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
public class Vegetables {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer vegetableId;
    private String vegetableName;
    private String vegetableColor;
}

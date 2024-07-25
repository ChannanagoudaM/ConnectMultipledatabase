package com.example.demo.OracleRepo;

import com.example.demo.EntityPackageOracle.Vegetables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VegetableRepo extends JpaRepository<Vegetables,Integer> {

}

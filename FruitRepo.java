package com.example.demo.PostRepo;

import com.example.demo.EntityPackagePost.Fruits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepo extends JpaRepository<Fruits,Integer> {

}

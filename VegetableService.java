package com.example.demo.ServicePackage;


import com.example.demo.EntityPackageOracle.Vegetables;
import com.example.demo.EntityPackagePost.Fruits;
import com.example.demo.OracleRepo.VegetableRepo;
import com.example.demo.PostRepo.FruitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VegetableService {


    @Autowired
    private VegetableRepo vegetableRepo;

    public Vegetables add(Vegetables vegetables)
    {
        return vegetableRepo.save(vegetables);
    }
}

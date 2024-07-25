package com.example.demo.ServicePackage;



import com.example.demo.EntityPackagePost.Fruits;
import com.example.demo.PostRepo.FruitRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FruitService {

    @Autowired
    private FruitRepo fruitRepo;

    public Fruits addFruit(Fruits fruits)
    {
        return fruitRepo.save(fruits);
    }
}

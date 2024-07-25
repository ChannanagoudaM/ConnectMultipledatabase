package com.example.demo.ControllerPackage;


import com.example.demo.EntityPackagePost.Fruits;
import com.example.demo.ServicePackage.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @PostMapping("/addfruits")
    public ResponseEntity<Fruits> addFruits(@RequestBody Fruits fruits)
    {
        return ResponseEntity.ok(fruitService.addFruit(fruits));
    }

}

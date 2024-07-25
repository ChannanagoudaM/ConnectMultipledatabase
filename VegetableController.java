package com.example.demo.ControllerPackage;

import com.example.demo.EntityPackageOracle.Vegetables;
import com.example.demo.ServicePackage.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vegetables")
public class VegetableController {

    @Autowired
    private VegetableService vegetableService;

    @PostMapping("/addvegetables")
    public ResponseEntity<Vegetables> addVegetables(@RequestBody Vegetables vegetables)
    {
        return ResponseEntity.ok(vegetableService.add(vegetables));
    }

}

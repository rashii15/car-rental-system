package edu.RL.carrental.controller;

import edu.RL.carrental.entity.CarEntity;
import edu.RL.carrental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public CarEntity addCar(@RequestBody CarEntity car) {
        return carService.saveCar(car);
    }

    @GetMapping("/all")
    public List<CarEntity> getAllCars() {
        return carService.getAllCars();
    }
}

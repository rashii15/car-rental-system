package edu.RL.carrental.service;

import edu.RL.carrental.entity.CarEntity;
import edu.RL.carrental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarRepository carRepository;

    @Override
    public CarEntity saveCar(CarEntity car) {
        return carRepository.save(car);
    }

    @Override
    public List<CarEntity> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<CarEntity> searchCars(String brand) {
        return carRepository.findByBrandContainingIgnoreCase(brand);
    }
}

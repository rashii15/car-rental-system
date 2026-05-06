package edu.RL.carrental.service;

import edu.RL.carrental.entity.CarEntity;

import java.util.List;

public interface CarService {
    CarEntity saveCar(CarEntity car);

    List<CarEntity> getAllCars();

    List<CarEntity> searchCars(String brand);

    CarEntity updateCar(Long id, CarEntity car);

    void deleteCar(Long id);
}

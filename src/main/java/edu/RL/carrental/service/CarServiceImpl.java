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

    @Override
    public CarEntity updateCar(Long id, CarEntity updatedCar) {
        CarEntity existingCar = carRepository.findById(id).orElse(null);

        if (existingCar != null) {
            existingCar.setBrand(updatedCar.getBrand());
            existingCar.setModel(updatedCar.getModel());
            existingCar.setType(updatedCar.getType());
            existingCar.setPricePerDay(updatedCar.getPricePerDay());
            existingCar.setStatus(updatedCar.getStatus());

            return carRepository.save(existingCar);
        }

        return null;
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}

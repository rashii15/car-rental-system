package edu.RL.carrental.repository;

import edu.RL.carrental.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity,Long> {
    List<CarEntity> findByBrandContainingIgnoreCase(String brand);
}

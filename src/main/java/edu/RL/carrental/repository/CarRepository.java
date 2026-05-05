package edu.RL.carrental.repository;

import edu.RL.carrental.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity,Long> {
}

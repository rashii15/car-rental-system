package edu.RL.carrental.repository;

import edu.RL.carrental.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity,Long> {
    List<BookingEntity> findByUserId(Long userId);
}

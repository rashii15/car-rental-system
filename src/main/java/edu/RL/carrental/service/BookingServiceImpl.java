package edu.RL.carrental.service;

import edu.RL.carrental.entity.BookingEntity;
import edu.RL.carrental.entity.CarEntity;
import edu.RL.carrental.repository.BookingRepository;
import edu.RL.carrental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public BookingEntity createBooking(BookingEntity booking) {

        CarEntity car = carRepository.findById(booking.getCarId()).orElse(null);
        if (car != null && car.getStatus().equals("AVAILABLE")) {
            car.setStatus("BOOKED");
            carRepository.save(car);
        }

        booking.setStatus("PENDING");
        return bookingRepository.save(booking);
    }
}

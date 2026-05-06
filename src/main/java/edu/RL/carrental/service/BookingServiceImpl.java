package edu.RL.carrental.service;

import edu.RL.carrental.entity.BookingEntity;
import edu.RL.carrental.entity.CarEntity;
import edu.RL.carrental.repository.BookingRepository;
import edu.RL.carrental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<BookingEntity> getBookingsByUser(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public BookingEntity updateBookingStatus(Long id, String status) {
        BookingEntity booking = bookingRepository.findById(id).orElse(null);

        if (booking != null) {
            CarEntity car = carRepository.findById(booking.getCarId()).orElse(null);

            if (car != null && status.equals("REJECTED")) {
                car.setStatus("AVAILABLE");
                carRepository.save(car);
            }
            return bookingRepository.save(booking);
        }

        return null;
    }
}

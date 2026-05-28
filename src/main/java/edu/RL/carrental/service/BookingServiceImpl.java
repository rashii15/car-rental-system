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

        CarEntity car = carRepository.findById(booking.getCar().getId()).orElse(null);
        if (car != null && car.getStatus().equals("AVAILABLE")) {
            car.setStatus("BOOKED");
            carRepository.save(car);
        }

        booking.setStatus("PENDING");
        booking.setPaymentStatus("PENDING");
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

            booking.setStatus(status);
            CarEntity car = carRepository.findById(booking.getCar().getId()).orElse(null);

            if (car != null && status.equals("REJECTED")) {
                car.setStatus("AVAILABLE");
                carRepository.save(car);
            }
            return bookingRepository.save(booking);
        }

        return null;
    }

    @Override
    public List<BookingEntity> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public BookingEntity updatePayment(Long id) {
        BookingEntity booking =
                bookingRepository.findById(id).orElse(null);

        if (booking != null) {

            booking.setPaymentStatus("PAID");

            return bookingRepository.save(booking);
        }

        return null;
    }

    @Override
    public BookingEntity getBookingById(Long id) {
        return bookingRepository
                .findById(id)
                .orElse(null);
    }
}

package edu.RL.carrental.service;

import edu.RL.carrental.entity.BookingEntity;

import java.util.List;

public interface BookingService {
    BookingEntity createBooking(BookingEntity booking);
    List<BookingEntity> getBookingsByUser(Long userId);
}

package edu.RL.carrental.controller;

import edu.RL.carrental.entity.BookingEntity;
import edu.RL.carrental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public BookingEntity createBooking(@RequestBody BookingEntity booking) {
        return bookingService.createBooking(booking);
    }

    @GetMapping("/user/{userId}")
    public List<BookingEntity> getUserBookings(@PathVariable Long userId) {
        return bookingService.getBookingsByUser(userId);
    }

    @PutMapping("/update-status/{id}")
    public BookingEntity updateStatus(@PathVariable Long id, @RequestParam String status) {
        return bookingService.updateBookingStatus(id, status);
    }

    @GetMapping("/all")
    public List<BookingEntity> getAllBookings() {
        return bookingService.getAllBookings();
    }
}

package edu.RL.carrental.controller;

import edu.RL.carrental.entity.BookingEntity;
import edu.RL.carrental.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}

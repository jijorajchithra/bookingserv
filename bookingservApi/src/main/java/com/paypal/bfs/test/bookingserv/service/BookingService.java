package com.paypal.bfs.test.bookingserv.service;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookingService {
    String addBooking(Booking booking);
    Booking getBooking(int id);
    List<Booking> getAllBookings(int offset, int limit);
}
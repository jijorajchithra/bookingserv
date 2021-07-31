package com.paypal.bfs.test.bookingserv.service;

import com.paypal.bfs.test.bookingserv.api.model.Booking;

import java.util.List;

public interface BookingService {
    String addBooking(Booking booking);
    Booking getBooking(String id);
    List<Booking> getAllBookings();
}
package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController

public class BookingResourceImpl implements BookingResource {

    @Autowired
    private BookingService bookingService;

    @Override
    public ResponseEntity<Booking> create(Booking booking) {
        String id = bookingService.addBooking(booking);
        booking.setId(id);
        return ResponseEntity.accepted().body(booking);
    }
}

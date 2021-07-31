package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;
import javax.validation.*;
import java.util.List;
import java.util.Set;

@RestController
public class BookingResourceImpl implements BookingResource {

    @Autowired
    private BookingService bookingService;

    @Autowired
    Validator validator;

    @Override
    public ResponseEntity<Booking> create(Booking booking) {
        validateRequest(booking);

        String id = bookingService.addBooking(booking);
        booking.setId(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(booking);
    }

    @Override
    public ResponseEntity<Booking> getBooking(@PathVariable String id) {
        Booking booking = bookingService.getBooking(id);

        if(booking == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking with given id not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(booking);
    }

    @Override
    public ResponseEntity<List<Booking>> getAllBooking() {
        List<Booking> bookings = bookingService.getAllBookings();
        return ResponseEntity.status(HttpStatus.OK).body(bookings);
    }

    private void validateRequest(Booking booking) {
        Set<ConstraintViolation<Booking>> constraintViolations = validator.validate(booking);

        if(constraintViolations.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();

            for (ConstraintViolation<Booking> constraintViolation : constraintViolations) {
                stringBuilder.append(constraintViolation.getPropertyPath());
                stringBuilder.append(" ");
                stringBuilder.append(constraintViolation.getMessage());
                stringBuilder.append(", ");
            }

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, stringBuilder.toString());
        }
    }
}

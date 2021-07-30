package com.paypal.bfs.test.bookingserv.dao.service;

import com.paypal.bfs.test.bookingserv.dao.entity.BookingEntity;

import java.math.BigInteger;

public interface BookingDaoService {
    String addBooking(BookingEntity bookingEntity);
    BookingEntity getBooking(BigInteger id);

    // void addBookingEntity(BookingEntity bookingEntity);
     // Booking findById(int id)  throws Exception;
    // List<Booking> getAllBookingEntities(int offset, int limit);
}

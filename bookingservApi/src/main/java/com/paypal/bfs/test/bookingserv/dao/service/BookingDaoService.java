package com.paypal.bfs.test.bookingserv.dao.service;

import com.paypal.bfs.test.bookingserv.dao.entity.BookingEntity;

import java.math.BigInteger;
import java.util.List;

public interface BookingDaoService {
    String addBooking(BookingEntity bookingEntity);
    BookingEntity getBooking(BigInteger id);
    List<BookingEntity> getAllBooking();
    // void addBookingEntity(BookingEntity bookingEntity);
     // Booking findById(int id)  throws Exception;
    // List<Booking> getAllBookingEntities(int offset, int limit);
}

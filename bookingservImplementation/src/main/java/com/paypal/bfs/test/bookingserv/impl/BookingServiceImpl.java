package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.dao.service.BookingDaoService;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingDaoService bookingDao;

    @Override
    public String addBooking(Booking booking) {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.firstName = booking.getFirstName();
        bookingEntity.lastName = booking.getLastName();

        return bookingDao.addBooking(bookingEntity);
    }

    @Override
    public Booking getBooking(int id) {
        // BigInteger bigInteger = BigInteger.valueOf(id);
        // return bookingDao.findById(BigInteger.valueOf(id));
        return null;
    }

    @Override
    public List<Booking> getAllBookings(int offset, int limit) {
        return null;
    }
}

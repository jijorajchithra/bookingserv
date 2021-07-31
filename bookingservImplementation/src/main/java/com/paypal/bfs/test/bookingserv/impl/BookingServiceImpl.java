package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.entity.AddressEntity;
import com.paypal.bfs.test.bookingserv.dao.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.dao.service.BookingDaoService;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
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

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.line1 = booking.getAddress().getLine1();
        addressEntity.line2 = booking.getAddress().getLine2();
        bookingEntity.address = addressEntity;

        return bookingDao.addBooking(bookingEntity);
    }

    @Override
    public Booking getBooking(String id) {
        BigInteger bookingId = new BigInteger(id);
        BookingEntity bookingEntity = bookingDao.getBooking(bookingId);

        if(bookingEntity != null) {
            Booking booking = new Booking();
            booking.setFirstName(bookingEntity.getFirstName());
            booking.setLastName(bookingEntity.getLastName());

            Address address = new Address();
            address.setLine1(bookingEntity.getAddress().getLine1());
            address.setLine2(bookingEntity.getAddress().getLine2());
            booking.setAddress(address);

            return booking;
        }

        return null;
    }

    @Override
    public List<Booking> getAllBookings() {
        List<BookingEntity> bookingEntities = bookingDao.getAllBooking();
        List<Booking> bookings = new ArrayList<Booking>();
        for (BookingEntity bookingEntity: bookingEntities) {
            bookings.add(convertBooking(bookingEntity));
        }

        return bookings;
    }

    Booking convertBooking(BookingEntity bookingEntity) {
        return new Booking()
                .withId(bookingEntity.getId().toString())
                .withFirstName(bookingEntity.getFirstName())
                .withLastName(bookingEntity.getLastName())
                .withAddress( new Address()
                        .withLine1(bookingEntity.getAddress().getLine1())
                        .withLine2(bookingEntity.getAddress().getLine2()));
    }
}

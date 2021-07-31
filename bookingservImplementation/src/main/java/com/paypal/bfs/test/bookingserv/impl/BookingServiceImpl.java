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
        BookingEntity bookingEntity = convert(booking);
        return bookingDao.addBooking(bookingEntity);
    }

    @Override
    public Booking getBooking(String id) {
        BigInteger bookingId = new BigInteger(id);
        BookingEntity bookingEntity = bookingDao.getBooking(bookingId);

        if(bookingEntity != null) {
            return convert(bookingEntity);
        }

        return null;
    }

    @Override
    public List<Booking> getAllBookings() {
        List<BookingEntity> bookingEntities = bookingDao.getAllBooking();
        List<Booking> bookings = new ArrayList<>();
        for (BookingEntity bookingEntity: bookingEntities) {
            bookings.add(convert(bookingEntity));
        }

        return bookings;
    }

    Booking convert(BookingEntity bookingEntity) {
        return new Booking()
                .withId(bookingEntity.getId().toString())
                .withFirstName(bookingEntity.getFirstName())
                .withLastName(bookingEntity.getLastName())
                .withDob(bookingEntity.getDob())
                .withCheckin(bookingEntity.getCheckIn())
                .withCheckout(bookingEntity.getCheckOut())
                .withTotalprice(bookingEntity.getTotalPrice())
                .withDeposit(bookingEntity.getDeposit())
                .withAddress( new Address()
                        .withLine1(bookingEntity.getAddress().getLine1())
                        .withLine2(bookingEntity.getAddress().getLine2())
                        .withCity(bookingEntity.getAddress().getCity())
                        .withState(bookingEntity.getAddress().getState())
                        .withCountry(bookingEntity.getAddress().getCountry()));
    }

    BookingEntity convert(Booking booking) {
        BookingEntity bookingEntity = new BookingEntity();
        bookingEntity.setFirstName(booking.getFirstName());
        bookingEntity.setLastName(booking.getLastName());
        bookingEntity.setDob(booking.getDob());
        bookingEntity.setCheckIn(booking.getCheckin());
        bookingEntity.setCheckOut(booking.getCheckout());
        bookingEntity.setTotalPrice(booking.getTotalprice());
        bookingEntity.setDeposit(booking.getDeposit());

        Address address = booking.getAddress();
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setLine1(address.getLine1());
        addressEntity.setLine2(address.getLine2());
        addressEntity.setCity(address.getCity());
        addressEntity.setState(address.getState());
        addressEntity.setCountry(address.getCountry());
        bookingEntity.setAddress(addressEntity);

        return bookingEntity;
    }
}

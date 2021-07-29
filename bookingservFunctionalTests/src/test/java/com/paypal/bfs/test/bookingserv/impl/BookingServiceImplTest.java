package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.dao.service.BookingDaoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class BookingServiceImplTest {
    @Mock
    private BookingDaoService bookingDao;

    @InjectMocks
    private BookingServiceImpl bookingServiceImpl;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateBookingSuccess() {
        Booking booking = getBooking();

        bookingServiceImpl.addBooking(booking);
        verify(bookingDao, times(1))
                .addBooking(any(BookingEntity.class));
    }

    private Booking getBooking() {
        Booking booking = new Booking();
        booking.setFirstName("alex");
        booking.setFirstName("Blake");
        Address address = new Address();
        address.setLine1("69th street");
        booking.setAddress(address);
        return booking;
    }
}

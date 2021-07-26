package com.paypal.bfs.test.bookingserv.dao.service;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.dao.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.dao.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;

public interface BookingDaoService {
    String addBooking(BookingEntity bookingEntity);

    // void addBookingEntity(BookingEntity bookingEntity);
     // Booking findById(int id)  throws Exception;
    // List<Booking> getAllBookingEntities(int offset, int limit);
}

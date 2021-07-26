package com.paypal.bfs.test.bookingserv.impl;

import com.paypal.bfs.test.bookingserv.dao.entity.BookingEntity;
import com.paypal.bfs.test.bookingserv.dao.repository.BookingRepository;
import com.paypal.bfs.test.bookingserv.dao.service.BookingDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingDaoServiceImpl implements BookingDaoService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    @Transactional
    public String addBooking(BookingEntity bookingEntity) {
        BookingEntity createdEntity = bookingRepository.save(bookingEntity);
        return createdEntity.id.toString();
    }
}

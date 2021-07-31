package com.paypal.bfs.test.bookingserv.dao.repository;

import com.paypal.bfs.test.bookingserv.dao.entity.BookingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<BookingEntity, BigInteger> {
    List<BookingEntity> findAll();
}

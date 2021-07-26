package com.paypal.bfs.test.bookingserv;

import com.paypal.bfs.test.bookingserv.dao.service.BookingDaoService;
import com.paypal.bfs.test.bookingserv.impl.BookingServiceImpl;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// @ComponentScan(basePackageClasses = {BookingServApplication.class, BookingServiceImpl.class, BookingService.class, BookingDaoService.class})
@ComponentScan("com.paypal.bfs")
@SpringBootApplication
public class BookingServApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookingServApplication.class, args);
    }
}
package com.paypal.bfs.test.bookingserv.api;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

public interface BookingResource {

    @RequestMapping(value = "/v1/bfs/booking/{id}", method = GET)
    ResponseEntity<Booking> getBooking(@PathVariable String id);

    /**
     * Create {@link Booking} resource
     *
     * @param booking the booking object
     * @return the created booking
     */
    @RequestMapping(value = "/v1/bfs/booking", method = POST)
    ResponseEntity<Booking> create(@RequestBody Booking booking);


    // ----------------------------------------------------------
    // TODO - add a new operation for Get All the bookings resource.
    // ----------------------------------------------------------
}

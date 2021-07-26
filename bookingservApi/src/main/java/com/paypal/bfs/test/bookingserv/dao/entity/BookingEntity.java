package com.paypal.bfs.test.bookingserv.dao.entity;

import javax.persistence.*;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.math.BigInteger;

@Entity
@Table(name="BOOKINGS")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "REQUEST_ID", unique = true, nullable = false, insertable = true, updatable = false)
    public BigInteger id;

    @Column(name="FIRST_NAME", length=50, nullable=false, unique=false)
    public String firstName;

    @Column(name="LAST_NAME", length=50, nullable=false, unique=false)
    public String lastName;
}

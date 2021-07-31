package com.paypal.bfs.test.bookingserv.dao.entity;

import javax.persistence.*;
import com.paypal.bfs.test.bookingserv.api.model.Address;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="BOOKINGS")
@Data
// @Builder
public class BookingEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "BOOKING_ID", unique = true, nullable = false, insertable = true, updatable = false)
    public BigInteger id;

    @Column(name="FIRST_NAME", length=50, nullable=false, unique=false)
    public String firstName;

    @Column(name="LAST_NAME", length=50, nullable=false, unique=false)
    public String lastName;

    // @Column(name="DOB", columnDefinition = "DATE")
    @Column(name="DOB", nullable = false)
    private LocalDate dob;

    // @Column(columnDefinition = "TIMESTAMP")
    @Column(name="CHECK_IN", nullable = false)
    private LocalDateTime checkIn;

    @Column(name="CHECK_OUT", nullable = false)
    private LocalDateTime checkOut;

    // @Column(name="TOTAL_PRICE", columnDefinition="Decimal(10,2)", nullable = false)
    @Column(name="TOTAL_PRICE", nullable = false)
    private Double totalPrice;

    // @Column(name="DEPOSIT", columnDefinition="Decimal(10,2)", nullable = false)
    @Column(name="DEPOSIT", nullable = false)
    private Double deposit;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID")
    public AddressEntity address;
}

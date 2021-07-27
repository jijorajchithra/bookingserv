package com.paypal.bfs.test.bookingserv.dao.entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="ADDRESS")
public class AddressEntity {
    @Id
    // @GeneratedValue(strategy= GenerationType.AUTO)
    @GeneratedValue(generator = "idGenerator")
    @Column(name = "ADDRESS_ID", unique = true, nullable = false, insertable = true, updatable = false)
    public BigInteger id;

    @Column(name="LINE1", length=255, nullable=false, unique=false)
    public String line1;

    @Column(name="LINE2", length=255, nullable=false, unique=false)
    public String line2;
}

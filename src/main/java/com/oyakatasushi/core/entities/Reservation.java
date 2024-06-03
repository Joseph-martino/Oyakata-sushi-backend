package com.oyakatasushi.core.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reservation_id")
    private Integer id;

    @Column(name="reservation_number")
    private String reservationNumber;

    @Column(name="first_name")
    private String firstName;
    @Column(name="family_name")
    private String familyName;
    @Column(name="email")
    private String email;
    @Column(name="number_Of_Persons")
    private Integer numberOfPersons;
    @Column(name="reservation_Date")
    private Date reservationDate;

    public Reservation() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(Integer numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationName(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
}

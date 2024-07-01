//package com.oyakatasushi.core.entities;
//
//import javax.persistence.*;
//
//@Entity
//public class Address {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "address_id")
//    private Integer addressId;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id", nullable = false)
//    private Customer customer;
//
//    @Column(name = "address_line", nullable = false)
//    private String addressLine;
//
//    @Column(name = "zipCode", nullable = false)
//    private String zipCode;
//
//    @Column(name = "city", nullable = false)
//    private String city;
//
//    public Integer getAddressId() {
//        return addressId;
//    }
//
//    public void setAddressId(Integer addressId) {
//        this.addressId = addressId;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public String getAddressLine() {
//        return addressLine;
//    }
//
//    public void setAddressLine(String addressLine) {
//        this.addressLine = addressLine;
//    }
//
//    public String getZipCode() {
//        return zipCode;
//    }
//
//    public void setZipCode(String zipCode) {
//        this.zipCode = zipCode;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//}

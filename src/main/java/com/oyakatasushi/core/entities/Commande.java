package com.oyakatasushi.core.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.oyakatasushi.core.enums.CommandeStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="commande_id")
    private Integer commandeId;

    @Column(name="commande_number", nullable = false)
    private String commandeNumber;

    @Column(name="created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name="reference", nullable = false)
    private String reference;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private List<CommandLine> commandLineList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false)
    private CommandeStatus status;

    @Column(name="total_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @Column(name="total_price_with_delivery_fee", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalPriceWithDeliveryFee;

    public Integer getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(Integer commandeId) {
        this.commandeId = commandeId;
    }

    public String getCommandeNumber() {
        return commandeNumber;
    }

    public void setCommandeNumber(String commandeNumber) {
        this.commandeNumber = commandeNumber;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CommandLine> getCommandLineList() {
        return commandLineList;
    }

    public void setCommandLineList(List<CommandLine> commandLineList) {
        this.commandLineList = commandLineList;
    }

    public CommandeStatus getStatus() {
        return status;
    }

    public void setStatus(CommandeStatus status) {
        this.status = status;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPriceWithDeliveryFee() {
        return totalPriceWithDeliveryFee;
    }

    public void setTotalPriceWithDeliveryFee(BigDecimal totalPriceWithDeliveryFee) {
        this.totalPriceWithDeliveryFee = totalPriceWithDeliveryFee;
    }
}

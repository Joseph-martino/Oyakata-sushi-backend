package com.oyakatasushi.core.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oyakatasushi.core.entities.CommandLine;
import com.oyakatasushi.core.entities.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@JsonIgnoreProperties(value = {"customer"})
public class CommandeDTO {
    private Integer commandeId;

    private String commandeNumber;

    private Date createdDate;

    private String reference;

    /**
     * enlever le customer dans commande
     */
    //private CustomerDTO customerDto;

    private List<CommandLineDTO> commandLineList = new ArrayList<>();

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

//    public CustomerDTO getCustomer() {
//        return customerDto;
//    }
//
//    public void setCustomer(CustomerDTO customerDto) {
//        this.customerDto = customerDto;
//    }

    public List<CommandLineDTO> getCommandLineList() {
        return commandLineList;
    }

    public void setCommandLineList(List<CommandLineDTO> commandLineListDTO) {
        this.commandLineList = commandLineListDTO;
    }
}

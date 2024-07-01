package com.oyakatasushi.core.services;

import com.oyakatasushi.core.dtos.CustomerDTO;
import com.oyakatasushi.core.entities.Customer;

public interface ICustomerService {

    CustomerDTO createCustomer(CustomerDTO customerDto);
    CustomerDTO updateCustomer(CustomerDTO customerDto);
    CustomerDTO getCustomerById(Integer id);
}

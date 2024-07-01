package com.oyakatasushi.core.repositories;

import com.oyakatasushi.core.entities.Customer;

public interface ICustomerRepository {

    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer getCustomerById(Integer id);
}

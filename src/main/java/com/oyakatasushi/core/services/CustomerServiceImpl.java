package com.oyakatasushi.core.services;

import com.oyakatasushi.core.dtos.CustomerDTO;
import com.oyakatasushi.core.entities.Customer;
import com.oyakatasushi.core.repositories.ICustomerRepository;
import org.modelmapper.ModelMapper;

public class CustomerServiceImpl implements ICustomerService{

    private ICustomerRepository customerRepository;
    private ModelMapper modelMapper;

    public CustomerServiceImpl(ICustomerRepository customerRepository, IModelMapperProvider modelMapperProvider){
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapperProvider.getModelMapper();
    }
    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDto) {
        Customer customer = this.modelMapper.map(customerDto, Customer.class);
        this.customerRepository.createCustomer(customer);
        return customerDto;
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDto) {
        Customer customer = this.modelMapper.map(customerDto, Customer.class);
        this.customerRepository.updateCustomer(customer);
        return customerDto;
    }

    @Override
    public CustomerDTO getCustomerById(Integer id) {
        Customer customer = this.customerRepository.getCustomerById(id);
        CustomerDTO customerDTO = this.modelMapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }
}

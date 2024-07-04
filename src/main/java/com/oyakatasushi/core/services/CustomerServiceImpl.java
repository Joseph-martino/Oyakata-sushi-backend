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

        try {
            String hashedPassword = PasswordUtil.hashPassword(customerDto.getPassword());
            customerDto.setPassword(hashedPassword);
            Customer customer = this.modelMapper.map(customerDto, Customer.class);
            this.customerRepository.createCustomer(customer);

            if (customer.getCustomerId() == null) {
                System.err.println("L'ID du client n'a pas été généré !");
                return null;
            }

            String token = JwtUtil.generateToken(customer.getEmail(), customer.getCustomerId(), customer.getFamilyName(), customer.getFirstName());
            customerDto.setToken(token);

            return customerDto;
        } catch (Exception e) {
            System.err.println("Erreur lors de la création du customer ou de la génération du token: " + e.getMessage());
            e.printStackTrace();
            return null; // Ou lancez une exception appropriée
        }
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

    @Override
    public CustomerDTO login(String email, String rawPassword) {
        Customer customer = this.customerRepository.login(email, rawPassword);
        CustomerDTO customerDTO = this.modelMapper.map(customer, CustomerDTO.class);
        String token = JwtUtil.generateToken(customer.getEmail(), customer.getCustomerId(), customer.getFamilyName(), customer.getFirstName());
        customerDTO.setToken(token);
        return customerDTO;
    }
}

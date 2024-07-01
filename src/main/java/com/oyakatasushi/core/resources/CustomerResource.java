package com.oyakatasushi.core.resources;

import com.oyakatasushi.core.dtos.CustomerDTO;
import com.oyakatasushi.core.repositories.CustomerRepositoryImpl;
import com.oyakatasushi.core.repositories.ICustomerRepository;
import com.oyakatasushi.core.services.CustomerServiceImpl;
import com.oyakatasushi.core.services.ICustomerService;
import com.oyakatasushi.core.services.IModelMapperProvider;
import com.oyakatasushi.core.services.ModelMapperProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/customer")
public class CustomerResource {

    private ICustomerRepository customerRepository;
    private ICustomerService customerService;
    private IModelMapperProvider modelMapperProvider;

    public CustomerResource(){
        this.customerRepository = new CustomerRepositoryImpl();
        this.modelMapperProvider = new ModelMapperProvider();
        this.customerService = new CustomerServiceImpl(this.customerRepository, this.modelMapperProvider);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerDTO getCustomerById(@PathParam("id") Integer id){
        CustomerDTO customerDTO = this.customerService.getCustomerById(id);
        return customerDTO;
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CustomerDTO createCustomer(CustomerDTO customerDto){
        System.out.println("Received customer request: " + customerDto);
        CustomerDTO createdCustomer = this.customerService.createCustomer(customerDto);
        return createdCustomer;
    }
}

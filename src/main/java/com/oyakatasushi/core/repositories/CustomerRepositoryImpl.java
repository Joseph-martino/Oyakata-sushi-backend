package com.oyakatasushi.core.repositories;

import com.oyakatasushi.core.EntityManagerHolder;
import com.oyakatasushi.core.entities.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class CustomerRepositoryImpl implements ICustomerRepository{
    @Override
    public Customer createCustomer(Customer customer) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = EntityManagerHolder.getCurrentEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(customer);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();

        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = EntityManagerHolder.getCurrentEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(customer);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();

        } finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return customer;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }
}

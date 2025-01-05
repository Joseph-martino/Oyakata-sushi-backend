package com.oyakatasushi.core.repositories;

import com.oyakatasushi.core.EntityManagerHolder;
import com.oyakatasushi.core.dtos.ReservationDTO;
import com.oyakatasushi.core.entities.Commande;
import com.oyakatasushi.core.entities.Customer;
import com.oyakatasushi.core.entities.Reservation;
import com.oyakatasushi.core.services.PasswordUtil;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.HashSet;

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

//    @Override
//    public Customer login(String email, String rawPassword) {
//        EntityManager entityManager = null;
//        EntityTransaction transaction = null;
//
//        try {
//            entityManager = EntityManagerHolder.getCurrentEntityManager();
//            transaction = entityManager.getTransaction();
//            transaction.begin();
//
//            TypedQuery<Customer> query = entityManager.createQuery(
//                    "SELECT c FROM Customer c LEFT JOIN FETCH c.reservations WHERE c.email = :email", Customer.class);
//            query.setParameter("email", email);
//
//            Customer customer = query.getSingleResult();
//
//            if (customer != null && PasswordUtil.isPasswordMatches(rawPassword, customer.getPassword())) {
//                transaction.commit();
//                return customer;
//            } else {
//                transaction.rollback();
//                return null;
//            }
//        } catch (NoResultException e) {
//            if (transaction != null && transaction.isActive()) {
//                transaction.rollback();
//            }
//            return null;
//        } catch (Exception e) {
//            if (transaction != null && transaction.isActive()) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//            return null;
//        } finally {
//            if (entityManager != null) {
//                entityManager.close();
//            }
//        }
//    }

    /**
     * retirer les transaction pour les opération de lecture
     * @param email
     * @param rawPassword
     * @return
     */
    @Override
    public Customer login(String email, String rawPassword) {
        EntityManager entityManager = null;

        try {
            entityManager = EntityManagerHolder.getCurrentEntityManager();

//            // Charger le client avec ses réservations
//            TypedQuery<Customer> query = entityManager.createQuery(
//                    "SELECT c FROM Customer c " +
//                            "LEFT JOIN FETCH c.reservations " +
//                            "WHERE c.email = :email", Customer.class);
//            query.setParameter("email", email);
//            Customer customer = query.getSingleResult();

            // Charger le client avec ses réservations
            TypedQuery<Customer> query = entityManager.createQuery(
                    "SELECT c FROM Customer c WHERE c.email = :email", Customer.class);
            query.setParameter("email", email);
            Customer customer = query.getSingleResult();


            // Si le client existe et que le mot de passe est correct
            if (customer != null && PasswordUtil.isPasswordMatches(rawPassword, customer.getPassword())) {
//                // Charger les commandes dans une requête distincte pour éviter le MultipleBagFetchException
//                TypedQuery<Commande> commandeQuery = entityManager.createQuery(
//                        "SELECT c FROM Commande c " +
//                                "WHERE c.customer = :customer", Commande.class);
//                commandeQuery.setParameter("customer", customer);
//                customer.setCommandes(new HashSet<>(commandeQuery.getResultList())); // Assigner les commandes
                return customer;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}

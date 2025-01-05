package com.oyakatasushi.core.repositories;

import com.oyakatasushi.core.EntityManagerHolder;
import com.oyakatasushi.core.entities.Commande;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CommandeRepositoryImpl implements ICommandeRepository{
    @Override
    public Commande getCommandeById(Integer id) {
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        Commande commande = entityManager.find(Commande.class, id);
        return commande;
    }

    @Override
    public Commande createCommande(Commande commande) {
        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        try {
            entityManager = EntityManagerHolder.getCurrentEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(commande);
            transaction.commit();

        }catch (Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return commande;
    }

    @Override
    public List<Commande> getCustomerCommandes(Integer customerId) {
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Commande> query = entityManager.createQuery("SELECT c FROM Commande c WHERE c.customer.id = :customerId", Commande.class);
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }
}

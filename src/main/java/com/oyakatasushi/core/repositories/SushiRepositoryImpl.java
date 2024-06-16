package com.oyakatasushi.core.repositories;

import com.oyakatasushi.core.EntityManagerHolder;
import com.oyakatasushi.core.entities.Category;
import com.oyakatasushi.core.entities.Sushi;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class SushiRepositoryImpl implements ISushiRepository{
    @Override
    public Sushi getById(Integer id) {
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        Sushi sushi = entityManager.find(Sushi.class, id);
        return sushi;
    }

    @Override
    public List<Sushi> getSushisListByTerms(String term) {
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Sushi> query = entityManager.createQuery("SELECT s FROM Sushi s WHERE s.name LIKE CONCAT('%', :term, '%')", Sushi.class);
        query.setParameter("term", term);
        List<Sushi> sushis = query.getResultList();
        return sushis;
    }

    @Override
    public List<Sushi> getSushisListByCategoryName(String categoryName) {
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Sushi> query = entityManager.createQuery("SELECT s FROM Sushi s INNER JOIN FETCH s.category c WHERE c.name = :name", Sushi.class);
        query.setParameter("name", categoryName);
        List<Sushi> sushis = query.getResultList();
        return sushis;
    }
    @Override
    public List<Sushi> getSushisListForPage(Integer pageNumber, Integer pageSize) {
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Sushi> query = entityManager.createQuery("SELECT s FROM Sushi s ORDER BY s.id", Sushi.class);
        query.setFirstResult((pageNumber -1) * pageSize);
        query.setMaxResults(pageSize);
        List<Sushi> sushis = query.getResultList();
        return sushis;
    }

    @Override
    public long getNumberTotalOfSushis() {
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        Query query = entityManager.createQuery("SELECT COUNT(s) FROM Sushi s");
        long totalNumberOfSushis = (long) query.getSingleResult();
        return totalNumberOfSushis;
    }
}

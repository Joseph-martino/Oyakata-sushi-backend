package com.oyakatasushi.core.repositories;

import com.oyakatasushi.core.entities.Menu;
import com.oyakatasushi.core.EntityManagerHolder;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class MenuRepositoryImpl implements IMenuRepository{

    public List<Menu> getMenusList(){
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        //TypedQuery<Menu> query = entityManager.createQuery("SELECT m FROM com.oyakatasushi.core.entities.Menu m", Menu.class);
        TypedQuery<Menu> query = entityManager.createQuery("SELECT m FROM Menu m", Menu.class);
        return query.getResultList();

    }


    public Menu getById(Integer id) {
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        return entityManager.find(Menu.class, id);
    }

    @Override
    public List<Menu> getMenusListByTerms(String term) {
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Menu> query = entityManager.createQuery("SELECT m FROM Menu m WHERE m.name LIKE CONCAT('%', :term, '%')", Menu.class);
        query.setParameter("term", term);
        return query.getResultList();
    }
    @Override
    public List<Menu> getMenusListForPage(Integer pageNumber, Integer sizePage){
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Menu> query = entityManager.createQuery("SELECT m FROM Menu m ORDER BY m.id", Menu.class);
        query.setFirstResult((pageNumber -1) * sizePage);
        query.setMaxResults(sizePage);
        return query.getResultList();
    }

    @Override
    public long getNumberTotalOfMenus() {
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        Query query = entityManager.createQuery("SELECT COUNT(m) FROM Menu m");
        return (long) query.getSingleResult();
    }

    @Override
    public List<Menu> getMenusListByCategoryName(String categoryName) {
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Menu> query = entityManager.createQuery("SELECT m FROM Menu m INNER JOIN FETCH m.category c WHERE c.name = :name", Menu.class);
        query.setParameter("name", categoryName);
        return query.getResultList();
    }
}

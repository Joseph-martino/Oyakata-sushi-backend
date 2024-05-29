package com.oyakatasushi.core.repositories;

import com.oyakatasushi.core.entities.Menu;
import com.oyakatasushi.core.EntityManagerHolder;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class MenuRepositoryImpl implements IMenuRepository{

    public List<Menu> getMenusList(){
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Menu> query = entityManager.createQuery("SELECT m FROM com.oyakatasushi.core.entities.Menu m", Menu.class);
        List<Menu> menus = query.getResultList();
        return menus;
    }


    public Menu getById(Integer id) {
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        Menu menu = entityManager.find(Menu.class, id);
        return menu;
    }
}

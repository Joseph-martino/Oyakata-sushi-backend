package com.oyakatasushi.core.repositories;

import com.oyakatasushi.core.EntityManagerHolder;
import com.oyakatasushi.core.entities.Category;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoryRepositoryImpl implements ICategoryRepository{
    @Override
    public List<Category> getCategories() {
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category c", Category.class);
        List<Category> categories = query.getResultList();
        return categories;
    }

    @Override
    public Category getById(Integer id) {
        EntityManager entityManager = EntityManagerHolder.getCurrentEntityManager();
        Category category = entityManager.find(Category.class, id);
        return category;
    }
}

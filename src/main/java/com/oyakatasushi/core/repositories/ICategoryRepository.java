package com.oyakatasushi.core.repositories;

import com.oyakatasushi.core.entities.Category;

import java.util.List;

public interface ICategoryRepository {

    List<Category> getCategoriesForSushis();
    List<Category> getCategoriesForMenus();

    Category getById(Integer id);
}

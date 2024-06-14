package com.oyakatasushi.core.repositories;

import com.oyakatasushi.core.entities.Category;

import java.util.List;

public interface ICategoryRepository {

    List<Category> getCategories();
    Category getById(Integer id);
}

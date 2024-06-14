package com.oyakatasushi.core.services;

import com.oyakatasushi.core.entities.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getCategories();
    Category getCategoryById(Integer id);
}

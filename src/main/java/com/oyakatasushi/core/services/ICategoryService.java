package com.oyakatasushi.core.services;

import com.oyakatasushi.core.entities.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getCategoriesForSushis();
    List<Category> getCategoriesForMenus();
    Category getCategoryById(Integer id);
}

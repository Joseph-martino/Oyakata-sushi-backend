package com.oyakatasushi.core.services;

import com.oyakatasushi.core.entities.Category;
import com.oyakatasushi.core.repositories.ICategoryRepository;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService{

    private ICategoryRepository categoryRepository;

    public CategoryServiceImpl(ICategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> getCategories() {
        return this.categoryRepository.getCategories();
    }

    @Override
    public Category getCategoryById(Integer id) {
        return this.categoryRepository.getById(id);
    }
}

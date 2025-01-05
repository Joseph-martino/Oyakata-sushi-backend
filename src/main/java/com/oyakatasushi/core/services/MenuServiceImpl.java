package com.oyakatasushi.core.services;

import com.oyakatasushi.core.entities.Menu;
import com.oyakatasushi.core.repositories.IMenuRepository;

import java.util.List;

public class MenuServiceImpl implements IMenuService{

    private final IMenuRepository menuRepository;

    public MenuServiceImpl(IMenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu getMenuById(final Integer id) {
        return this.menuRepository.getById(id);
    }

    @Override
    public List<Menu> getMenusListByTerms(String term) {
        return this.menuRepository.getMenusListByTerms(term);
    }

    //test pagination
    @Override
    public List<Menu> getMenusListForPage(Integer pageNumber, Integer sizePage){
        return this.menuRepository.getMenusListForPage(pageNumber, sizePage);
    }

    @Override
    public long getNumberTotalOfMenus() {
        return this.menuRepository.getNumberTotalOfMenus();
    }

    @Override
    public List<Menu> getMenusListByCategoryName(String categoryName) {
        return this.menuRepository.getMenusListByCategoryName(categoryName);
    }
}

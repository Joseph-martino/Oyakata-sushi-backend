package com.oyakatasushi.core.services;

import com.oyakatasushi.core.entities.Menu;

import java.util.List;

public interface IMenuService {
    List<Menu> getMenusList();
    Menu getMenuById(Integer id);
    Menu getMenuByName(String name);
    List<Menu> getMenusListByTerms(String term);
}

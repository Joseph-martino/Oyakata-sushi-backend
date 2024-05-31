package com.oyakatasushi.core.repositories;

import com.oyakatasushi.core.entities.Menu;

import java.util.List;

public interface IMenuRepository {

    List<Menu> getMenusList();
    Menu getById(Integer id);
    Menu getByName(String name);
    List<Menu> getMenusListByTerms(String term);


}

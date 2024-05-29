package com.oyakatasushi.core;

import com.oyakatasushi.core.entities.Menu;
import com.oyakatasushi.core.repositories.IMenuRepository;
import com.oyakatasushi.core.repositories.MenuRepositoryImpl;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        IMenuRepository menuRepository = new MenuRepositoryImpl();

        List<Menu> menus = menuRepository.getMenusList();

        for(Menu menu: menus){
            System.out.println(menu.getName() + " " + menu.getContent());
        }

    }
}

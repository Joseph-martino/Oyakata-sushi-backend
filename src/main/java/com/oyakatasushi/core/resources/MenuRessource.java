package com.oyakatasushi.core.resources;

import com.oyakatasushi.core.entities.Menu;
import com.oyakatasushi.core.repositories.IMenuRepository;
import com.oyakatasushi.core.repositories.MenuRepositoryImpl;
import com.oyakatasushi.core.services.IMenuService;
import com.oyakatasushi.core.services.MenuServiceImpl;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/menus")
public class MenuRessource {

    private IMenuRepository menuRepository;
    private IMenuService menuService;

    public MenuRessource(){
        this.menuRepository = new MenuRepositoryImpl();
        this.menuService = new MenuServiceImpl(this.menuRepository);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Menu> getMenusList(){
        System.out.println("bonjour");
        return this.menuService.getMenusList();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Menu getMenuById(@PathParam("id") Integer id){
        return this.menuService.getMenuById(id);
    }


}

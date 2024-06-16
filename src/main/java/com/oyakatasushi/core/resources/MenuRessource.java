package com.oyakatasushi.core.resources;

import com.oyakatasushi.core.entities.Menu;
import com.oyakatasushi.core.entities.Sushi;
import com.oyakatasushi.core.repositories.IMenuRepository;
import com.oyakatasushi.core.repositories.MenuRepositoryImpl;
import com.oyakatasushi.core.services.IMenuService;
import com.oyakatasushi.core.services.MenuServiceImpl;

import javax.ws.rs.*;
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
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Menu getMenuById(@PathParam("id") Integer id){
        return this.menuService.getMenuById(id);
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Menu> getMenuByName(@PathParam("name") String name){
        return this.menuService.getMenusListByTerms(name);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Menu> getMenusListForPage(@QueryParam("pageNumber") Integer pageNumber, @QueryParam("pageSize") Integer pageSize){
        return this.menuService.getMenusListForPage(pageNumber, pageSize);
    }

    @GET
    @Path("/total")
    @Produces(MediaType.APPLICATION_JSON)
    public long getNumberTotalOfMenus(){
        return this.menuService.getNumberTotalOfMenus();
    }

    @GET
    @Path("/category/{categoryName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Menu> getMenusListByCategory(@PathParam("categoryName") String categoryName){
        return this.menuService.getMenusListByCategoryName(categoryName);
    }

}

package com.oyakatasushi.core.resources;

import com.oyakatasushi.core.entities.Category;
import com.oyakatasushi.core.repositories.CategoryRepositoryImpl;
import com.oyakatasushi.core.repositories.ICategoryRepository;
import com.oyakatasushi.core.services.CategoryServiceImpl;
import com.oyakatasushi.core.services.ICategoryService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/category")
public class CategoryRessource {

    private ICategoryRepository categoryRepository;
    private ICategoryService categoryService;

    public CategoryRessource(){
        this.categoryRepository = new CategoryRepositoryImpl();
        this.categoryService = new CategoryServiceImpl(this.categoryRepository);
    }

    @GET
    @Path("/categorySushi")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategoriesForSushis(){
        return this.categoryService.getCategoriesForSushis();
    }

    @GET
    @Path("/categoryMenu")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> getCategoriesForMenus(){
        return this.categoryService.getCategoriesForMenus();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategoryById(@PathParam("id") Integer id){
        return this.categoryService.getCategoryById(id);
    }
}

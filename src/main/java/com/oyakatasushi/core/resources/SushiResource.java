package com.oyakatasushi.core.resources;

import com.oyakatasushi.core.entities.Sushi;
import com.oyakatasushi.core.repositories.ISushiRepository;
import com.oyakatasushi.core.repositories.SushiRepositoryImpl;
import com.oyakatasushi.core.services.ISushiService;
import com.oyakatasushi.core.services.SushiServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/sushis")
public class SushiResource {

    private ISushiRepository sushiRepository;
    private ISushiService sushiService;

    public SushiResource(){
        this.sushiRepository = new SushiRepositoryImpl();
        this.sushiService = new SushiServiceImpl(this.sushiRepository);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Sushi> getSushisListForPage(@QueryParam("pageNumber") Integer pageNumber, @QueryParam("pageSize") Integer pageSize){
        return this.sushiService.getSushisListForPage(pageNumber, pageSize);
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Sushi getSushiById(@PathParam("id") Integer id){
        return this.sushiService.getSushiById(id);
    }

    @GET
    @Path("name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    List<Sushi> getSushisListByTerms(@PathParam("name") String term){
        return this.sushiService.getSushisListByTerms(term);
    }

    @GET
    @Path("/total")
    @Produces(MediaType.APPLICATION_JSON)
    long getNumberTotalOfSushis(){
        return this.sushiService.getNumberTotalOfSushis();
    }
}

package com.oyakatasushi.core.resources;

import com.oyakatasushi.core.dtos.CommandLineDTO;
import com.oyakatasushi.core.dtos.CommandeDTO;
import com.oyakatasushi.core.entities.CommandLine;
import com.oyakatasushi.core.entities.Commande;
import com.oyakatasushi.core.enums.CommandeStatus;
import com.oyakatasushi.core.repositories.CommandeRepositoryImpl;
import com.oyakatasushi.core.repositories.ICommandeRepository;
import com.oyakatasushi.core.services.CommandeServiceImpl;
import com.oyakatasushi.core.services.ICommandeService;
import com.oyakatasushi.core.services.IModelMapperProvider;
import com.oyakatasushi.core.services.ModelMapperProvider;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/commande")
public class CommandeResource {

    private ICommandeService commandeService;
    private ICommandeRepository commandeRepository;
    private IModelMapperProvider modelMapperProvider;

    public CommandeResource(){
        this.commandeRepository = new CommandeRepositoryImpl();
        this.modelMapperProvider = new ModelMapperProvider();
        this.commandeService = new CommandeServiceImpl(this.commandeRepository, this.modelMapperProvider);
    }

    //TODO test a modifier
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void getCommandeById(@PathParam("id") Integer id){
        this.commandeService.getCommandeById(id);
    }

    @GET
    @Path("/totalCustomerCommande/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CommandeDTO> getCustomerCommandes(@PathParam("id") Integer customerId){
        return this.commandeService.getCustomerCommandes(customerId);
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CommandeDTO createCommande(CommandeDTO commandeDto){
        System.out.println("Received commande request: " + commandeDto);
        System.out.println("reference: " + commandeDto.getReference());
        System.out.println("number: " + commandeDto.getCommandeNumber());
        System.out.println("date: " + commandeDto.getCreatedDate());
        System.out.println("statut: " + commandeDto.getStatus());
//        System.out.println("customer first name: " + commandeDto.getCustomer().getFirstName());
//        System.out.println("customer family name: " + commandeDto.getCustomer().getFamilyName());
        for(CommandLineDTO commandLineDto : commandeDto.getCommandLineList()){
            System.out.println("prix total: " + commandLineDto.getLineTotalPrice());
            System.out.println("nom menu: " + commandLineDto.getMenu().getName());
            System.out.println("quantité: " + commandLineDto.getQuantity());
            //System.out.println("numero commande: " + commandLineDto.getCommandeId());
        }
        CommandeDTO createdCommande = this.commandeService.createCommande(commandeDto);
        System.out.println("Commande created: " + createdCommande);
        return createdCommande;
    }
}

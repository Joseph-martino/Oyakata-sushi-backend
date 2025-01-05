package com.oyakatasushi.core.services;

import com.oyakatasushi.core.dtos.CommandeDTO;
import com.oyakatasushi.core.entities.CommandLine;
import com.oyakatasushi.core.entities.Commande;
import com.oyakatasushi.core.repositories.ICommandeRepository;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class CommandeServiceImpl implements ICommandeService{

    private ICommandeRepository commandeRepository;
    private ModelMapper modelMapper;
    public CommandeServiceImpl(ICommandeRepository commandeRepository, IModelMapperProvider modelMapperProvider){
        this.commandeRepository = commandeRepository;
        this.modelMapper = modelMapperProvider.getModelMapper();
    }
    @Override
    public Commande getCommandeById(Integer id) {
        return this.commandeRepository.getCommandeById(id);
    }

    @Override
    public CommandeDTO createCommande(CommandeDTO commandeDto) {
        Commande commande = this.modelMapper.map(commandeDto, Commande.class);
        for (CommandLine commandLine : commande.getCommandLineList()) {
            commandLine.setCommande(commande);
        }
        this.commandeRepository.createCommande(commande);
        return commandeDto;
    }

    @Override
    public List<CommandeDTO> getCustomerCommandes(Integer customerId) {
        List<Commande> commandes = this.commandeRepository.getCustomerCommandes(customerId);
        List<CommandeDTO> commandeDTOS = new ArrayList<>();
        for(Commande commande: commandes){
            CommandeDTO commandeDTO = this.modelMapper.map(commande, CommandeDTO.class);
            commandeDTOS.add(commandeDTO);
        }
        return commandeDTOS;
    }
}

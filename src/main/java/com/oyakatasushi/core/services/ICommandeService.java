package com.oyakatasushi.core.services;

import com.oyakatasushi.core.dtos.CommandeDTO;
import com.oyakatasushi.core.entities.Commande;

import java.util.List;

public interface ICommandeService {

    Commande getCommandeById(Integer id);
    CommandeDTO createCommande(CommandeDTO commandeDto);
    List<CommandeDTO> getCustomerCommandes(Integer customerId);
}

package com.oyakatasushi.core.repositories;

import com.oyakatasushi.core.entities.Commande;

import java.util.List;

public interface ICommandeRepository {

    Commande getCommandeById(Integer id);
    Commande createCommande(Commande commande);

    List<Commande> getCustomerCommandes(Integer customerId);
}

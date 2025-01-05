package com.oyakatasushi.core.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oyakatasushi.core.entities.Commande;
import com.oyakatasushi.core.entities.Menu;

import javax.persistence.*;

@JsonIgnoreProperties(value = {"commande"})
public class CommandLineDTO {

    private Integer id;

    private Integer quantity;

    private Double lineTotalPrice;

    private Menu menu;

    //private CommandeDTO commande;

    //private Integer commandeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getLineTotalPrice() {
        return lineTotalPrice;
    }

    public void setLineTotalPrice(Double lineTotalPrice) {
        this.lineTotalPrice = lineTotalPrice;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

//    public CommandeDTO getCommande() {
//        return commande;
//    }
//
//    public void setCommande(CommandeDTO commandeDTO) {
//        this.commande = commandeDTO;
//    }

}

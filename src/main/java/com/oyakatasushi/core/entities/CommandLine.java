package com.oyakatasushi.core.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="commande_line")
public class CommandLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="commande_line_id")
    private Integer id;

    @Column(name="quantity", nullable = false)
    private Integer quantity;
    @Column(name="line_total_price", nullable = false)
    private Double lineTotalPrice;

    @ManyToOne
    @JoinColumn(name="menu_id", nullable = false)
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commande_id",nullable = false)
    private Commande commande;

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

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}

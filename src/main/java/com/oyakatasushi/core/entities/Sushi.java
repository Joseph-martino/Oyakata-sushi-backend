package com.oyakatasushi.core.entities;

import javax.persistence.*;

@Entity
public class Sushi {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="sushi_id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="number_of_pieces")
    private Integer numberOfPiece;

    @Column(name="price")
    private Double price;

    @Column(name="picture")
    private String picture;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfPiece() {
        return numberOfPiece;
    }

    public void setNumberOfPiece(Integer numberOfPiece) {
        this.numberOfPiece = numberOfPiece;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

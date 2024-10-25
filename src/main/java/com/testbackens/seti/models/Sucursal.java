package com.testbackens.seti.models;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "franquicia_id")
    private Franquicia franquicia;

    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    public Sucursal() {  }

    public Sucursal(String s, Franquicia franquicia1) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Franquicia getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(Franquicia franquicia) {
        this.franquicia = franquicia;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

package com.testbackens.seti.models;


import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Franquicia {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "franquicia", cascade = CascadeType.ALL)
    private List<Sucursal> sucursals = new ArrayList<>();

    public Franquicia() {
    }

    public Franquicia(Object o) {

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

    public List<Sucursal> getSucursals() {
        return sucursals;
    }

    public void setSucursals(List<Sucursal> sucursals) {
        this.sucursals = sucursals;
    }
}

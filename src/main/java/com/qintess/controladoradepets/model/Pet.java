package com.qintess.controladoradepets.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public
class Pet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String especie;

    public
    Long getId ( ) {
        return id;
    }

    public
    void setId (Long id) {
        this.id = id;
    }

    public
    Pet (String nome, String especie) {
        this.nome = nome;
        this.especie = especie;
    }

    public Pet() {

    }

    public
    String getNome ( ) {
        return nome;
    }
    public
    void setNome (String nome) {
        this.nome = nome;
    }
    public
    String getEspecie ( ) {
        return especie;
    }
    public
    void setEspecie (String especie) {
        this.especie = especie;
    }
}

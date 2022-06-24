package com.qintess.controladoradepets.model;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "pets")
public
class Pet implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private Porte porte;

    @Column(nullable = false)
    private String especie;

    private boolean ativo;

    public
    Pet (String nome, String especie) {
        this.nome = nome;
        this.especie = especie;
        this.ativo = true;
    }

    public
    Pet ( ) {
        this.ativo = false;
    }

    public
    Long getId ( ) {
        return id;
    }

    public
    void setId (Long id) {
        this.id = id;
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
    Porte getPorte ( ) {
        return porte;
    }

    public
    void setPorte (Porte porte) {
        this.porte = porte;
    }

    public
    String getEspecie ( ) {
        return especie;
    }

    public
    void setEspecie (String especie) {
        this.especie = especie;
    }

    public
    boolean isAtivo ( ) {
        return ativo;
    }

    public
    void setAtivo (boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public
    String toString ( ) {
        return "Pet{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", porte=" + porte +
                ", especie='" + especie + '\'' +
                '}';
    }
}

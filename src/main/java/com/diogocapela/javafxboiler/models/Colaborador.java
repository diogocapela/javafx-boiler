package com.diogocapela.javafxboiler.models;

import java.io.Serializable;

public class Colaborador implements Serializable {

    private int id;
    private String nomeCompleto;
    private String nomeAbreviado;

    public Colaborador(int id, String nomeCompleto, String nomeAbreviado) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.nomeAbreviado = nomeAbreviado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeAbreviado() {
        return nomeAbreviado;
    }

    public void setNomeAbreviado(String nomeAbreviado) {
        this.nomeAbreviado = nomeAbreviado;
    }

}

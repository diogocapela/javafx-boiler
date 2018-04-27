package com.diogocapela.javafxboiler.models;

import java.io.Serializable;

public class Equipamento implements Serializable {

    private int id;
    private String descricao;
    private int areaRestritaId;
    private String tipoMovimento;

    public Equipamento(int id, String descricao, int areaRestritaId, String tipoMovimento) {
        this.id = id;
        this.descricao = descricao;
        this.areaRestritaId = areaRestritaId;
        this.tipoMovimento = tipoMovimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAreaRestritaId() {
        return areaRestritaId;
    }

    public void setAreaRestritaId(int areaRestritaId) {
        this.areaRestritaId = areaRestritaId;
    }

    public String getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(String tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

}

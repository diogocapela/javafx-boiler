package com.diogocapela.javafxboiler.models;

import java.io.Serializable;

public class PerfilAutorizacao implements Serializable {

    private int id;
    private String descricao;
    private int areaRestritaId;
    private String periodoAutorizacao;

    public PerfilAutorizacao(int id, String descricao, int areaRestritaId, String periodoAutorizacao) {
        this.id = id;
        this.descricao = descricao;
        this.areaRestritaId = areaRestritaId;
        this.periodoAutorizacao = periodoAutorizacao;
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

    public String getPeriodoAutorizacao() {
        return periodoAutorizacao;
    }

    public void setPeriodoAutorizacao(String periodoAutorizacao) {
        this.periodoAutorizacao = periodoAutorizacao;
    }

}

package com.diogocapela.javafxboiler.models;

import com.diogocapela.javafxboiler.exceptions.DuplicateException;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

public class Empresa implements Serializable {

    // Singleton Pattern Variable
    static volatile private Empresa uniqueInstance = new Empresa();

    // Instance Variables
    private List<AreaRestrita> registoAreasRestritas;
    private List<Colaborador> registoColaboradores;
    private List<Equipamento> registoEquipamentos;
    private List<PerfilAutorizacao> registoPerfisAutorizacao;

    private Empresa() {
        this.registoAreasRestritas = new ArrayList<>();
        this.registoColaboradores = new ArrayList<>();
        this.registoEquipamentos = new ArrayList<>();
        this.registoPerfisAutorizacao = new ArrayList<>();
    }

    // Singleton Pattern Get Instance

    static public Empresa getInstance() {
        synchronized (Empresa.class) {
            if (uniqueInstance == null) {
                uniqueInstance = new Empresa();
            }
        }
        return uniqueInstance;
    }

    // Singleton Pattern Set Instance

    static public void setInstance(Empresa empresa) {
        uniqueInstance = empresa;
    }

    // AreaRestrita

    public List<AreaRestrita> getRegistoAreasRestritas() {
        return registoAreasRestritas;
    }

    public void setRegistoAreasRestritas(List<AreaRestrita> registoAreasRestritas) {
        this.registoAreasRestritas = registoAreasRestritas;
    }

    public void addAreaRestrita(AreaRestrita areaRestrita) throws DuplicateException {
        boolean duplicate = false;
        for (AreaRestrita ar : registoAreasRestritas) {
            if (ar.getId() == areaRestrita.getId()) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            registoAreasRestritas.add(areaRestrita);
        } else throw new DuplicateException("Área Restrita");
    }

    public void deleteAreaRestritaById(int id) {
        AreaRestrita areaRestrita = registoAreasRestritas.stream()
                .filter((ar) -> ar.getId() == id)
                .findFirst()
                .get();
        registoAreasRestritas.remove(areaRestrita);
    }

    // Colaborador

    public List<Colaborador> getRegistoColaboradores() {
        return registoColaboradores;
    }

    public void setRegistoColaboradores(List<Colaborador> registoColaboradores) {
        this.registoColaboradores = registoColaboradores;
    }

    public void addColaborador(Colaborador colaborador) throws DuplicateException {
        boolean duplicate = false;
        for (Colaborador c : registoColaboradores) {
            if (c.getId() == colaborador.getId()) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            registoColaboradores.add(colaborador);
        } else throw new DuplicateException("Colaborador");
    }

    public void deleteColaboradorById(int id) {
        Colaborador colaborador = registoColaboradores.stream()
                .filter((c) -> c.getId() == id)
                .findFirst()
                .get();
        registoColaboradores.remove(colaborador);
    }

    // Equipamento

    public List<Equipamento> getRegistoEquipamentos() {
        return registoEquipamentos;
    }

    public void setRegistoEquipamentos(List<Equipamento> registoEquipamentos) {
        this.registoEquipamentos = registoEquipamentos;
    }

    public void addEquipamento(Equipamento equipamento) throws DuplicateException {
        boolean duplicate = false;
        for (Equipamento e : registoEquipamentos) {
            if (e.getId() == equipamento.getId()) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            registoEquipamentos.add(equipamento);
        } else throw new DuplicateException("Equipamento");
    }

    public void deleteEquipamentoById(int id) {
        Equipamento equipamento = registoEquipamentos.stream()
                .filter((e) -> e.getId() == id)
                .findFirst()
                .get();
        registoEquipamentos.remove(equipamento);
    }

    // PerfilAutorizacao

    public List<PerfilAutorizacao> getRegistoPerfisAutorizacao() {
        return registoPerfisAutorizacao;
    }

    public void setRegistoPerfisAutorizacao(List<PerfilAutorizacao> registoPerfisAutorizacao) {
        this.registoPerfisAutorizacao = registoPerfisAutorizacao;
    }

    public void addPerfilAutorizacao(PerfilAutorizacao perfilAutorizacao) throws DuplicateException {
        boolean duplicate = false;
        for (PerfilAutorizacao p : registoPerfisAutorizacao) {
            if (p.getId() == perfilAutorizacao.getId()) {
                duplicate = true;
            }
        }
        if (!duplicate) {
            registoPerfisAutorizacao.add(perfilAutorizacao);
        } else throw new DuplicateException("Perfil de Autorização");
    }

    public void deletePerfilAutorizacaoById(int id) {
        PerfilAutorizacao perfilAutorizacao = registoPerfisAutorizacao.stream()
                .filter((e) -> e.getId() == id)
                .findFirst()
                .get();
        registoPerfisAutorizacao.remove(perfilAutorizacao);
    }

}

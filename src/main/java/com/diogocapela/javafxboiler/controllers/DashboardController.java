package com.diogocapela.javafxboiler.controllers;

import com.diogocapela.javafxboiler.models.*;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.URL;
import java.util.ResourceBundle;

public class DashboardController extends BaseController implements Initializable {

    @FXML
    private Label message;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("DashboardController: initialize()");
        System.out.println("DashboardController: empresa = " + empresa);
    }

    @FXML
    public void handleSerializeData() {
        System.out.println("DashboardController: handleSerializeData()");
        try {
            FileOutputStream fos = new FileOutputStream("./src/main/resources/database/serialized.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(empresa);
            oos.close();
            fos.close();
            message.setText("Data saved (serialized) with success.");
        } catch (Exception e) {
            message.setText(e.getLocalizedMessage());
        }
    }

    @FXML
    public void handleDeserializeData() {
        System.out.println("DashboardController: handleDeserializeData()");
        try {
            FileInputStream fis = new FileInputStream("./src/main/resources/database/serialized.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Empresa empresaCopy = (Empresa) ois.readObject();
            ois.close();
            fis.close();
            Empresa.setInstance(empresaCopy);
            /*
            for(AreaRestrita ar: empresaCopy.getRegistoAreasRestritas()) {
                empresa.addAreaRestrita(ar);
            }
            for(Colaborador c: empresaCopy.getRegistoColaboradores()){
                empresa.addColaborador(c);
            }
            for(Equipamento e: empresaCopy.getRegistoEquipamentos()) {
                empresa.addEquipamento(e);
            }
            for(PerfilAutorizacao pa: empresaCopy.getRegistoPerfisAutorizacao()) {
                empresa.addPerfilAutorizacao(pa);
            }
            */
            message.setText("Data loaded (deserialized) with success.");
            /*
            System.out.println("-------------------------------------------");
            System.out.println("Deserialized Data:");
            System.out.println("Lista de Colaboradores:");
            for (Colaborador c : empresa.getRegistoColaboradores()) {
                System.out.println(c.getId() + " " + c.getNomeCompleto() + " " + c.getNomeAbreviado());
            }
            System.out.println("-------------------------------------------");
            System.out.println("After Deserialized Data: empresa = " + empresa);
            System.out.println("-------------------------------------------");
            */
        } catch (Exception e) {
            message.setText(e.getLocalizedMessage());
        }
    }

    @FXML
    public void handleLoadAreasRestritas() {
        // TODO: finish
    }

    @FXML
    public void handleLoadColaboradores() {
        // TODO: finish
    }

    @FXML
    public void handleLoadEquipamentos() {
        // TODO: finish
    }

}

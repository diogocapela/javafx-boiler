package com.diogocapela.javafxboiler.controllers;

import com.diogocapela.javafxboiler.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    protected void openDashboard(ActionEvent event) {
        App.showPage("dashboard");
    }

    @FXML
    protected void openAreasRestritas(ActionEvent event) {
        App.showPage("areas_restritas");
    }

    @FXML
    protected void openColaboradores(ActionEvent event) {
        App.showPage("colaboradores");
    }

    @FXML
    protected void openEquipamentos(ActionEvent event) {
        App.showPage("equipamentos");
    }

    @FXML
    protected void openPerfisAutorizacao(ActionEvent event) {
        App.showPage("perfis_autorizacao");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("MenuController: initialize()");

    }

}

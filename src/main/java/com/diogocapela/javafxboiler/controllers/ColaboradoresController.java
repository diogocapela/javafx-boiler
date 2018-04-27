package com.diogocapela.javafxboiler.controllers;

import com.diogocapela.javafxboiler.models.Colaborador;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ColaboradoresController extends BaseController implements Initializable {

    @FXML
    private TableView<Colaborador> tabela;
    @FXML
    private TableColumn<Colaborador, Integer> col1;
    @FXML
    private TableColumn<Colaborador, String> col2;
    @FXML
    private TableColumn<Colaborador, String> col3;
    @FXML
    private TextField id;
    @FXML
    private TextField nomeCompleto;
    @FXML
    private TextField nomeAbreviado;
    @FXML
    private Label errorMessage;

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("ColaboradoresController: initialize()");
        System.out.println("ColaboradoresController: empresa = " + empresa);
        updateView();
    }

    private void updateView() {

        /**
        System.out.println("");
        for(Colaborador c: empresa.getRegistoColaboradores()) {
            System.out.println(c.getId() + c.getNomeCompleto() + c.getNomeAbreviado());
        }**/



        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<>("nomeCompleto"));
        col3.setCellValueFactory(new PropertyValueFactory<>("nomeAbreviado"));

        tabela.setItems(FXCollections.observableArrayList(
                empresa.getRegistoColaboradores()
        ));
    }

    private void clearInputs() {
        id.clear();
        nomeCompleto.clear();
        nomeAbreviado.clear();
    }

    @FXML
    protected void handleAddColaborador(ActionEvent event) {
        System.out.println("ColaboradoresController: handleAddColaborador()");
        try {
            empresa.addColaborador(new Colaborador(
                    Integer.parseInt(id.getText()),
                    nomeCompleto.getText(),
                    nomeAbreviado.getText()
            ));
        } catch (Exception e) {
            errorMessage.setText(e.getMessage());
        }
        clearInputs();
        updateView();
    }

    @FXML
    protected void handleDeleteColaborador(ActionEvent event) {
        System.out.println("ColaboradoresController: handleDeleteColaborador()");
        try {
            empresa.deleteColaboradorById(
                    tabela.getSelectionModel().getSelectedItem().getId()
            );
        } catch (Exception e) {
            errorMessage.setText(e.getMessage());
        }
        clearInputs();
        updateView();
    }

}

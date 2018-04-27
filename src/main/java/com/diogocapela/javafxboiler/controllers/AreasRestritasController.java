package com.diogocapela.javafxboiler.controllers;

import com.diogocapela.javafxboiler.models.AreaRestrita;

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

public class AreasRestritasController extends BaseController implements Initializable {

    @FXML
    private TableView<AreaRestrita> tabela;
    @FXML
    private TableColumn<AreaRestrita, Integer> col1;
    @FXML
    private TableColumn<AreaRestrita, String> col2;
    @FXML
    private TableColumn<AreaRestrita, String> col3;
    @FXML
    private TableColumn<AreaRestrita, Integer> col4;
    @FXML
    private TextField id;
    @FXML
    private TextField descricao;
    @FXML
    private TextField localizacao;
    @FXML
    private TextField lotacaoMaxima;
    @FXML
    private Label errorMessage;

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("AreasRestritasController: initialize()");
        System.out.println("AreasRestritasController: empresa = " + empresa);
        updateView();
    }

    private void updateView() {
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        col3.setCellValueFactory(new PropertyValueFactory<>("localizacao"));
        col4.setCellValueFactory(new PropertyValueFactory<>("lotacaoMaxima"));

        tabela.setItems(FXCollections.observableArrayList(
                empresa.getRegistoAreasRestritas()
        ));
    }

    private void clearInputs() {
        id.clear();
        descricao.clear();
        localizacao.clear();
        lotacaoMaxima.clear();
    }

    @FXML
    protected void handleAddAreaRestrita(ActionEvent event) {
        System.out.println("AreasRestritasController: handleAddColaborador()");
        try {
            empresa.addAreaRestrita(new AreaRestrita(
                    Integer.parseInt(id.getText()),
                    descricao.getText(),
                    localizacao.getText(),
                    Integer.parseInt(lotacaoMaxima.getText())
            ));
        } catch (Exception e) {
            errorMessage.setText(e.getMessage());
        }
        clearInputs();
        updateView();
    }

    @FXML
    protected void handleDeleteAreaRestrita(ActionEvent event) {
        System.out.println("AreasRestritasController: handleDeleteColaborador()");
        try {
            empresa.deleteAreaRestritaById(
                    tabela.getSelectionModel().getSelectedItem().getId()
            );
        } catch (Exception e) {
            errorMessage.setText(e.getMessage());
        }
        clearInputs();
        updateView();
    }

}

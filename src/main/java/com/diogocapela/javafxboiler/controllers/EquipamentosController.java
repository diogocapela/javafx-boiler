package com.diogocapela.javafxboiler.controllers;

import com.diogocapela.javafxboiler.models.AreaRestrita;
import com.diogocapela.javafxboiler.models.Equipamento;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EquipamentosController extends BaseController implements Initializable {

    @FXML
    private TableView<Equipamento> tabela;
    @FXML
    private TableColumn<Equipamento, Integer> col1;
    @FXML
    private TableColumn<Equipamento, String> col2;
    @FXML
    private TableColumn<Equipamento, Integer> col3;
    @FXML
    private TableColumn<Equipamento, String> col4;
    @FXML
    private TextField id;
    @FXML
    private TextField descricao;
    @FXML
    private ChoiceBox areaRestritaId;
    @FXML
    private ChoiceBox tipoMovimento;
    @FXML
    private Label errorMessage;

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("EquipamentosController: initialize()");
        System.out.println("EquipamentosController: empresa = " + empresa);

        // Populate Área Restrita ChoiceBox
        List<String> _ar = new ArrayList<>();
        for(AreaRestrita ar: empresa.getRegistoAreasRestritas()) {
            _ar.add(ar.getId() + ": "  + ar.getLocalizacao() + " " + ar.getDescricao() + " " + ar.getLotacaoMaxima());
        }
        areaRestritaId.setItems(FXCollections.observableArrayList(
                _ar
        ));

        // Populate Tipo de Movimento ChoiceBox
        tipoMovimento.setItems(FXCollections.observableArrayList(
                "Entrada","Saída"
        ));

        updateView();
    }

    private void updateView() {
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        col3.setCellValueFactory(new PropertyValueFactory<>("areaRestritaId"));
        col4.setCellValueFactory(new PropertyValueFactory<>("tipoMovimento"));

        tabela.setItems(FXCollections.observableArrayList(
                empresa.getRegistoEquipamentos()
        ));
    }

    private void clearInputs() {
        id.clear();
        descricao.clear();
        areaRestritaId.getSelectionModel().clearSelection();
        tipoMovimento.getSelectionModel().clearSelection();
    }

    @FXML
    protected void handleAddEquipamento(ActionEvent event) {
        System.out.println("EquipamentosController: handleAddEquipamento()");
        try {
            empresa.addEquipamento(new Equipamento(
                    Integer.parseInt(id.getText()),
                    descricao.getText(),
                    Integer.parseInt(areaRestritaId.getValue().toString().split(":")[0]),
                    tipoMovimento.getValue().toString()
            ));
        } catch (Exception e) {
            errorMessage.setText(e.getMessage());
        }
        clearInputs();
        updateView();
    }

    @FXML
    protected void handleDeleteEquipamento(ActionEvent event) {
        System.out.println("EquipamentosController: handleDeleteEquipamento()");
        try {
            empresa.deleteEquipamentoById(
                    tabela.getSelectionModel().getSelectedItem().getId()
            );
        } catch (Exception e) {
            errorMessage.setText(e.getMessage());
        }
        clearInputs();
        updateView();
    }

}

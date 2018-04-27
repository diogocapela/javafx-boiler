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

public class PerfisAutorizacaoController extends BaseController implements Initializable {

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
    private ChoiceBox periodoAutorizacao;
    @FXML
    private Label errorMessage;

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("PerfisAutorizacaoController: initialize()");
        System.out.println("PerfisAutorizacaoController: empresa = " + empresa);

        // Populate Área Restrita ChoiceBox
        List<String> _ar = new ArrayList<>();
        for(AreaRestrita ar: empresa.getRegistoAreasRestritas()) {
            _ar.add(ar.getId() + ": "  + ar.getLocalizacao() + " " + ar.getDescricao() + " " + ar.getLotacaoMaxima());
        }
        areaRestritaId.setItems(FXCollections.observableArrayList(
                _ar
        ));

        // Populate Tipo de Movimento ChoiceBox
        periodoAutorizacao.setItems(FXCollections.observableArrayList(
                "Manhã","Tarde","Sempre"
        ));

        updateView();
    }

    private void updateView() {
        col1.setCellValueFactory(new PropertyValueFactory<>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        col3.setCellValueFactory(new PropertyValueFactory<>("areaRestritaId"));
        col4.setCellValueFactory(new PropertyValueFactory<>("periodoAutorizacao"));

        tabela.setItems(FXCollections.observableArrayList(
                empresa.getRegistoEquipamentos()
        ));
    }

    private void clearInputs() {
        id.clear();
        descricao.clear();
        areaRestritaId.getSelectionModel().clearSelection();
        periodoAutorizacao.getSelectionModel().clearSelection();
    }

    @FXML
    protected void handleAddPerfilAutorizacao(ActionEvent event) {
        System.out.println("PerfisAutorizacaoController: handleAddEquipamento()");
        try {
            empresa.addEquipamento(new Equipamento(
                    Integer.parseInt(id.getText()),
                    descricao.getText(),
                    Integer.parseInt(areaRestritaId.getValue().toString().split(":")[0]),
                    periodoAutorizacao.getValue().toString()
            ));
        } catch (Exception e) {
            errorMessage.setText(e.getMessage());
        }
        clearInputs();
        updateView();
    }

    @FXML
    protected void handleDeletePerfilAutorizacao(ActionEvent event) {
        System.out.println("PerfisAutorizacaoController: handleDeleteEquipamento()");
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

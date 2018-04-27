package com.diogocapela.javafxboiler.libs;

import com.diogocapela.javafxboiler.App;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.net.URL;

public class FxView {

    private Pane fxElement = null;

    public FxView(String fileName) {
        try {
            URL fileUrl = App.class.getResource("/views/" + fileName + ".fxml");
            if (fileUrl == null) {
                throw new java.io.FileNotFoundException("FxView: FXML file can't be found.");
            }
            fxElement = new FXMLLoader().load(fileUrl);
            //System.out.println(fileUrl);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //System.out.println(e.printStackTrace());
            //e.printStackTrace();
        }
    }

    public Pane get() {
        return fxElement;
    }

}

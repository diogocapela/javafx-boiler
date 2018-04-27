package com.diogocapela.javafxboiler;

import com.diogocapela.javafxboiler.libs.FxPage;
import com.diogocapela.javafxboiler.libs.FxPageSwitcher;
import com.diogocapela.javafxboiler.libs.FxView;

import com.diogocapela.javafxboiler.libs.Utils;
import com.diogocapela.javafxboiler.models.AreaRestrita;
import com.diogocapela.javafxboiler.models.Colaborador;
import com.diogocapela.javafxboiler.models.Empresa;

import com.diogocapela.javafxboiler.models.Equipamento;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App extends Application {

    // Static variable for the singleton pattern.
    static private App appInstance = null;

    // Static variables for the JavaFX main components.
    static private BorderPane mainPane = new BorderPane();
    static private Parent mainMenu;

    private FxPageSwitcher pageSwitcher;

    @Override
    public void start(Stage stage) {

        getAppInstance().pageSwitcher = new FxPageSwitcher((node) -> mainPane.setCenter(node), Arrays.asList(
                new FxPage("dashboard", "DashboardView"),
                new FxPage("areas_restritas", "AreasRestritasView"),
                new FxPage("colaboradores", "ColaboradoresView"),
                new FxPage("equipamentos", "EquipamentosView"),
                new FxPage("perfis_autorizacao", "PerfisAutorizacaoView")
        ));

        Empresa.getInstance();

        mainMenu = new FxView("Menu").get();
        //mainMenu.setVisible(true);
        mainPane.setLeft(mainMenu);

        Scene scene = new Scene(mainPane, 1000, 700);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("javafx-boiler");
        stage.setResizable(true);
        stage.setScene(scene);
        stage.show();

        getAppInstance().pageSwitcher.showPage("dashboard");

    }

    /**
     * Returns a signleton instance of App.
     * Do not allow more than one instance of this class.
     **/
    static private App getAppInstance() {
        if (appInstance == null) {
            appInstance = new App();
        }
        return appInstance;
    }

    static private void loadBackupAreasRestritas() {
        System.out.println("App: loadBackupAreasRestritas()");
        List<ArrayList<String>> data = Utils.getDataFromFile("./src/main/resources/database/colaboradores.txt");
        for (ArrayList<String> d : data) {
            Colaborador colaborador = new Colaborador(
                    Integer.parseInt(d.get(0)),
                    d.get(1),
                    d.get(2));
            try {
                Empresa.getInstance().addColaborador(colaborador);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static private void loadBackupColaboradores() {
        System.out.println("App: loadBackupColaboradores()");
        List<ArrayList<String>> data = Utils.getDataFromFile("./src/main/resources/database/areas_restritas.txt");
        for (ArrayList<String> d : data) {
            AreaRestrita areaRestrita = new AreaRestrita(
                    Integer.parseInt(d.get(0)),
                    d.get(1),
                    d.get(2),
                    Integer.parseInt(d.get(3))
            );
            try {
                Empresa.getInstance().addAreaRestrita(areaRestrita);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static private void loadBackupEquipamentos() {
        System.out.println("App: loadBackupEquipamentos()");
        List<ArrayList<String>> data = Utils.getDataFromFile("./src/main/resources/database/equipamentos.txt");
        for (ArrayList<String> d : data) {
            Equipamento equipamento = new Equipamento(
                    Integer.parseInt(d.get(0)),
                    d.get(1),
                    Integer.parseInt(d.get(2)),
                    d.get(3)
            );
            try {
                Empresa.getInstance().addEquipamento(equipamento);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Switches the view page on the mainPane.
     */
    static public void showPage(String page) {
        getAppInstance().pageSwitcher.showPage(page);
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    static public void main(String[] args) {
        launch(args);
    }

}

package perez.cordero.projecte_ra5_ra7.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import vicent.Bellver.MissatgesIAlertes.Alerta;
import Perez.Cordero.Fitxers;

import java.util.ArrayList;

public class LoginController {

    @FXML
    private TextField txtUser;

    public void login() {

        Fitxers f = new Fitxers("fitxers/usuaris.dat");
        ArrayList<String> usuaris = (ArrayList<String>) f.llegirObjecte();

        if (usuaris == null || !usuaris.contains(txtUser.getText())) {
            new Alerta().alertaError("Error", null, "Usuari incorrecte");
            return;
        }

        new Alerta().alertaInformacio("Info", null, "Login correcte");

        ((Stage) txtUser.getScene().getWindow()).close();
        obrirMenu();
    }

    private void obrirMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/perez/cordero/projecte_ra5_ra7/fxml/menu.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Menu");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package perez.cordero.projecte_ra5_ra7.controllers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import missatges.MissatgesIAlertes;
import fitxers.Fitxers;

import java.util.ArrayList;

public class LoginController {

    @FXML
    private TextField txtUser;

    public void login() {

        ArrayList<String> usuaris =
                (ArrayList<String>) Fitxers.llegirObjecte("fitxers/usuaris.dat");

        if (usuaris == null || !usuaris.contains(txtUser.getText())) {
            MissatgesIAlertes.mostrarError("Usuari incorrecte");
            return;
        }

        MissatgesIAlertes.mostrarInfo("Login correcte");

        obrirMenu();
    }

    private void obrirMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/menu.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Menu");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
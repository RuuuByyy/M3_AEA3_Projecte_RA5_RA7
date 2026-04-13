package perez.cordero.projecte_ra5_ra7.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import perez.cordero.projecte_ra5_ra7.utils.GestioFitxers;
import vicent.Bellver.MissatgesIAlertes.Alerta;

import java.util.HashMap;

// Controlador del login
// Valida l'usuari i la contrasenya llegint del fitxer binari usuaris.dat
public class LoginController {

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    // S'executa automaticament quan es carrega el login
    // Si no existeix cap usuari, crea l'usuari per defecte admin/admin
    @FXML
    public void initialize() {
        HashMap<String, String> usuaris = GestioFitxers.llegirUsuaris();
        if (usuaris.isEmpty()) {
            GestioFitxers.guardarUsuari("admin", "admin");
        }
    }

    // Comprova si l'usuari i la contrasenya son correctes
    public void login() {
        HashMap<String, String> usuaris = GestioFitxers.llegirUsuaris();

        String user = txtUser.getText();
        String pass = txtPassword.getText();

        if (!usuaris.containsKey(user) || !usuaris.get(user).equals(pass)) {
            new Alerta().alertaError("Error", null, "Usuari o contrasenya incorrecte");
            return;
        }

        new Alerta().alertaInformacio("Info", null, "Login correcte");
        ((Stage) txtUser.getScene().getWindow()).close();
        obrirMenu();
    }

    // Obre el formulari per registrar un nou usuari
    public void obrirRegistre() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/perez/cordero/projecte_ra5_ra7/fxml/registre.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Registre d'usuari");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Obre la finestra del menu principal
    private void obrirMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/perez/cordero/projecte_ra5_ra7/fxml/menu.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Menu");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
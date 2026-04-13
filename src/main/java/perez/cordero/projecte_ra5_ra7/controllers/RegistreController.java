package perez.cordero.projecte_ra5_ra7.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import perez.cordero.projecte_ra5_ra7.utils.GestioFitxers;
import vicent.Bellver.MissatgesIAlertes.Alerta;

import java.util.HashMap;

// Controlador del formulari de registre d'usuari nou
// Guarda l'usuari al fitxer binari usuaris.dat
public class RegistreController {

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    // Guarda el nou usuari al fitxer binari
    public void registrar() {
        String user = txtUser.getText().trim();
        String pass = txtPassword.getText().trim();

        // Comprovem que els camps no estiguin buits
        if (user.isEmpty() || pass.isEmpty()) {
            new Alerta().alertaError("Error", null, "Omple tots els camps");
            return;
        }

        // Comprovem que l'usuari no existeixi ja
        HashMap<String, String> usuaris = GestioFitxers.llegirUsuaris();
        if (usuaris.containsKey(user)) {
            new Alerta().alertaError("Error", null, "Aquest usuari ja existeix");
            return;
        }

        // Guardem el nou usuari al fitxer binari
        GestioFitxers.guardarUsuari(user, pass);

        new Alerta().alertaInformacio("OK", null, "Usuari '" + user + "' registrat correctament");

        // Tanquem la finestra de registre
        ((Stage) txtUser.getScene().getWindow()).close();
    }
}

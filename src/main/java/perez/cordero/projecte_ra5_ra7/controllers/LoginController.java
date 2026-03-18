package perez.cordero.projecte_ra5_ra7.controllers;

// Importaciones de JavaFX para la gestión de escenas, ventanas y componentes
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
// Importación de alertas personalizadas y gestión de ficheros externa
import vicent.Bellver.MissatgesIAlertes.Alerta;
import Perez.Cordero.Fitxers;

import java.util.HashMap;

/**
 * Controlador de la pantalla de Login.
 * Gestiona la autenticación de usuarios leyendo de un archivo binario.
 */
public class LoginController {

    // Campo de texto vinculado al FXML donde el usuario escribe su nombre
    @FXML
    private TextField txtUser;

    // Campo de contraseña vinculado al FXML
    @FXML
    private PasswordField txtPassword;

    /**
     * Método principal de validación de usuario y contraseña.
     */
    public void login() {

        // Instanciamos el manejador de ficheros apuntando al archivo de usuarios
        Fitxers f = new Fitxers("fitxers/usuaris.dat");

        // Leemos el objeto del archivo y hacemos un casting a HashMap de usuario-contraseña
        HashMap<String, String> usuaris = (HashMap<String, String>) f.llegirObjecte();

        String user = txtUser.getText();
        String pass = txtPassword.getText();

        // Verificamos si el mapa está vacío, el usuario no existe, o la contraseña no coincide
        if (usuaris == null || !usuaris.containsKey(user) || !usuaris.get(user).equals(pass)) {
            new Alerta().alertaError("Error", null, "Usuari o contrasenya incorrecte");
            return; // Cortamos la ejecución si los datos son erróneos
        }

        // Si el usuario existe, mostramos mensaje de éxito
        new Alerta().alertaInformacio("Info", null, "Login correcte");

        // Obtenemos la ventana actual (Stage) a través del componente txtUser y la cerramos
        ((Stage) txtUser.getScene().getWindow()).close();

        // Llamamos al método para cargar la siguiente pantalla
        obrirMenu();
    }

    /**
     * Método auxiliar para cargar y mostrar la ventana principal del menú.
     */
    private void obrirMenu() {
        try {
            // Cargamos el nuevo archivo FXML del menú
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/perez/cordero/projecte_ra5_ra7/fxml/menu.fxml"));

            // Creamos un nuevo escenario (ventana)
            Stage stage = new Stage();

            // Creamos la escena con el contenido del FXML y la asignamos al escenario
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Menu");

            // Mostramos la nueva ventana
            stage.show();
        } catch (Exception e) {
            // Imprimimos el error en consola en caso de que falle la carga del FXML
            e.printStackTrace();
        }
    }
}
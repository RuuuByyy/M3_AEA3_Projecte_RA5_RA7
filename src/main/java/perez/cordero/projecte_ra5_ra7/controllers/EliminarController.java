package perez.cordero.projecte_ra5_ra7.controllers;

// Importaciones de JavaFX para la interfaz y de utilidades propias para la lógica
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import vicent.Bellver.MissatgesIAlertes.Alerta;
import perez.cordero.projecte_ra5_ra7.utils.GestioFitxers;

/**
 * Controlador para la pantalla de eliminación de animales.
 * Se encarga de buscar un animal por su nombre y borrarlo de los registros.
 */
public class EliminarController {

    // Vinculamos el campo de texto del FXML donde el usuario escribe el nombre a borrar
    @FXML
    private TextField txtNom;

    /**
     * Método que se activa al hacer clic en el botón de eliminar.
     */
    public void eliminar() {

        // Recuperamos el nombre introducido por el usuario en el TextField
        String nom = txtNom.getText();

        // Llamamos al método estático de la clase de utilidad GestioFitxers.
        // Como no sabemos de qué tipo es el animal, el programa intenta borrarlo
        // en cada uno de los archivos específicos de cada especie.
        GestioFitxers.eliminarAnimal(nom, "fitxers/vaques.dat");
        GestioFitxers.eliminarAnimal(nom, "fitxers/gallines.dat");
        GestioFitxers.eliminarAnimal(nom, "fitxers/polps.dat");
        GestioFitxers.eliminarAnimal(nom, "fitxers/peixos.dat");

        // Una vez ejecutados los procesos de borrado, mostramos un mensaje de confirmación
        new Alerta().alertaInformacio("Info", null, "Animal eliminat");
    }
}
package perez.cordero.projecte_ra5_ra7.controllers;

// Importamos todas las clases del paquete classes (Vaca, Gallina, etc.)
import perez.cordero.projecte_ra5_ra7.classes.*;
// Importaciones de JavaFX para manejar los componentes de la interfaz
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
// Importaciones de utilidades externas para alertas, archivos y códigos QR
import vicent.Bellver.MissatgesIAlertes.Alerta;
import perez.cordero.projecte_ra5_ra7.utils.GestioFitxers;
import perez.cordero.projecte_ra5_ra7.utils.QRUtils;

/**
 * Controlador para la vista de creación de animales.
 * Se encarga de recoger los datos del formulario y generar el objeto correspondiente.
 */
public class CrearController {

    // La anotación @FXML vincula estas variables con los IDs definidos en el archivo .fxml
    @FXML private TextField txtNom;   // Cuadro de texto para el nombre
    @FXML private TextField txtEdat;  // Cuadro de texto para la edad
    @FXML private ComboBox<String> combo; // Desplegable para elegir el tipo de animal

    /**
     * Método que se ejecuta al pulsar el botón "Crear" en la interfaz.
     */
    public void crear() {

        // Extraemos los valores de los componentes de la interfaz
        String nom = txtNom.getText();
        // Convertimos el texto de la edad a un número entero (casting/parsing)
        int edat = Integer.parseInt(txtEdat.getText());
        String tipus = combo.getValue();

        // Declaramos una variable de tipo Animal (la clase padre)
        Animal a = null;

        // Aplicamos Polimorfismo: según el String seleccionado, instanciamos una clase hija u otra
        switch (tipus) {
            case "VACA": a = new Vaca(nom, edat); break;
            case "GALLINA": a = new Gallina(nom, edat); break;
            case "POLP": a = new Polp(nom, edat); break;
            case "PEIX": a = new Peix(nom, edat); break;
        }

        // Guardamos el objeto animal en un archivo (Persistencia)
        GestioFitxers.guardarAnimal(a);

        // Generamos un código QR basado en la información del animal creado
        QRUtils.generaCodiQR(a);

        // Mostramos una ventana emergente confirmando que la operación ha tenido éxito
        new Alerta().alertaInformacio("Info", null, "Creat correctament");
    }
}
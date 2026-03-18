package perez.cordero.projecte_ra5_ra7.controllers;

// Importaciones de las clases de modelo, componentes de JavaFX y utilidades de archivos
import perez.cordero.projecte_ra5_ra7.classes.Animal;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import perez.cordero.projecte_ra5_ra7.utils.GestioFitxers;

import java.io.File;
import java.util.ArrayList;

/**
 * Controlador para la vista de listado y filtrado de animales.
 * Permite ver la información guardada y el código QR asociado a cada animal.
 */
public class MostrarController {

    @FXML private ComboBox<String> comboFiltre; // Desplegable para filtrar por especie
    @FXML private ListView<String> listView;   // Lista visual para mostrar los datos de los animales
    @FXML private ImageView imgQR;             // Contenedor para mostrar la imagen del código QR

    // Lista interna para mantener los objetos Animal cargados y sincronizados con lo que se ve
    private ArrayList<Animal> mostrats = new ArrayList<>();

    /**
     * El método initialize se ejecuta automáticamente al cargar el FXML.
     * Sirve para configurar el estado inicial de los componentes.
     */
    public void initialize() {

        // Rellenamos el ComboBox con las opciones de filtrado
        comboFiltre.getItems().addAll("Tots", "Vaques", "Gallines", "Polps", "Peixos");
        comboFiltre.setValue("Tots");

        // Cada vez que el usuario cambie la selección del combo, se ejecuta el método filtrar()
        comboFiltre.setOnAction(e -> filtrar());

        // Carga inicial de todos los animales al abrir la ventana
        filtrar();

        // Listener: Detecta cuándo el usuario hace clic en un elemento de la lista (ListView)
        listView.getSelectionModel().selectedIndexProperty().addListener((obs, oldVal, newVal) -> {
            int index = newVal.intValue(); // Obtenemos el índice del elemento seleccionado

            // Si el índice es válido, buscamos el animal correspondiente y cargamos su QR
            if (index >= 0 && index < mostrats.size()) {
                Animal a = mostrats.get(index);
                // Buscamos el archivo de imagen que debe llamarse igual que el animal
                File qr = new File("fitxers/codisQR/" + a.getNom() + ".png");

                if (qr.exists()) {
                    // Si la imagen existe, la cargamos en el ImageView
                    imgQR.setImage(new Image(qr.toURI().toString()));
                } else {
                    // Si no hay QR, limpiamos el visor de imagen
                    imgQR.setImage(null);
                }
            }
        });
    }

    /**
     * Método encargado de leer los archivos .dat y actualizar la lista visual según el filtro.
     */
    private void filtrar() {
        // Limpiamos los datos actuales para no duplicarlos
        mostrats.clear();
        listView.getItems().clear();
        imgQR.setImage(null);

        String filtre = comboFiltre.getValue();

        // Según el filtro seleccionado, leemos unos archivos u otros usando GestioFitxers
        if (filtre.equals("Tots") || filtre.equals("Vaques"))
            mostrats.addAll(GestioFitxers.llegir("fitxers/vaques.dat"));
        if (filtre.equals("Tots") || filtre.equals("Gallines"))
            mostrats.addAll(GestioFitxers.llegir("fitxers/gallines.dat"));
        if (filtre.equals("Tots") || filtre.equals("Polps"))
            mostrats.addAll(GestioFitxers.llegir("fitxers/polps.dat"));
        if (filtre.equals("Tots") || filtre.equals("Peixos"))
            mostrats.addAll(GestioFitxers.llegir("fitxers/peixos.dat"));

        // Recorremos la lista de objetos cargados y añadimos su representación (toString) al ListView
        for (Animal a : mostrats) {
            listView.getItems().add(a.toString());
        }
    }
}
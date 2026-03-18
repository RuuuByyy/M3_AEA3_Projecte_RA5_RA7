package perez.cordero.projecte_ra5_ra7.controllers;

// Importaciones de JavaFX y de tus clases personalizadas
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import perez.cordero.projecte_ra5_ra7.classes.*;
import perez.cordero.projecte_ra5_ra7.utils.GestioFitxers;
import vicent.Bellver.MissatgesIAlertes.Alerta;

import java.util.ArrayList;

/**
 * Controlador para la pantalla de "Probar Métodos".
 * Aquí es donde se ejecutan las acciones de la interfaz AccionsAnimals sobre los objetos.
 */
public class ProvarController {

    @FXML private ComboBox<String> comboAnimals; // Desplegable para elegir qué animal probar
    @FXML private Label lblVitalitat;            // Etiqueta para mostrar la vida actual
    @FXML private Label lblResultat;             // Etiqueta para mostrar el log de la acción
    @FXML private Button btnMunyir;              // Botón especial que solo sirve para vacas

    // Lista que contendrá todos los objetos cargados de los diferentes ficheros .dat
    private ArrayList<Animal> tots = new ArrayList<>();

    /**
     * Al iniciar, cargamos todos los animales de todos los archivos en una sola lista.
     */
    public void initialize() {
        tots.addAll(GestioFitxers.llegir("fitxers/vaques.dat"));
        tots.addAll(GestioFitxers.llegir("fitxers/gallines.dat"));
        tots.addAll(GestioFitxers.llegir("fitxers/polps.dat"));
        tots.addAll(GestioFitxers.llegir("fitxers/peixos.dat"));

        // Rellenamos el ComboBox con el nombre y tipo de cada animal cargado
        for (Animal a : tots) {
            comboAnimals.getItems().add(a.getNom() + " (" + a.getTipus() + ")");
        }

        // Definimos que al seleccionar un elemento del combo se ejecute seleccionarAnimal()
        comboAnimals.setOnAction(e -> seleccionarAnimal());
    }

    /**
     * Método auxiliar para obtener el objeto Animal correspondiente a la selección del ComboBox.
     */
    private Animal getAnimalSeleccionat() {
        int index = comboAnimals.getSelectionModel().getSelectedIndex();
        if (index < 0) return null;
        return tots.get(index);
    }

    /**
     * Gestiona qué botones se muestran según el tipo de animal seleccionado.
     */
    private void seleccionarAnimal() {
        Animal a = getAnimalSeleccionat();
        if (a == null) return;

        // Uso de 'instanceof': el botón de ordeñar solo es visible si el animal es una Vaca.
        btnMunyir.setVisible(a instanceof Vaca);
        actualitzarVitalitat(a);
        lblResultat.setText(""); // Limpiamos mensajes anteriores
    }

    /**
     * Actualiza el texto de la etiqueta de vitalidad en la UI.
     */
    private void actualitzarVitalitat(Animal a) {
        lblVitalitat.setText("Vitalitat: " + a.getVitalitat() + "/100");
    }

    // --- MÉTODOS DE ACCIÓN ---
    // En estos métodos se aplica un casting a (AccionsAnimals) para poder llamar
    // a los métodos de la interfaz, ya que la referencia 'a' es de tipo Animal.

    public void caminar() {
        Animal a = getAnimalSeleccionat();
        if (a == null) return;
        int punts = ((AccionsAnimals) a).caminar();
        lblResultat.setText(a.getNom() + " camina! (" + punts + " vitalitat)");
        actualitzarVitalitat(a);
    }

    public void nadar() {
        Animal a = getAnimalSeleccionat();
        if (a == null) return;
        int punts = ((AccionsAnimals) a).nadar();
        lblResultat.setText(a.getNom() + " nada! (" + punts + " vitalitat)");
        actualitzarVitalitat(a);
    }

    public void volar() {
        Animal a = getAnimalSeleccionat();
        if (a == null) return;
        int punts = ((AccionsAnimals) a).volar();
        lblResultat.setText(a.getNom() + " vola! (" + punts + " vitalitat)");
        actualitzarVitalitat(a);
    }

    public void ferSo() {
        Animal a = getAnimalSeleccionat();
        if (a == null) return;
        // Aquí se aplica polimorfismo: cada animal responderá con su propio sonido.
        lblResultat.setText(a.getNom() + " fa: " + a.ferSo());
    }

    public void descansar() {
        Animal a = getAnimalSeleccionat();
        if (a == null) return;
        int recuperat = a.descansar();
        lblResultat.setText(a.getNom() + " descansa! (+" + recuperat + " vitalitat)");
        actualitzarVitalitat(a);
    }

    /**
     * Acción específica para la clase Vaca.
     */
    public void munyir() {
        Animal a = getAnimalSeleccionat();
        // Verificamos por seguridad que sea una vaca antes de hacer el casting.
        if (a == null || !(a instanceof Vaca)) return;

        // Casting de Animal a Vaca para acceder al método munyir() y getLlet()
        Vaca v = (Vaca) a;
        int punts = v.munyir();
        lblResultat.setText(v.getNom() + " munyida! +" + punts + " llet (Total: " + v.getLlet() + ")");
    }
}
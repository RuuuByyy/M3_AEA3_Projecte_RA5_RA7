package perez.cordero.projecte_ra5_ra7.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import perez.cordero.projecte_ra5_ra7.classes.*;
import perez.cordero.projecte_ra5_ra7.utils.GestioFitxers;
import vicent.Bellver.MissatgesIAlertes.Alerta;

import java.util.ArrayList;

public class ProvarController {

    @FXML private ComboBox<String> comboAnimals;
    @FXML private Label lblVitalitat;
    @FXML private Label lblResultat;
    @FXML private Button btnMunyir;

    private ArrayList<Animal> tots = new ArrayList<>();

    public void initialize() {
        tots.addAll(GestioFitxers.llegir("fitxers/vaques.dat"));
        tots.addAll(GestioFitxers.llegir("fitxers/gallines.dat"));
        tots.addAll(GestioFitxers.llegir("fitxers/polps.dat"));
        tots.addAll(GestioFitxers.llegir("fitxers/peixos.dat"));

        for (Animal a : tots) {
            comboAnimals.getItems().add(a.getNom() + " (" + a.getTipus() + ")");
        }

        comboAnimals.setOnAction(e -> seleccionarAnimal());
    }

    private Animal getAnimalSeleccionat() {
        int index = comboAnimals.getSelectionModel().getSelectedIndex();
        if (index < 0) return null;
        return tots.get(index);
    }

    private void seleccionarAnimal() {
        Animal a = getAnimalSeleccionat();
        if (a == null) return;
        btnMunyir.setVisible(a instanceof Vaca);
        actualitzarVitalitat(a);
        lblResultat.setText("");
    }

    private void actualitzarVitalitat(Animal a) {
        lblVitalitat.setText("Vitalitat: " + a.getVitalitat() + "/100");
    }

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
        lblResultat.setText(a.getNom() + " fa: " + a.ferSo());
    }

    public void descansar() {
        Animal a = getAnimalSeleccionat();
        if (a == null) return;
        int recuperat = a.descansar();
        lblResultat.setText(a.getNom() + " descansa! (+" + recuperat + " vitalitat)");
        actualitzarVitalitat(a);
    }

    public void munyir() {
        Animal a = getAnimalSeleccionat();
        if (a == null || !(a instanceof Vaca)) return;
        Vaca v = (Vaca) a;
        int punts = v.munyir();
        lblResultat.setText(v.getNom() + " munyida! +" + punts + " llet (Total: " + v.getLlet() + ")");
    }
}

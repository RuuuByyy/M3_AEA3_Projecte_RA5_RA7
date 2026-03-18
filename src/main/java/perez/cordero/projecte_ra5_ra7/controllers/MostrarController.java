package perez.cordero.projecte_ra5_ra7.controllers;

import perez.cordero.projecte_ra5_ra7.classes.Animal;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import perez.cordero.projecte_ra5_ra7.utils.GestioFitxers;

import java.io.File;
import java.util.ArrayList;

public class MostrarController {

    @FXML private ComboBox<String> comboFiltre;
    @FXML private ListView<String> listView;
    @FXML private ImageView imgQR;

    private ArrayList<Animal> mostrats = new ArrayList<>();

    public void initialize() {

        comboFiltre.getItems().addAll("Tots", "Vaques", "Gallines", "Polps", "Peixos");
        comboFiltre.setValue("Tots");
        comboFiltre.setOnAction(e -> filtrar());

        filtrar();

        listView.getSelectionModel().selectedIndexProperty().addListener((obs, oldVal, newVal) -> {
            int index = newVal.intValue();
            if (index >= 0 && index < mostrats.size()) {
                Animal a = mostrats.get(index);
                File qr = new File("fitxers/codisQR/" + a.getNom() + ".png");
                if (qr.exists()) {
                    imgQR.setImage(new Image(qr.toURI().toString()));
                } else {
                    imgQR.setImage(null);
                }
            }
        });
    }

    private void filtrar() {
        mostrats.clear();
        listView.getItems().clear();
        imgQR.setImage(null);

        String filtre = comboFiltre.getValue();

        if (filtre.equals("Tots") || filtre.equals("Vaques"))
            mostrats.addAll(GestioFitxers.llegir("fitxers/vaques.dat"));
        if (filtre.equals("Tots") || filtre.equals("Gallines"))
            mostrats.addAll(GestioFitxers.llegir("fitxers/gallines.dat"));
        if (filtre.equals("Tots") || filtre.equals("Polps"))
            mostrats.addAll(GestioFitxers.llegir("fitxers/polps.dat"));
        if (filtre.equals("Tots") || filtre.equals("Peixos"))
            mostrats.addAll(GestioFitxers.llegir("fitxers/peixos.dat"));

        for (Animal a : mostrats) {
            listView.getItems().add(a.toString());
        }
    }
}
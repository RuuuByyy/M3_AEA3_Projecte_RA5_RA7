package perez.cordero.projecte_ra5_ra7.controllers;

import perez.cordero.projecte_ra5_ra7.classes.Animal;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import perez.cordero.projecte_ra5_ra7.utils.GestioFitxers;

import java.util.ArrayList;

public class MostrarController {

    @FXML
    private ListView<String> listView;

    public void initialize() {

        ArrayList<Animal> tots = new ArrayList<>();

        tots.addAll(GestioFitxers.llegir("fitxers/vaques.dat"));
        tots.addAll(GestioFitxers.llegir("fitxers/gallines.dat"));
        tots.addAll(GestioFitxers.llegir("fitxers/polps.dat"));
        tots.addAll(GestioFitxers.llegir("fitxers/peixos.dat"));

        for (Animal a : tots) {
            listView.getItems().add(a.toString());
        }
    }
}
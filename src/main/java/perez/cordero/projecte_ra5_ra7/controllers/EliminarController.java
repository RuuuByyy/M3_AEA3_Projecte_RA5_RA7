package perez.cordero.projecte_ra5_ra7.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import vicent.Bellver.MissatgesIAlertes.Alerta;
import perez.cordero.projecte_ra5_ra7.utils.GestioFitxers;

public class EliminarController {

    @FXML
    private TextField txtNom;

    public void eliminar() {

        String nom = txtNom.getText();

        GestioFitxers.eliminarAnimal(nom, "fitxers/vaques.dat");
        GestioFitxers.eliminarAnimal(nom, "fitxers/gallines.dat");
        GestioFitxers.eliminarAnimal(nom, "fitxers/polps.dat");
        GestioFitxers.eliminarAnimal(nom, "fitxers/peixos.dat");

        new Alerta().alertaInformacio("Info", null, "Animal eliminat");
    }
}
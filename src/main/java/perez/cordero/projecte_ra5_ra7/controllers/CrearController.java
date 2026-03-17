package perez.cordero.projecte_ra5_ra7.controllers;


import perez.cordero.projecte_ra5_ra7.classes.*;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import vicent.Bellver.MissatgesIAlertes,*;
import perez.cordero.projecte_ra5_ra7.utils.GestioFitxers;
import perez.cordero.projecte_ra5_ra7.utils.QRUtils;

public class CrearController {

    @FXML private TextField txtNom;
    @FXML private TextField txtEdat;
    @FXML private ComboBox<String> combo;

    public void crear() {

        String nom = txtNom.getText();
        int edat = Integer.parseInt(txtEdat.getText());
        String tipus = combo.getValue();

        Animal a = null;

        switch (tipus) {
            case "VACA": a = new Vaca(nom, edat); break;
            case "GALLINA": a = new Gallina(nom, edat); break;
            case "POLP": a = new Polp(nom, edat); break;
            case "PEIX": a = new Peix(nom, edat); break;
        }

        GestioFitxers.guardarAnimal(a);
        QRUtils.generarQR(a);

        MissatgesIAlertes.mostrarInfo("Creat correctament");
    }
}
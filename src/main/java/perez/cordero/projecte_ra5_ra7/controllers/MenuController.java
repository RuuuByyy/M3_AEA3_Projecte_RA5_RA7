package perez.cordero.projecte_ra5_ra7.controllers;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuController {

    private void Fgeneric(String ruta, String titol) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle(titol);
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void crearAnimal() {
        Fgeneric("/perez/cordero/projecte_ra5_ra7/fxml/crear.fxml", "Crear Animal");
    }

    public void mostrarAnimals() {
        Fgeneric("/perez/cordero/projecte_ra5_ra7/fxml/mostrar.fxml", "Mostrar Animals");
    }

    public void eliminarAnimal() {
        Fgeneric("/perez/cordero/projecte_ra5_ra7/fxml/eliminar.fxml", "Eliminar Animal");
    }

    public void provarMetodes() {
        Fgeneric("/perez/cordero/projecte_ra5_ra7/fxml/provar.fxml", "Provar Mètodes");
    }
}
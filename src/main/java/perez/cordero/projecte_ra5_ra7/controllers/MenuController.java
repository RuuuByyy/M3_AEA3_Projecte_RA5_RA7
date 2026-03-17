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
        Fgeneric("/fxml/crear.fxml", "Crear Animal");
    }

    public void mostrarAnimals() {
        Fgeneric("/fxml/mostrar.fxml", "Mostrar Animals");
    }

    public void eliminarAnimal() {
        Fgeneric("/fxml/eliminar.fxml", "Eliminar Animal");
    }
}
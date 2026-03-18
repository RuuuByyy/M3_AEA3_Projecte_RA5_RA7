package perez.cordero.projecte_ra5_ra7.controllers;

// Importaciones necesarias para cargar archivos FXML y gestionar las ventanas (Stages)
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Controlador para la ventana del Menú Principal.
 * Gestiona la navegación hacia las diferentes funcionalidades de la aplicación.
 */
public class MenuController {

    /**
     * Método genérico para abrir nuevas ventanas (Refactorización).
     * En lugar de repetir el código de carga en cada botón, pasamos la ruta y el título como parámetros.
     * @param ruta Camino al archivo .fxml
     * @param titol Texto que aparecerá en la barra superior de la ventana
     */
    private void Fgeneric(String ruta, String titol) {

        try {
            // Preparamos el cargador con la ruta del recurso FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
            // Cargamos el diseño (el nodo raíz de la vista)
            Parent root = loader.load();

            // Creamos una nueva ventana (Stage) independiente
            Stage stage = new Stage();
            // Asignamos el título personalizado
            stage.setTitle(titol);
            // Creamos la escena con el diseño cargado y la ponemos en la ventana
            stage.setScene(new Scene(root));
            // Mostramos la ventana al usuario
            stage.show();

        } catch (Exception e) {
            // Si hay un error (archivo no encontrado, error en el FXML...), lo muestra en la consola
            e.printStackTrace();
        }
    }

    /**
     * Se ejecuta al pulsar el botón de crear. Llama al método genérico con la vista de creación.
     */
    public void crearAnimal() {
        Fgeneric("/perez/cordero/projecte_ra5_ra7/fxml/crear.fxml", "Crear Animal");
    }

    /**
     * Se ejecuta al pulsar el botón de visualizar. Abre la ventana del listado.
     */
    public void mostrarAnimals() {
        Fgeneric("/perez/cordero/projecte_ra5_ra7/fxml/mostrar.fxml", "Mostrar Animals");
    }

    /**
     * Se ejecuta al pulsar el botón de borrado. Abre la ventana para eliminar registros.
     */
    public void eliminarAnimal() {
        Fgeneric("/perez/cordero/projecte_ra5_ra7/fxml/eliminar.fxml", "Eliminar Animal");
    }

    /**
     * Se ejecuta al pulsar el botón de pruebas. Abre la ventana para testear los comportamientos.
     */
    public void provarMetodes() {
        Fgeneric("/perez/cordero/projecte_ra5_ra7/fxml/provar.fxml", "Provar Mètodes");
    }
}
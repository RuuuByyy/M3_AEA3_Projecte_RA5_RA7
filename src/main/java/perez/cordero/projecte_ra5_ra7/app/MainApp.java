package perez.cordero.projecte_ra5_ra7.app;

// Importaciones necesarias para manejar la interfaz gráfica, el cargador de FXML y los contenedores
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal que inicia la aplicación JavaFX.
 * Hereda de Application para gestionar el ciclo de vida de la ventana.
 */
public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Instanciamos el cargador para el archivo FXML que contiene el diseño de la interfaz
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/perez/cordero/projecte_ra5_ra7/fxml/login.fxml"));

        // Creamos la escena principal cargando el contenido del archivo FXML
        Scene scene = new Scene(fxmlLoader.load());

        // Configuramos el título que aparecerá en la barra superior de la ventana
        stage.setTitle("Minecraft DAM1");

        // Asignamos la escena al escenario (la ventana principal)
        stage.setScene(scene);

        // Hacemos visible la ventana al usuario
        stage.show();
    }

    public static void main(String[] args) {
        // Método estático que lanza la aplicación y ejecuta internamente el método start()
        launch();
    }
}
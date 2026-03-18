module perez.cordero.projecte_ra5_ra7 {
    // Declaramos qué módulos de JavaFX necesita nuestro proyecto para funcionar.
    // 'controls' es para los componentes visuales (botones, listas) y 'fxml' para cargar los diseños.
    requires javafx.controls;
    requires javafx.fxml;

    // Indicamos las dependencias de librerías externas (archivos .jar).
    // Sin estas líneas, Java no encontraría las clases de gestión de ficheros, alertas o QR.
    requires Llibreria.Fitxers.master.SNAPSHOT;
    requires missatges.i.alertes;
    requires com.google.zxing;
    requires com.google.zxing.javase;

    // 'opens' permite que JavaFX (que es un módulo externo) acceda por "reflexión"
    // a nuestros controladores y clases. Es obligatorio para que @FXML funcione.
    opens perez.cordero.projecte_ra5_ra7.controllers to javafx.fxml;
    opens perez.cordero.projecte_ra5_ra7.classes;
    opens perez.cordero.projecte_ra5_ra7.utils;

    // 'exports' hace que nuestros paquetes sean visibles para otros módulos.
    // Si no exportamos el paquete 'app', JavaFX no podrá ejecutar la clase MainApp.
    exports perez.cordero.projecte_ra5_ra7.app;
    exports perez.cordero.projecte_ra5_ra7.classes;
    exports perez.cordero.projecte_ra5_ra7.controllers;
    exports perez.cordero.projecte_ra5_ra7.utils;
}
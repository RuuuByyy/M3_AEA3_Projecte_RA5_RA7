module perez.cordero.projecte_ra5_ra7 {
    requires javafx.controls;
    requires javafx.fxml;

    requires Llibreria.Fitxers.master.SNAPSHOT;
    requires missatges.i.alertes;
    requires com.google.zxing;
    requires com.google.zxing.javase;

    opens perez.cordero.projecte_ra5_ra7.controllers to javafx.fxml;
    opens perez.cordero.projecte_ra5_ra7.classes;
    opens perez.cordero.projecte_ra5_ra7.utils;

    exports perez.cordero.projecte_ra5_ra7.app;
    exports perez.cordero.projecte_ra5_ra7.classes;
    exports perez.cordero.projecte_ra5_ra7.controllers;
    exports perez.cordero.projecte_ra5_ra7.utils;
}
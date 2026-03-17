module app {
    requires javafx.controls;
    requires javafx.fxml;

    requires fitxers;
    requires missatges;
    requires com.google.zxing;
    requires com.google.zxing.javase;

    opens controllers to javafx.fxml;
    opens classes;

    exports app;
}
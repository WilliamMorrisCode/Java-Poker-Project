module com.example.williammorrisscenebuilderpractice {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.williammorrisscenebuilderpractice to javafx.fxml;
    exports com.example.williammorrisscenebuilderpractice;
}
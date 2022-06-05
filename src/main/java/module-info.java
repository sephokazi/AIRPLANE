module com.example.aeroplane {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aeroplane to javafx.fxml;
    exports com.example.aeroplane;
}
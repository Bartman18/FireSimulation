module com.example.testtow {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testtow to javafx.fxml;
    exports com.example.testtow;
    exports com.example.testtow.firetrucks;
    opens com.example.testtow.firetrucks to javafx.fxml;
}
module com.example.testtow {
    requires javafx.controls;
    requires javafx.fxml;
    requires flying.saucer.pdf;
    requires itextpdf;
    requires itext.rtf;
    requires itext;
    requires java.desktop;


    opens com.example.testtow to javafx.fxml;
    exports com.example.testtow;
    exports com.example.testtow.firetrucks;
    opens com.example.testtow.firetrucks to javafx.fxml;
    exports com.example.testtow.Fire;
    opens com.example.testtow.Fire to javafx.fxml;
}
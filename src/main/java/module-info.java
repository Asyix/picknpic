module fr.polytech.picknpic {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens fr.polytech.picknpic to javafx.fxml;
    exports fr.polytech.picknpic;
}
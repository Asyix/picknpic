module fr.polytech.picknpic {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens fr.polytech.picknpic to javafx.fxml;
    opens fr.polytech.picknpic.ui to javafx.fxml;
    exports fr.polytech.picknpic;
    exports fr.polytech.picknpic.ui;
    exports fr.polytech.picknpic.bl;
    exports fr.polytech.picknpic.persist;
}
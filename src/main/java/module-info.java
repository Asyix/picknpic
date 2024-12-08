module fr.polytech.picknpic {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens fr.polytech.picknpic to javafx.fxml;
    exports fr.polytech.picknpic;
    exports fr.polytech.picknpic.login;
}
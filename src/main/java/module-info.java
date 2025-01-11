module fr.polytech.picknpic {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens fr.polytech.picknpic to javafx.fxml;
    opens fr.polytech.picknpic.ui to javafx.fxml;
    exports fr.polytech.picknpic;
    exports fr.polytech.picknpic.ui;
    //exports fr.polytech.picknpic.bl;
    exports fr.polytech.picknpic.persist;
    exports fr.polytech.picknpic.persist.daos;
    exports fr.polytech.picknpic.persist.postgres;
    //remove comments if a class is added here
    //exports fr.polytech.picknpic.bl.facades;
    exports fr.polytech.picknpic.bl.models;
    exports fr.polytech.picknpic.ui.controllers;
    opens fr.polytech.picknpic.ui.controllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.RequestControllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.ServiceControllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.GradeControllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.SubscriptionControllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.NotificationControllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.PhotoControllers to javafx.fxml;
    exports fr.polytech.picknpic.bl.facades.user;
    exports fr.polytech.picknpic.ui.controllers.UserControllers;
    opens fr.polytech.picknpic.ui.controllers.UserControllers to javafx.fxml;
}
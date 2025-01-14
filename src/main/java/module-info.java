module fr.polytech.picknpic {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;
    /*
    requires org.junit.jupiter.api;
    requires org.junit.jupiter.engine;
    requires org.junit.platform.commons;
    requires org.junit.platform.engine;
    */

    opens fr.polytech.picknpic to javafx.fxml;
    opens fr.polytech.picknpic.ui to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.RequestControllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.ServiceControllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.GradeControllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.SubscriptionControllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.NotificationControllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.PhotoControllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.PurchaseControllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.ChatControllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.MessageControllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.UserControllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.PostControllers to javafx.fxml;
    opens fr.polytech.picknpic.ui.controllers.CommentControllers to javafx.fxml;

    exports fr.polytech.picknpic;
    exports fr.polytech.picknpic.ui;
    exports fr.polytech.picknpic.persist;
    exports fr.polytech.picknpic.persist.daos;
    exports fr.polytech.picknpic.persist.postgres;
    exports fr.polytech.picknpic.bl.models;
    exports fr.polytech.picknpic.ui.controllers;
    exports fr.polytech.picknpic.bl.facades.user;
    exports fr.polytech.picknpic.ui.controllers.UserControllers;
}
package fr.polytech.picknpic.bl.facades.user;

import fr.polytech.picknpic.persist.AbstractFactory;

public class ManageUsersFacade {
    private static ManageUsersFacade instance;

    private final AbstractFactory abstractFactory;

    private ManageUsersFacade() { this.abstractFactory = AbstractFactory.getInstance();
    }

    public static ManageUsersFacade getInstance() {
        if (instance == null) {
            instance = new ManageUsersFacade();
        }
        return instance;
    }
}

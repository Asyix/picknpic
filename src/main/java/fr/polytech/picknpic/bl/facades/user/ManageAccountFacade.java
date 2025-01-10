package fr.polytech.picknpic.bl.facades.user;

import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.persist.AbstractFactory;

public class ManageAccountFacade {
    private static ManageAccountFacade instance;

    private final AbstractFactory abstractFactory;

    private ManageAccountFacade() {
        this.abstractFactory = AbstractFactory.getInstance();
    }

    public static ManageAccountFacade getInstance() {
        if (instance == null) {
            instance = new ManageAccountFacade();
        }
        return instance;
    }

    public boolean updateAccount(User user) {
        return abstractFactory.createUserDAO().updateAccount(user);
    }

    public boolean deleteAccount(int id, String password) {
        return abstractFactory.createUserDAO().deleteAccount(id, password);
    }
}

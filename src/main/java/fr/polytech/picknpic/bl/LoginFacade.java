package fr.polytech.picknpic.bl;
import fr.polytech.picknpic.persist.AbstractFactory;

public class LoginFacade {

    private final AbstractFactory abstractFactory;

    /**
     * Constructeur qui crée le singleton AbstractFactory.
     */
    public LoginFacade() {
        this.abstractFactory = AbstractFactory.createAbstractFactory();
    }

    public User login(String username, String password) {
        return abstractFactory.createUserDAO().login(username, password);
    }

}

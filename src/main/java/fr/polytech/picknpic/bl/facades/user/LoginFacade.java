package fr.polytech.picknpic.bl.facades.user;
import fr.polytech.picknpic.bl.models.User;
import fr.polytech.picknpic.persist.AbstractFactory;

public class LoginFacade {

    private final AbstractFactory abstractFactory;

    /**
     * Constructeur qui crée le singleton AbstractFactory.
     */
    public LoginFacade() {
        this.abstractFactory = AbstractFactory.getAbstractFactoryInstance();
    }

    public User login(String username, String password) {
        return abstractFactory.createUserDAO().login(username, password);
    }

}

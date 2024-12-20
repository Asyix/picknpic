package fr.polytech.picknpic.bl.facades.user;

import fr.polytech.picknpic.bl.models.User;

public class UserFacade {

    private final LoginFacade loginFacade;

    private static UserFacade userFacade;

    private UserFacade() {
        this.loginFacade = LoginFacade.getLoginFacadeInstance();
    }

    public static UserFacade getUserFacadeInstance() {
        if (userFacade == null) {
            userFacade = new UserFacade();
        }
        return userFacade;
    }

    public User login(String username, String password) {
        return loginFacade.login(username, password);
    }


}

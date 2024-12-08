package fr.polytech.picknpic.bl;

import fr.polytech.picknpic.persist.UserDAO;

public class LoginFacade {

    private final UserDAO userDAO;

    /**
     * Constructeur qui accepte une implémentation de UserDAO.
     *
     * @param userDAO Une instance de UserDAO pour accéder aux données utilisateur.
     */
    public LoginFacade(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * Authentifie un utilisateur.
     *
     * @param username Le nom d'utilisateur.
     * @param password Le mot de passe.
     * @return L'utilisateur authentifié, ou null si les identifiants sont incorrects.
     */
    public User login(String username, String password) {
        return userDAO.login(username, password);
    }
}

package entities;

import entities.Utilisateur;

public class UserSession {
    private Utilisateur utilisateur;
    private static UserSession instance;

    private UserSession() { }

    public static UserSession getInstance() {
        if (instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public boolean isLoggedIn() {
        return utilisateur != null;
    }

    public void clearSession() {
        this.utilisateur = null;
    }
}
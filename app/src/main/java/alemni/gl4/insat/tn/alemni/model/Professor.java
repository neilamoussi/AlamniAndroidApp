package alemni.gl4.insat.tn.alemni.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Neila Moussi on 15/02/2017.
 */

public class Professor implements Serializable {

    private String prenom;
    private String nom;


    private String email;
    private String login;
    private String password;

    public Professor(String prenom, String nom, String email, String login, String password) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

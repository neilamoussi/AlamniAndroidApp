package alemni.gl4.insat.tn.alemni.model;

import java.util.Date;

public class Quiz {


    private String nom;
    private int nbdislike;
    private Date datecreation;
    private String encours;
    private Date datelimite;
    private String heure;
    private int nblike;
    public Quiz(String nom, int nbdislike, Date datecreation, String encours, Date datelimite, String heure, int nblike) {
        super();
        this.nom = nom;
        this.nbdislike = nbdislike;
        this.datecreation = datecreation;
        this.encours = encours;
        this.datelimite = datelimite;
        this.heure = heure;
        this.nblike = nblike;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getNbdislike() {
        return nbdislike;
    }
    public void setNbdislike(int nbdislike) {
        this.nbdislike = nbdislike;
    }
    public Date getDatecreation() {
        return datecreation;
    }
    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }
    public String getEncours() {
        return encours;
    }
    public void setEncours(String encours) {
        this.encours = encours;
    }
    public Date getDatelimite() {
        return datelimite;
    }
    public void setDatelimite(Date datelimite) {
        this.datelimite = datelimite;
    }
    public String getHeure() {
        return heure;
    }
    public void setHeure(String heure) {
        this.heure = heure;
    }
    public int getNblike() {
        return nblike;
    }
    public void setNblike(int nblike) {
        this.nblike = nblike;
    }


}
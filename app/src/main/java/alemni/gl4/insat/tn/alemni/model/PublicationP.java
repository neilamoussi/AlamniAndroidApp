package alemni.gl4.insat.tn.alemni.model;

import java.util.Date;

/**
 * Created byNeila Moussi on 15/02/2017.
 */

public class PublicationP {

    private String texte;
    private Date date;

    private String heure;

    public PublicationP(String texte, Date date, String heure) {
        this.texte = texte;
        this.date = date;
        this.heure = heure;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
}
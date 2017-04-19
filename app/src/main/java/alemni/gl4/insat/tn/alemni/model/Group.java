package alemni.gl4.insat.tn.alemni.model;

/**
 * Created by Neila Moussi  on 15/02/2017.
 */

public class Group {

    private String nom;
    private String localite;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public Group(String nom, String localite) {
        this.nom = nom;
        this.localite = localite;
    }
}

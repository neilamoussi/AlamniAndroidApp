package alemni.gl4.insat.tn.alemni.model;

/**
 * Created by Nessrine on 25/03/2017.
 */

public class Matiere {

    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Matiere(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "nom='" + nom + '\'' +
                '}';
    }
}

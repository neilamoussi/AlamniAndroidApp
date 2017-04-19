package alemni.gl4.insat.tn.alemni.model;

import java.util.Date;

public class PublicationE {
    private String text;
    private String heure;
    private String date;
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getHeure() {
        return heure;
    }
    public void setHeure(String heure) {
        this.heure = heure;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public PublicationE(String text, String heure, String date) {
        super();
        this.text = text;
        this.heure = heure;
        this.date = date;
    }


}
package alemni.gl4.insat.tn.alemni.model;

import java.util.Date;

public class Comment {
    private String text;
    private Date date;
    private String heure;
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
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
    public Comment(String text, Date date, String heure) {
        super();
        this.text = text;
        this.date = date;
        this.heure = heure;
    }

}
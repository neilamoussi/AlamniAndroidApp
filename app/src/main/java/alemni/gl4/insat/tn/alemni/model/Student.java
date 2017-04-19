package alemni.gl4.insat.tn.alemni.model;


import java.io.Serializable;

public class Student implements Serializable{


        private String email;
        private String login;
        private String nom;
        private String prenom;
        private String password;
        private String accepte;
        public Student(String email, String login, String nom, String prenom, String password, String accepte) {
            super();
            this.email = email;
            this.login = login;
            this.nom = nom;
            this.prenom = prenom;
            this.password = password;
            this.accepte = accepte;
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
        public String getNom() {
            return nom;
        }
        public void setNom(String nom) {
            this.nom = nom;
        }
        public String getPrenom() {
            return prenom;
        }
        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        public String getAccepte() {
            return accepte;
        }
        public void setAccepte(String accepte) {
            this.accepte = accepte;
        }

    }
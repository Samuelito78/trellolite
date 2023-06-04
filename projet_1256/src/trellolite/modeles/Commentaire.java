package trellolite.modeles;

import java.util.Date;

public class Commentaire {
    // Attributs
    Carte carte;
    Utilisateur createurcomm;
    private String contenu;
    private Date date;

    // Constructeur
    public Commentaire(Utilisateur createurcomm, String contenu, Date date, Carte carte) {
        this.setContenu(contenu);
        this.setDate(date);
        this.createurcomm = createurcomm;
        this.carte = carte;
    }

    // Getter et Setter pour l'attribut "contenu"

    public Utilisateur getCreateurcomm(){
        return createurcomm;
    }
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    // Getter et Setter pour l'attribut "date"
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

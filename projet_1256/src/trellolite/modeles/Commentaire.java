package trellolite.modeles;
public class Commentaire {
    // Attributs
    Carte carte;
    Utilisateur createurcomm;
    private String contenu;
    private int date;

    // Constructeur
    public Commentaire(Utilisateur createurcomm, String contenu, int date, Carte carte) {
        this.setContenu(contenu);
        this.setDate(date);
        this.createurcomm = createurcomm;
        this.carte = carte;
    }

    // Getter et Setter pour l'attribut "contenu"
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    // Getter et Setter pour l'attribut "date"
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}

package trellolite.modeles;

import java.util.Date;

/**
 * La classe Commentaire représente un commentaire associé à une carte dans l'application.
 *
 * @author Samuel Boix-Segura
 */
public class Commentaire {
    // L'attribut "carte" représente la carte à laquelle le commentaire est associé
    Carte carte;
    
    // L'attribut "createurcomm" représente l'utilisateur qui a créé le commentaire
    Utilisateur createurcomm;
    
    // L'attribut "contenu" représente le contenu textuel du commentaire
    private String contenu;
    
    // L'attribut "date" représente la date de création du commentaire
    private Date date;

    /**
     * Constructeur de la classe Commentaire.
     * 
     * @param createurcomm L'utilisateur qui crée le commentaire.
     * @param contenu Le contenu textuel du commentaire.
     * @param date La date de création du commentaire.
     * @param carte La carte à laquelle le commentaire est associé.
     */
    public Commentaire(Utilisateur createurcomm, String contenu, Date date, Carte carte) {
        this.setContenu(contenu);
        this.setDate(date);
        this.createurcomm = createurcomm;
        this.carte = carte;
    }

    /**
     * Récupère l'utilisateur qui a créé le commentaire.
     * 
     * @return L'utilisateur qui a créé le commentaire.
     */
    public Utilisateur getCreateurcomm(){
        return createurcomm;
    }
    
    /**
     * Récupère le contenu du commentaire.
     * 
     * @return Le contenu du commentaire.
     */
    public String getContenu() {
        return contenu;
    }

    /**
     * Modifie le contenu du commentaire.
     * 
     * @param contenu Le nouveau contenu du commentaire.
     */
    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    /**
     * Récupère la date de création du commentaire.
     * 
     * @return La date de création du commentaire.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Modifie la date de création du commentaire.
     * 
     * @param date La nouvelle date de création du commentaire.
     */
    public void setDate(Date date) {
        this.date = date;
    }
}

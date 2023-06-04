package trellolite.modeles;

import java.util.ArrayList;

/**
 * La classe Principale représente l'entité principale de l'application Trellolite.
 * Elle contient une liste de projets.
 *
 * @author Mohamed Telli
 */
public class Principale {
    // Liste des projets
    private ArrayList<Projet> projets;

    /**
     * Constructeur de la classe Principale.
     * Initialise une liste vide de projets.
     */
    public Principale() {
        this.projets = new ArrayList<>();
    }

    /**
     * Méthode pour obtenir la liste des projets.
     *
     * @return La liste des projets.
     */
    public ArrayList<Projet> getProjets() {
        return this.projets;
    }

    /**
     * Méthode pour ajouter un projet à la liste des projets.
     *
     * @param projet Le projet à ajouter à la liste.
     */
    public void addProjet(Projet projet) {
        this.projets.add(projet);
    }
}

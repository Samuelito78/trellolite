package trellolite.controleurs;

import trellolite.modeles.NavBar;
import trellolite.modeles.NavButton;
import trellolite.modeles.Projet;
import trellolite.modeles.Utilisateur;
import trellolite.vues.NavBarVue;
import trellolite.vues.PrincipaleVue;
import trellolite.vues.ProjetVue;
import trellolite.vues.SectionVue;

import javax.swing.*;

/**
 * Le contrôleur pour la barre de navigation de l'application.
 * Cette classe gère l'interaction entre le modèle NavBar et la vue NavBarVue.
 * Elle crée et configure les boutons de la barre de navigation, ajoute des icônes et des styles à ces boutons,
 * crée une instance de NavBarVue et associe la vue du projet et le contrôleur des boutons de navigation à cette vue.
 *
 * @author Nawfel Kerarsi.
 */
public class NavBarControleur {
    private NavBar navBar;
    private NavBarVue navBarVue;
    private ProjetVue projetVue;
    private NavButtonControleur navButtonControleur;
    private Projet projet;

    /**
     * Constructeur de la classe NavBarControleur.
     * Initialise les composants de la barre de navigation et associe les vues et les contrôleurs.
     *
     * @param projetVue    La vue du projet.
     * @param sectionVue   La vue de la section.
     * @param projet       Le projet associé à la barre de navigation.
     * @param utilisateur  L'utilisateur actuel de l'application.
     */
    public NavBarControleur(ProjetVue projetVue, SectionVue sectionVue, Projet projet, Utilisateur utilisateur) {
        this.projetVue = projetVue;
        this.projet = projet;
        navBar = new NavBar();

        // Création des boutons de navigation avec leurs icônes et styles
        NavButton navButton1 = new NavButton("Tableau de bord", "src/trellolite/ressources/images/iconTable.png", true);
        NavButton navButton3 = new NavButton("Membres", "src/trellolite/ressources/images/iconUsers.png");
        NavButton navButton4 = new NavButton("Réunions", "src/trellolite/ressources/images/iconMic.png");
        NavButton navButton5 = new NavButton("Paramètres", "src/trellolite/ressources/images/iconGear.png");

        navBar.addButton(navButton1);
        navBar.addButton(navButton3);
        navBar.addButton(navButton4);
        navBar.addButton(navButton5);

        // Création du contrôleur des boutons de navigation
        navButtonControleur = new NavButtonControleur(navBar, sectionVue, projet, utilisateur, projetVue);

        // Création de la vue de la barre de navigation avec la vue du projet et le contrôleur des boutons de navigation associés
        this.navBarVue = new NavBarVue(projetVue, navButtonControleur.getVue());
    }

    /**
     * Récupère la vue de la barre de navigation.
     *
     * @return La vue de la barre de navigation.
     */
    public JPanel getVue() {
        return this.navBarVue;
    }

    /**
     * Met à jour le projet associé à la barre de navigation.
     *
     * @param projet Le nouveau projet.
     */
    public void setProjet(Projet projet) {
        navButtonControleur.setProjet(projet);
    }
}

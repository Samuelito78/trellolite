package trellolite.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import trellolite.vues.PrincipaleVue;
import trellolite.modeles.*;
import trellolite.controleurs.ProjetControleur;
import trellolite.vues.SectionVue;

/**
 * Le contrôleur pour la fenêtre principale de l'application.
 * Cette classe est responsable de la gestion de l'interaction entre le modèle Principale et la vue PrincipaleVue.
 * Elle crée et configure les boutons de la fenêtre principale, y compris le bouton de création de projet.
 * Elle écoute les événements des boutons et effectue les actions correspondantes, telles que la création d'un nouveau projet.
 * Elle gère également les changements de projet en mettant à jour les vues associées au projet actuel.
 * 
 * @author Nawfel Kerarsi
 */
public class PrincipaleControleur {
    private PrincipaleVue vue;
    private Principale modele;
    private SectionVue sectionVue;
    private JButton monBouton;
    private JButton submitButton;
    private ProjetControleur controleurProjet;
    private NavBarControleur controleurNavBar;
    private Projet projetActuel;

    /**
     * Constructeur de la classe PrincipaleControleur.
     * Crée une instance du modèle Principale et de la vue PrincipaleVue.
     * Configure les boutons de la fenêtre principale et associe les écouteurs d'événements correspondants.
     * 
     * @param modele l'instance du modèle Principale.
     */
    public PrincipaleControleur(Principale modele) {
        this.modele = modele;
        this.vue = new PrincipaleVue();

        // Création des boutons
        monBouton = new JButton("Crée un projet");
        submitButton = new JButton("Créer le projet");

        monBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vue.showForm(submitButton);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = vue.getNom();
                String type = vue.getType();
                String description = vue.getDescription();
                Projet projet = new Projet(nom, type, description);
                modele.addProjet(projet);
                sectionVue = new SectionVue();
                Role administrateur = Role.administrateur;
                Role membre = Role.membre;
                Role spectateur = Role.spectateur;
                Utilisateur utilisateur = new Utilisateur(1, "Doe", "Jhon", "jhon@doe.com","1234", administrateur);
                controleurProjet = new ProjetControleur(projet, PrincipaleControleur.this, modele);

                Utilisateur utilisateur2 = new Utilisateur(1, "Alain", "Terrieur", "alain@terrieur.com","1234", membre);

                Utilisateur utilisateur3 = new Utilisateur(1, "Alex", "Terrieur", "alex@terrieur.com","1234", spectateur);

                projet.ajouterUser(utilisateur);
                projet.ajouterUser(utilisateur2);
                projet.ajouterUser(utilisateur3);
                controleurNavBar = new NavBarControleur(controleurProjet.getVue(), sectionVue, projet, utilisateur);

                vue.showNavBar(controleurNavBar.getVue());
                vue.showSection(sectionVue);
            }
        });

        vue.showMainView(monBouton);
    }

    /**
     * @return l'instance de la vue PrincipaleVue.
     */
    public PrincipaleVue getVue() {
        return this.vue;
    }

    /**
     * @return le bouton "Créer le projet".
     */
    public JButton getSubmitButton(){
        return this.submitButton;
    }

    /**
     * Change le projet actuel et met à jour les vues associées au nouveau projet.
     * 
     * @param nouveauProjet le nouveau projet sélectionné.
     */
    public void changeProjet(Projet nouveauProjet) {
        this.projetActuel = nouveauProjet;
        controleurNavBar.setProjet(nouveauProjet);
        controleurProjet.updateProjetPopupMenu(nouveauProjet);
        controleurProjet.getVue().setProjectButton(nouveauProjet.getNom());
    }
}

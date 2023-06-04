package trellolite.controleurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import trellolite.vues.PrincipaleVue;
import trellolite.modeles.*;
import trellolite.controleurs.ProjetControleur;
import trellolite.vues.SectionVue;

/**
 * Le contrôleur principal de l'application Trellolite.
 * Cette classe gère l'interaction entre le modèle Principale, les vues PrincipaleVue et SectionVue,
 * ainsi que les autres contrôleurs associés.
 * Elle crée et configure les boutons de création de projet, les associe à des actions,
 * crée les instances des vues PrincipaleVue et SectionVue,
 * et gère la transition entre les différentes vues en fonction des actions de l'utilisateur.
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
     * @param modele l'instance du modèle Principale.
     */
    public PrincipaleControleur(Principale modele) {
        this.modele = modele;
        this.vue = new PrincipaleVue();

        // Création des boutons
        monBouton = new JButton("Crée un projet");
        submitButton = new JButton("Créer le projet");

        // Action lors du clic sur le bouton "Crée un projet"
        monBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vue.showForm(submitButton);
            }
        });

        // Action lors du clic sur le bouton "Créer le projet"
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
    public JButton getSubmitButton(){
        return this.submitButton;
    }

    public void changeProjet(Projet nouveauProjet) {
        this.projetActuel = nouveauProjet;
        controleurNavBar.setProjet(nouveauProjet);
        controleurProjet.updateProjetPopupMenu(nouveauProjet);
        controleurProjet.getVue().setProjectButton(nouveauProjet.getNom());
    }
}

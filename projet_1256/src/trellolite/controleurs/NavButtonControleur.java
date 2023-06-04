package trellolite.controleurs;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import trellolite.modeles.NavBar;
import trellolite.modeles.NavButton;
import trellolite.modeles.Projet;
import trellolite.modeles.Utilisateur;
import trellolite.vues.NavButtonVue;
import trellolite.vues.ProjetVue;
import trellolite.vues.SectionVue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Controleur qui gère les interactions de l'utilisateur avec les boutons de navigation dans l'application Trellolite.
 * Il relie le modèle NavButton avec la vue NavButtonVue.
 * Il gère aussi les actions de navigation entre les différentes sections de l'application (tableau, membres, réunions, paramètres).
 */
public class NavButtonControleur {
    private NavButtonVue navButtonVue;
    private NavBar navBar;
    private SectionVue sectionVue;
    private TableauControleur tableauControleur;
    private MembreControleur membreControleur;
    private ReunionControleur reunionControleur;
    private ParametreControleur parametreControleur;

     /**
     * Constructeur pour le contrôleur des boutons de navigation.
     * 
     * @param navBar la barre de navigation contenant les boutons.
     * @param sectionVue la vue de la section.
     * @param projet le projet associé aux boutons de navigation.
     * @param utilisateur l'utilisateur actuel de l'application.
     * @param projetVue la vue du projet.
     * Il initialise les autres contrôleurs (tableau, membre, réunion, paramètre) et les boutons de navigation.
     * Les boutons sont initialisés avec leur nom, leur icône, leur taille, leur couleur et leur action lorsqu'ils sont sélectionnés.
     * Les actions déclenchent le changement de section dans l'application (tableau, membres, réunions, paramètres).
     */
    public NavButtonControleur(NavBar navBar, SectionVue sectionVue, Projet projet, Utilisateur utilisateur, ProjetVue projetVue) {
        this.sectionVue = sectionVue;
        this.navBar = navBar;
        ArrayList<JButton> navButtonsList = new ArrayList<>();
        ArrayList<NavButton> navButtons = navBar.getButtons();
        this.tableauControleur = new TableauControleur(projet, sectionVue, utilisateur);
        this.reunionControleur = new ReunionControleur(projet);
        this.membreControleur = new MembreControleur(projet);
        this.parametreControleur = new ParametreControleur(projet, projetVue);

        for (NavButton button : navButtons) {
            System.out.println(button.getName());
            JButton btn = new JButton(button.getName());
            ImageIcon icon = new ImageIcon(button.getIconURL());
            btn.setIcon(icon);
            btn.setIconTextGap(15);
            btn.setFont(new Font(btn.getFont().getName(), btn.getFont().getStyle(), 13));
            btn.setForeground(Color.white);
            btn.setPreferredSize(new Dimension(260, 40));
            btn.setBorder(new EmptyBorder(0, 25, 0, 0));
            btn.setHorizontalTextPosition(JButton.RIGHT);
            btn.setHorizontalAlignment(JButton.LEFT);
            btn.setBackground(Color.decode("#252526"));
            btn.setOpaque(true);

            // Initialisation de la couleur du bouton en fonction de son état isSelected
            if (button.isSelected()) {
                btn.setBackground(Color.decode("#343435"));
            } else {
                btn.setBackground(Color.decode("#252526")); // la couleur GRAY est la couleur d'un bouton non sélectionné.
            }

            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // on met tous les boutons sur isSelected = false
                    for (NavButton otherButton : navButtons) {
                        otherButton.setSelected(false);
                    }

                    // on met ce bouton sur isSelected = true
                    button.setSelected(true);

                    // on met à jour les couleurs de tous les boutons en conséquence
                    for (JButton otherBtn : navButtonsList) {
                        if (button.getName().equals(otherBtn.getText())) {
                            otherBtn.setBackground(Color.decode("#343435"));
                        } else {
                            otherBtn.setBackground(Color.decode("#252526"));
                        }
                    }

                    switch (button.getName()) {
                        case "Tableau de bord":
                            sectionVue.afficheTableaux(tableauControleur.getCreeTableauBtn());
                            break;
                        case "Membres":
                            sectionVue.afficheMembres(membreControleur.getVue());
                            break;
                        case "Réunions":
                            sectionVue.afficheReunions(reunionControleur.getCreeReunionBtn());
                            break;
                        case "Paramètres":
                            sectionVue.afficheParamètres(parametreControleur.getVue());
                            break;
                        default:
                            break;
                    }
                }
            });
            navButtonsList.add(btn);
            sectionVue.afficheTableaux(tableauControleur.getCreeTableauBtn());
        }
        this.navButtonVue = new NavButtonVue(navButtonsList);
    }

    /**
     * Renvoie l'instance de la vue des boutons de navigation associée à ce contrôleur.
     *
     * @return l'instance de la vue des boutons de navigation.
     */
    public NavButtonVue getVue() {
        return this.navButtonVue;
    }

    /**
     * Renvoie l'instance du contrôleur des tableaux associé à ce contrôleur des boutons de navigation.
     *
     * @return l'instance du contrôleur des tableaux.
     */
    public TableauControleur getTableauControleur() {
        return this.tableauControleur;
    }

    /**
     * Définit le projet associé aux contrôleurs.
     *
     * @param projet le projet à associer.
     */
    public void setProjet(Projet projet) {
        tableauControleur.setProjet(projet);
        membreControleur.setProjet(projet);
        reunionControleur.setProjet(projet);
        parametreControleur.setProjet(projet);
    }
}

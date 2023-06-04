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
 * Le contrôleur des boutons de navigation (NavButton) de la barre de navigation (NavBar) de l'application Trellolite.
 * Cette classe gère l'interaction entre le modèle NavBar, la vue NavButtonVue, la vue SectionVue,
 * et les différents contrôleurs associés aux fonctionnalités liées aux boutons de navigation.
 * Elle crée les boutons de navigation en fonction des données du modèle NavBar,
 * initialise leurs propriétés visuelles, gère leurs actions lorsqu'ils sont cliqués,
 * et met à jour la vue SectionVue en fonction du bouton sélectionné.
 * Elle associe également les contrôleurs des différentes fonctionnalités (TableauControleur, MembreControleur, etc.)
 * aux boutons de navigation correspondants.
 * Cette classe permet de naviguer entre les différentes vues de l'application en utilisant la barre de navigation.
 * 
 * @author Nawfel Kerarsi
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
     * Constructeur de la classe NavButtonControleur.
     * 
     * @param navBar        l'instance du modèle NavBar contenant les boutons de navigation.
     * @param sectionVue    l'instance de la vue SectionVue pour afficher les différentes vues en fonction des boutons sélectionnés.
     * @param projet        l'instance du modèle Projet associée à l'application.
     * @param utilisateur   l'instance du modèle Utilisateur représentant l'utilisateur actuel.
     * @param projetVue     l'instance de la vue ProjetVue pour afficher les détails du projet.
     */
    NavButtonControleur(NavBar navBar, SectionVue sectionVue, Projet projet, Utilisateur utilisateur, ProjetVue projetVue) {
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

            // Initialise la couleur du bouton en fonction de son état isSelected
            if (button.isSelected()) {
                btn.setBackground(Color.decode("#343435"));
            } else {
                btn.setBackground(Color.decode("#252526")); // la couleur GRAY est la couleur d'un bouton non sélectionné.
            }

            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Mettre tous les boutons sur isSelected = false
                    for (NavButton otherButton : navButtons) {
                        otherButton.setSelected(false);
                    }

                    // Mettre ce bouton sur isSelected = true
                    button.setSelected(true);

                    // Mettre à jour les couleurs de tous les boutons en conséquence
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
     * @return l'instance de la vue NavButtonVue.
     */
    public NavButtonVue getVue() {
        return this.navButtonVue;
    }

    /**
     * @return l'instance du contrôleur TableauControleur.
     */
    public TableauControleur getTableauControleur() {
        return this.tableauControleur;
    }

    /**
     * Définit le projet associé à ce contrôleur de bouton de navigation.
     * Met à jour les projets associés aux contrôleurs correspondants (TableauControleur, MembreControleur, etc.).
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

package trellolite.vues;

import trellolite.modeles.Projet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Classe représentant une vue pour afficher un projet.
 * Elle affiche un bouton représentant le projet avec son nom.
 *
 * @author Samuel Boix-Segura
 */
public class ProjetVue extends JPanel {
    private JButton projectButton;

    /**
     * Constructeur de la classe ProjetVue.
     *
     * @param projectButton Le bouton représentant le projet.
     */
    public ProjetVue(JButton projectButton) {
        this.projectButton = projectButton;
        setLayout(new BorderLayout());
        setBackground(Color.decode("#252526"));
        add(projectButton);
    }

    /**
     * Définit le projet associé à la vue.
     *
     * @param projet Le projet à afficher.
     */
    public void setProjet(Projet projet) {
        // TODO: Implémenter la logique pour afficher les détails du projet
    }

    /**
     * Définit le texte du bouton représentant le projet.
     *
     * @param nomProjet Le nom du projet à afficher.
     */
    public void setProjectButton(String nomProjet) {
        projectButton.setText("<html><b>" + nomProjet + "<b><html>");
    }
}

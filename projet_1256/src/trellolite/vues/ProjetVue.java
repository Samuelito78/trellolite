package trellolite.vues;

import trellolite.modeles.Projet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Image;

/**
 * La classe ProjetVue représente la vue d'un projet dans l'application.
 * Cette vue affiche un bouton de projet dans un panneau.
 * Elle offre également une méthode pour définir le projet associé à la vue.
 * La vue utilise une couleur d'arrière-plan spécifique.
 * 
 * @auther Samuel Boix-Segura
 */
public class ProjetVue extends JPanel{
    private JButton projectButton;
    
    /**
     * Constructeur de la classe ProjetVue.
     * 
     * @param projectButton Le bouton de projet à afficher dans la vue.
     */
    public ProjetVue(JButton projectButton) {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#252526"));
        add(projectButton);
    }

    public void setProjet(Projet projet) {
    }


}

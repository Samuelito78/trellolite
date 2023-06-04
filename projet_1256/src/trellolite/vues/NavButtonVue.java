package trellolite.vues;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * La classe NavButtonVue représente une vue pour afficher des boutons de navigation dans un panneau.
 * Elle est utilisée pour créer une barre de navigation horizontale.
 * 
 * @author Samuel Boix-Segura
 */
public class NavButtonVue extends JPanel {
    /**
     * Constructeur de la classe NavButtonVue.
     * Crée une nouvelle instance de la vue avec une liste de boutons de navigation spécifiée.
     *
     * @param navButtons La liste des boutons de navigation à afficher.
     */
    public NavButtonVue(ArrayList<JButton> navButtons) {
        setBackground(Color.decode("#252526"));

        // Ajoute chaque bouton de navigation au panneau
        for (JButton button : navButtons) {
            add(button);
        }
    }
}


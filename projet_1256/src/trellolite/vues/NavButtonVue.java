package trellolite.vues;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * La classe NavButtonVue représente la vue des boutons de navigation dans la barre de navigation.
 * Cette vue affiche une liste de boutons de navigation dans un panneau.
 * Chaque bouton est ajouté à la vue individuellement.
 * La vue utilise une couleur d'arrière-plan spécifique.
 * 
 * @author Samuel Boix-Segura
 */
public class NavButtonVue extends JPanel {
    
    /**
     * Constructeur de la classe NavButtonVue.
     * 
     * @param navButtons La liste des boutons de navigation à afficher dans la vue.
     */
    public NavButtonVue(ArrayList<JButton> navButtons){
        setBackground(Color.decode("#252526"));
        
        // Ajoute chaque bouton de navigation à la vue
        for (JButton button : navButtons) {
            add(button);
        }
    }
}

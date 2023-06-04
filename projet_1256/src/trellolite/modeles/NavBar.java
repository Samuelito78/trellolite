package trellolite.modeles;

import java.util.ArrayList;

/**
 * La classe NavBar représente une barre de navigation dans l'application.
 * Une barre de navigation est constituée d'une liste de boutons de navigation.
 *
 * @author Clement Cressault
 */
public class NavBar {

    // La liste des boutons de navigation
    private ArrayList<NavButton> buttons;

    /**
     * Constructeur de la classe NavBar.
     * Initialise la liste des boutons de navigation comme étant vide.
     */
    public NavBar() {
        this.buttons = new ArrayList<>();
    }

    /**
     * Ajoute un bouton à la barre de navigation.
     *
     * @param button Le bouton de navigation à ajouter.
     */
    public void addButton(NavButton button) {
        this.buttons.add(button);
    }

    /**
     * Supprime un bouton de la barre de navigation.
     *
     * @param button Le bouton de navigation à supprimer.
     */
    public void removeButton(NavButton button) {
        this.buttons.remove(button);
    }

    /**
     * Récupère la liste des boutons de navigation.
     *
     * @return La liste des boutons de navigation.
     */
    public ArrayList<NavButton> getButtons() {
        return buttons;
    }

}

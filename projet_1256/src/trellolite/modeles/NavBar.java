package trellolite.modeles;

import java.util.ArrayList;

public class NavBar {

    private ArrayList<NavButton> buttons;

    // Constructeur
    public NavBar() {
        this.buttons = new ArrayList<>();
    }

    // Ajouter un bouton à la barre de navigation
    public void addButton(NavButton button) {
        this.buttons.add(button);
    }

    // Supprimer un bouton de la barre de navigation
    public void removeButton(NavButton button) {
        this.buttons.remove(button);
    }

    // Obtenir la liste des boutons de la barre de navigation
    public ArrayList<NavButton> getButtons() {
        return buttons;
    }

    // Autres méthodes liées à la gestion des boutons...
}

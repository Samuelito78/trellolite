package trellolite.modeles;

public class NavButton {

    private String name;
    private String iconURL;
    private boolean isSelected;

    // Constructeur
    public NavButton(String name, String iconURL) {
        this.name = name;
        this.iconURL = iconURL;
        this.isSelected = false; // par défaut, le bouton n'est pas sélectionné
    }

    // Getters et setters pour chaque attribut

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconURL() {
        return iconURL;
    }

    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

}

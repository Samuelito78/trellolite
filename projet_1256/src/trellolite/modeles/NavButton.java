package trellolite.modeles;

/**
 * La classe NavButton représente un bouton de navigation dans l'application.
 * Chaque bouton a un nom, une URL d'icône et un état de sélection.
 *
 * @author Clement Cressault
 */
public class NavButton {

    //-----------------------------------------
	// ATTRIBUTS
    //-----------------------------------------
    
    // Le nom du bouton de navigation
    private String name;
    // L'URL de l'icône du bouton de navigation
    private String iconURL;
    // L'état de sélection du bouton de navigation
    private boolean isSelected;



    //--------------------------------------------
	// 				 CONSTRUCTEUR
	//--------------------------------------------
    
    /**
     * Constructeur de la classe NavButton.
     * Initialise le nom et l'URL de l'icône du bouton. 
     * Par défaut, le bouton n'est pas sélectionné.
     *
     * @param name Le nom du bouton.
     * @param iconURL L'URL de l'icône du bouton.
     */
    public NavButton(String name, String iconURL) {
        this.name = name;
        this.iconURL = iconURL;
        this.isSelected = false;
    }

    /**
     * Constructeur de la classe NavButton.
     * Initialise le nom, l'URL de l'icône du bouton et l'état de sélection.
     *
     * @param name Le nom du bouton.
     * @param iconURL L'URL de l'icône du bouton.
     * @param isSelected L'état de sélection du bouton.
     */
    public NavButton(String name, String iconURL, boolean isSelected) {
        this.name = name;
        this.iconURL = iconURL;
        this.isSelected = isSelected;
    }

    
    
    //---------------------------------------------
	// 			   GETTERS / SETTERS
	//---------------------------------------------    

    /**
     * Récupère le nom du bouton de navigation.
     * @return Le nom du bouton de navigation.
     */
    public String getName() {
        return name;
    }

    /**
     * Définit le nom du bouton de navigation.
     * @param name Le nouveau nom du bouton de navigation.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Récupère l'URL de l'icône du bouton de navigation.
     * @return L'URL de l'icône du bouton de navigation.
     */
    public String getIconURL() {
        return iconURL;
    }

    /**
     * Définit l'URL de l'icône du bouton de navigation.
     * @param iconURL La nouvelle URL de l'icône du bouton de navigation.
     */
    public void setIconURL(String iconURL) {
        this.iconURL = iconURL;
    }

    /**
     * Récupère l'état de sélection du bouton de navigation.
     * @return L'état de sélection du bouton de navigation.
     */
    public boolean isSelected() {
        return isSelected;
    }

    /**
     * Définit l'état de sélection du bouton de navigation.
     * @param isSelected Le nouvel état de sélection du bouton de navigation.
     */
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}

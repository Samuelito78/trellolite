package trellolite.modeles;
import java.util.ArrayList;

/**
 * La classe Etiquette représente une étiquette dans le système Trellolite.
 * Une étiquette est simplement définie par son nom.
 *
 * @author Clement Cressault
 */
public class Etiquette {

    //-----------------------------------------
	// ATTRIBUTS
	//-----------------------------------------
    private String nom;



    //--------------------------------------------
	// 				 CONSTRUCTEUR
	//--------------------------------------------
    /**
     * Constructeur de la classe Etiquette.
     * Initialise le nom de l'étiquette avec le paramètre donné.
     *
     * @param nom Le nom de l'étiquette.
     */
    public Etiquette(String nom) {
        this.setNom(nom);
    }


    
    //---------------------------------------------
    // 			   		METHODES
    //---------------------------------------------

    // Getter et Setter pour l'attribut "nom"
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}

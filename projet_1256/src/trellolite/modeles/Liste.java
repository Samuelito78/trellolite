package trellolite.modeles;
import java.util.ArrayList;

public class Liste {

    //-----------------------------------------
	// ATTRIBUTS
	//-----------------------------------------
    Tableau tableau;
    ArrayList<Carte> cartes;
    private String nom;



    //--------------------------------------------
	// 				 CONSTRUCTEUR
	//--------------------------------------------

    /**
     * Constructeur complet pour la classe Liste.
     * Initialise toutes les variables d'instance avec les paramètres donnés.
     * 
     * @param nom Le nom de la liste.
     * @param cartes La liste des cartes associées à la liste.
     * @param tableau Le tableau auquel la liste est associée.
     */
    public Liste(String nom, ArrayList<Carte> cartes, Tableau tableau) {
        this.setNom(nom);
        this.cartes = cartes;
        this.tableau = tableau;
    }

    /**
     * Constructeur partiel pour la classe Liste.
     * Initialise le nom et le tableau avec les paramètres donnés.
     * Initialise une liste vide de cartes.
     *
     * @param nom Le nom de la liste.
     * @param tableau Le tableau auquel la liste est associée.
     */
    public Liste(String nom, Tableau tableau) {
        this.setNom(nom);
        this.tableau = tableau;
        this.cartes = new ArrayList<>();
    }



    //---------------------------------------------
	// 			   GETTERS / SETTERS
	//---------------------------------------------

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }


    //---------------------------------------------
	// 			   		METHODES
	//---------------------------------------------

	public void ajouterCarte(Carte n_carte){
		cartes.add(n_carte);
	}

    public void supprCarte(Carte n_carte){
        cartes.add(n_carte);
    }
}

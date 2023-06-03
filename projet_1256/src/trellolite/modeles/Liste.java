package trellolite.modeles;
import java.util.ArrayList;
public class Liste {
    // Attributs
    Tableau tableau;
    ArrayList<Carte> cartes;
    private String nom;

    // Constructeur
    public Liste(String nom, ArrayList<Carte> cartes, Tableau tableau) {
        this.setNom(nom);
        this.cartes = cartes;
        this.tableau = tableau;

    }

    public Liste(String nom, Tableau tableau) {
        this.setNom(nom);
        this.tableau = tableau;
        this.cartes = new ArrayList<>();
    }


    // Getter et Setter pour l'attribut "nom"
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

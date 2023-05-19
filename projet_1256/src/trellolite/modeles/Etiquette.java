package trellolite.modeles;
import java.util.ArrayList;
public class Etiquette {
    // Attributs
    ArrayList<Carte> cartes;
    private String nom;
    private String couleur;

    // Constructeur
    public Etiquette(String nom, String couleur, ArrayList<Carte> cartes) {
        this.setNom(nom);
        this.setCouleur(couleur);
        this.cartes = cartes;
    }

    // Getter et Setter pour l'attribut "nom"
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Getter et Setter pour l'attribut "couleur"
    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
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

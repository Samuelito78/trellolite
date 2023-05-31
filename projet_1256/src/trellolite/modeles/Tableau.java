package trellolite.modeles;
import java.util.ArrayList;
public class Tableau {

	//-----------------------------------------
	// ATTRIBUTS
	//-----------------------------------------

	private ArrayList<Liste> liste;
	private Projet projet;
	private String nom;

	//--------------------------------------------
	// 				 CONSTRUCTEUR
	//--------------------------------------------

	public Tableau(String nom, ArrayList<Liste> liste, Projet projet) {
		this.setNom(nom);
		this.liste=liste;
		this.projet = projet;
	}

	public Tableau(String nom, Projet projet){
		this.setNom(nom);
		this.projet = projet;
		this.liste = new ArrayList<>();
		liste.add(new Liste("À faire", this));
		liste.add(new Liste("En cours", this));
		liste.add(new Liste("Terminé", this));
	}

	public Tableau(){
		nom = "tableau_1";
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


	public ArrayList<Liste> getListe() {
		return liste;
	}


	//---------------------------------------------
	// 			   		METHODES
	//---------------------------------------------

	public void ajouterListe(Liste n_liste){
		liste.add(n_liste);
	}

	public void supprListe(Liste n_liste){
		liste.remove(n_liste);
	}
}
package trellolite.modeles;
import java.util.ArrayList;
public class Tableau {

	//-----------------------------------------
	// ATTRIBUTS
	//-----------------------------------------

	ArrayList<Liste> liste;
	Projet tableau;
	private String nom;
	private String description;
	private int datedebut;
	private int datefin;
	
	//--------------------------------------------
	// 				 CONSTRUCTEUR
	//--------------------------------------------

	public Tableau(String nom, String description, int datedebut, int datefin, ArrayList<Liste> liste, Projet tableau) {
		this.setNom(nom);
		this.setDescription(description);
		this.setDatedebut(datedebut);
		this.setDatefin(datefin);
		this.liste=liste;
		this.tableau = tableau;
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

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
	public int getDatedebut() {
		return datedebut;
	}
	public void setDatedebut(int datedebut) {
		this.datedebut = datedebut;
	}

	
	public int getDatefin() {
		return datefin;
	}
	public void setDatefin(int datefin) {
		this.datefin = datefin;
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
package trellolite.modeles;
import java.util.ArrayList;
public class Reunion {

	//-----------------------------------------
	// ATTRIBUTS
	//-----------------------------------------

	ArrayList<Utilisateur> utilisateurs;
	Projet projet;
	private String nom;
	
	//--------------------------------------------
	// 				 CONSTRUCTEUR
	//--------------------------------------------

	public Reunion(String nom,Projet projet, ArrayList<Utilisateur> utilisateurs){
		this.setNom(nom);
		this.projet=projet;
		this.utilisateurs = utilisateurs;
	}	

	//----------------------
	//   GETTERS & SETTERS
	//----------------------
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public ArrayList<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}


    //---------------------------------------------
	// 			   		METHODES
	//---------------------------------------------

	public void ajouterUser(Utilisateur n_user){
		utilisateurs.add(n_user);
	}

	public void supprUser(Utilisateur n_user){
		utilisateurs.remove(n_user);
	}
}
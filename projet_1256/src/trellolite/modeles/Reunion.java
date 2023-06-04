package trellolite.modeles;

import java.util.ArrayList;

/**
 * La classe Reunion représente une réunion dans le contexte de l'application Trellolite.
 * Chaque réunion a un nom, est associée à un projet et a une liste d'utilisateurs y participant.
 * 
 * @author Samuel Boix-Segura
 */
public class Reunion {

	//-----------------------------------------
	// ATTRIBUTS
	//-----------------------------------------
	private String nom;
	private Projet projet;
	ArrayList<Utilisateur> utilisateurs;

	//--------------------------------------------
	// 				 CONSTRUCTEURS
	//--------------------------------------------

	/**
	 * Constructeur de la classe Reunion. 
	 * @param nom Le nom de la réunion.
	 * @param projet Le projet auquel est associée la réunion.
	 * @param utilisateurs La liste des utilisateurs participant à la réunion.
	 */
	public Reunion(String nom, Projet projet, ArrayList<Utilisateur> utilisateurs){
		this.nom = nom;
		this.projet = projet;
		this.utilisateurs = utilisateurs;
	}

	/**
	 * Second constructeur de la classe Reunion. 
	 * Il est utilisé quand la liste des utilisateurs sera ajoutée plus tard.
	 * @param nom Le nom de la réunion.
	 * @param projet Le projet auquel est associée la réunion.
	 */
	public Reunion(String nom, Projet projet){
		this.nom = nom;
		this.projet = projet;
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

	public ArrayList<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

    //---------------------------------------------
	// 			   		MÉTHODES
	//---------------------------------------------

	/**
	 * Cette méthode ajoute un utilisateur à la liste des participants de la réunion.
	 * @param n_user L'utilisateur à ajouter à la réunion.
	 */
	public void ajouterUser(Utilisateur n_user){
		utilisateurs.add(n_user);
	}

	/**
	 * Cette méthode supprime un utilisateur de la liste des participants de la réunion.
	 * @param n_user L'utilisateur à supprimer de la réunion.
	 */
	public void supprUser(Utilisateur n_user){
		utilisateurs.remove(n_user);
	}
}

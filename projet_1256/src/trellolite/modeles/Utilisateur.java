package trellolite.modeles;
import java.util.ArrayList;

/*
 * @auteur Samuel Boix-Segura
 */

public class Utilisateur {
	//-----------------------------------------
	// CONSTRUCTEUR
	//-----------------------------------------
	public Utilisateur(int id, String nom, String prenom, String email, String mdp, Role role) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.role = role;
	}
	
	//-----------------------------------------
	// ATTRIBUTS
	//-----------------------------------------
	//
	private double id;
	private String nom;
	private String prenom;
	private String email;
	private String mdp;
	private Role role;	
	
	//--------------------------------------------
	// 				 CONSTRUCTEUR
	//--------------------------------------------
	
    public Utilisateur(double id,String nom, String prenom, String email, String mdp,Role role, ArrayList<Commentaire> commentaire, ArrayList<Reunion> reunion) {
        this.setId(id);
    	this.setNom(nom);
        this.setPrenom(prenom);
        this.setEmail(email);
        this.setMdp(mdp);
        this.setRole(role);
    }



	//---------------------------------------------
	// 			   GETTERS / SETTERS
	//---------------------------------------------

	public double getId() {
		return id;
	}
	public void setId(double id) {
		this.id = id;
	}
	

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}

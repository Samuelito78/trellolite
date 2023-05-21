package trellolite.modeles;
import java.util.ArrayList;

/*
 * @auteur Samuel Boix-Segura
 */

public class Utilisateur {
	
	//-----------------------------------------
	// ATTRIBUTS
	//-----------------------------------------
	//
	ArrayList<Commentaire> commentaire;
	public ArrayList<Reunion> reunion;
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
		this.commentaire = commentaire;
		this.reunion = reunion;
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

	
	public ArrayList<Commentaire> getComm() {
		return commentaire;
	}

	public ArrayList<Reunion> getReunion() {
		return reunion;
	}




	//---------------------------------------------
	// 			   		METHODES
	//---------------------------------------------

	public void ajouterComm(Commentaire n_comm){
		commentaire.add(n_comm);
	}

	public void ajouterReunion(Reunion n_reu){
		reunion.add(n_reu);
	}

	public void supprComm(Commentaire n_comm){
		commentaire.remove(n_comm);
	}

	public void supprReunion(Reunion n_reu){
		reunion.remove(n_reu);
	}
}

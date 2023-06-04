package trellolite.modeles;
import java.util.ArrayList;
/**
 * La classe Utilisateur représente un utilisateur de l'application Trellolite. 
 * Chaque utilisateur a un id, un nom, un prénom, un email, un mot de passe et un rôle.
 * 
 * @author Mohamed Telli
 */
public class Utilisateur {
	
	//-----------------------------------------
	// ATTRIBUTS
	//-----------------------------------------
	private double id;
	private String nom;
	private String prenom;
	private String email;
	private String mdp;
	private Role role;	

	//--------------------------------------------
	// 				 CONSTRUCTEURS
	//--------------------------------------------

    /**
     * Constructeur de la classe Utilisateur avec tous les paramètres nécessaires.
     * @param id L'identifiant unique de l'utilisateur.
     * @param nom Le nom de l'utilisateur.
     * @param prenom Le prénom de l'utilisateur.
     * @param email L'email de l'utilisateur.
     * @param mdp Le mot de passe de l'utilisateur.
     * @param role Le rôle de l'utilisateur.
     */
	public Utilisateur(double id, String nom, String prenom, String email, String mdp, Role role) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.mdp = mdp;
		this.role = role;
	}

    /**
     * Second constructeur de la classe Utilisateur. Il est utilisé lorsque les commentaires et les réunions sont ajoutés plus tard.
     * @param id L'identifiant unique de l'utilisateur.
     * @param nom Le nom de l'utilisateur.
     * @param prenom Le prénom de l'utilisateur.
     * @param email L'email de l'utilisateur.
     * @param mdp Le mot de passe de l'utilisateur.
     * @param role Le rôle de l'utilisateur.
     * @param commentaire La liste des commentaires de l'utilisateur.
     * @param reunion La liste des réunions de l'utilisateur.
     */
    public Utilisateur(double id, String nom, String prenom, String email, String mdp, Role role, ArrayList<Commentaire> commentaire, ArrayList<Reunion> reunion) {
        this.id = id;
    	this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.role = role;
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

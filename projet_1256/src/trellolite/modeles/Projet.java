package trellolite.modeles;
import java.util.ArrayList;
public class Projet {
    // Attributs
    ArrayList<Tableau> tableaux;
    ArrayList<Utilisateur> utilisateurs;
    ArrayList<Reunion> reunions;
    private String nom;
    private String type;
    private String description;
    ArrayList<Utilisateur> admin;

    // Constructeur
    public Projet(String nom, String type, String description, ArrayList<Utilisateur> utilisateurs, ArrayList<Utilisateur> admin, ArrayList<Reunion> reunions, ArrayList<Tableau> tableaux) {
        this.setNom(nom);
        this.setDescription(description);
        this.setType(type);
        this.utilisateurs = utilisateurs;
        this.admin = admin;
        this.reunions = reunions;
        this.tableaux = tableaux;
    }

    // Getter et Setter pour l'attribut "description"
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter et Setter pour l'attribut "type"
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter et Setter pour l'attribut "nom"
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public ArrayList<Tableau> getTableaux() {
        return tableaux;
    }

    public ArrayList<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public ArrayList<Reunion> getReunions() {
        return reunions;
    }

    public ArrayList<Utilisateur> getAdmin() {
        return admin;
    }


    //---------------------------------------------
	// 			   		METHODES
	//---------------------------------------------

	public void ajouterTableau(Tableau n_tab){
		tableaux.add(n_tab);
	}

    public void supprTableau(Tableau n_tab){
        tableaux.remove(n_tab);
    }
}

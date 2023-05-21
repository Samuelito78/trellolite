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

    // Constructeurs
    public Projet(String nom, String type, String description, ArrayList<Utilisateur> utilisateurs, ArrayList<Reunion> reunions, ArrayList<Tableau> tableaux) {
        this.setNom(nom);
        this.setDescription(description);
        this.setType(type);
        this.utilisateurs = utilisateurs;
        this.reunions = reunions;
        this.tableaux = tableaux;
    }



    public Projet(String nom, Utilisateur admin) {
		this.nom = nom;
		utilisateurs = new ArrayList<Utilisateur>();
		utilisateurs.add(admin);
		this.utilisateurs.get(0).setRole(Role.administrateur);
		tableaux = new ArrayList<Tableau>();
		tableaux.add(new Tableau());
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


    //---------------------------------------------
	// 			   		METHODES
	//---------------------------------------------

	public void ajouterTableau(Tableau n_tab){
		tableaux.add(n_tab);
	}

    public void supprTableau(Tableau n_tab){
        tableaux.remove(n_tab);
    }

    public void ajouterReunion(Reunion n_reunion){
		reunions.add(n_reunion);
	}

    public void supprReunion(Reunion n_reunion){
        reunions.remove(n_reunion);
    }

    public void ajouterUser(Utilisateur n_user){
		utilisateurs.add(n_user);
	}

	public void supprUser(Utilisateur n_user){
		utilisateurs.remove(n_user);
	}


    //cherche qui est l'administrateur du projet
    public Utilisateur admin() {
        for (Utilisateur i : utilisateurs) {
            if (i.getRole() == Role.administrateur)
                return i;
        }
        return null;
    }
}

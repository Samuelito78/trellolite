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

        /**
     * Constructeur complet pour la classe Projet. 
     * Initialise toutes les variables d'instance avec les paramètres donnés.
     * 
     * @param nom Le nom du projet.
     * @param type Le type du projet.
     * @param description La description du projet.
     * @param utilisateurs La liste des utilisateurs associés au projet.
     * @param reunions La liste des réunions associées au projet.
     * @param tableaux La liste des tableaux associés au projet.
     */
    public Projet(String nom, String type, String description, ArrayList<Utilisateur> utilisateurs, ArrayList<Reunion> reunions, ArrayList<Tableau> tableaux) {
        this.setNom(nom);
        this.setDescription(description);
        this.setType(type);
        this.utilisateurs = utilisateurs;
        this.reunions = reunions;
        this.tableaux = tableaux;
    }

    /**
     * Constructeur partiel pour la classe Projet. 
     * Initialise les variables d'instance de nom, type, et description avec les paramètres donnés.
     * Initialise des listes vides pour les utilisateurs, les réunions et les tableaux.
     *
     * @param nom Le nom du projet.
     * @param type Le type du projet.
     * @param description La description du projet.
     */
    public Projet(String nom, String type, String description) {
        this.setNom(nom);
        this.setDescription(description);
        this.setType(type);
        this.utilisateurs = new ArrayList<>();
        this.tableaux = new ArrayList<>();
        this.reunions = new ArrayList<>();
    }

    /**
     * Constructeur spécial pour la classe Projet.
     * Initialise la variable d'instance de nom avec le paramètre donné.
     * Initialise un utilisateur admin comme premier utilisateur du projet.
     * Initialise un tableau vide.
     *
     * @param nom Le nom du projet.
     * @param admin L'utilisateur qui est défini comme l'administrateur du projet.
     */
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

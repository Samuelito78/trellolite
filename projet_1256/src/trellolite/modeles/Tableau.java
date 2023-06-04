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

    /**
     * Constructeur complet pour la classe Tableau.
     * Initialise toutes les variables d'instance avec les paramètres donnés.
     * 
     * @param nom Le nom du tableau.
     * @param liste La liste des listes associées au tableau.
     * @param projet Le projet auquel le tableau est associé.
     */
    public Tableau(String nom, ArrayList<Liste> liste, Projet projet) {
        this.setNom(nom);
        this.liste=liste;
        this.projet = projet;
    }

    /**
     * Constructeur partiel pour la classe Tableau.
     * Initialise le nom et le projet avec les paramètres donnés.
     * Initialise une liste par défaut avec trois listes : "À faire", "En cours", "Terminé".
     *
     * @param nom Le nom du tableau.
     * @param projet Le projet auquel le tableau est associé.
     */
    public Tableau(String nom, Projet projet){
        this.setNom(nom);
        this.projet = projet;
        this.liste = new ArrayList<>();
        liste.add(new Liste("À faire", this));
        liste.add(new Liste("En cours", this));
        liste.add(new Liste("Terminé", this));
    }

    /**
     * Constructeur par défaut pour la classe Tableau.
     * Initialise le nom du tableau avec la valeur "tableau_1".
     */
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
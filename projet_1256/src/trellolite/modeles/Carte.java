package trellolite.modeles;
import java.util.ArrayList;
import java.util.Date;
/**
 * La classe Carte représente une carte dans le système Trellolite.
 * Une carte est composée d'un nom, d'une description, de dates de début et de fin,
 * et peut contenir plusieurs commentaires et étiquettes.
 * 
 * @author Clement Cressault
 */
public class Carte  {

    //-----------------------------------------
	// ATTRIBUTS
	//-----------------------------------------
    Liste liste;
    ArrayList<Commentaire> comm;
    ArrayList<Etiquette> etiquettes;
    private String nom;
    private String description;
    private Date datedebut;
    private Date datefin;



    //--------------------------------------------
	// 				 CONSTRUCTEUR
	//--------------------------------------------
    /**
     * Constructeur complet de la classe Carte.
     * Initialise toutes les variables d'instance avec les paramètres donnés.
     *
     * @param nom Le nom de la carte.
     * @param description La description de la carte.
     * @param datedebut La date de début de la carte.
     * @param datefin La date de fin de la carte.
     * @param comm La liste des commentaires associés à la carte.
     * @param etiquettes La liste des étiquettes associées à la carte.
     * @param liste La liste à laquelle la carte est associée.
     */
    public Carte(String nom, String description, Date datedebut, Date datefin, ArrayList<Commentaire> comm, ArrayList<Etiquette> etiquettes, Liste liste) {
        this.setNom(nom);
        this.setDescription(description);
        this.setDatedebut(datedebut);
        this.setDatefin(datefin);
        this.comm = comm;
        this.etiquettes = etiquettes;
        this.liste = liste;
    }

    /**
     * Constructeur partiel de la classe Carte.
     * Initialise le nom avec le paramètre donné et la date de début et de fin avec la date courante.
     * Initialise une liste vide de commentaires et d'étiquettes.
     *
     * @param nom Le nom de la carte.
     */
    public Carte(String nom){
        this.nom = nom;
        this.datedebut = new Date();
        this.datefin = new Date();
        this.comm = new ArrayList<>();
        this.etiquettes = new ArrayList<>();
    }



    //---------------------------------------------
	// 			   GETTERS / SETTERS
	//---------------------------------------------

    // Getter et Setter pour l'attribut "description"
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter et Setter pour l'attribut "datedebut"
    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    // Getter et Setter pour l'attribut "datefin"
    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    // Getter et Setter pour l'attribut "nom"
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public ArrayList<Etiquette> getEtiquettes() {
        return etiquettes;
    }

    public ArrayList<Commentaire> getComm() {
        return comm;
    }


    //---------------------------------------------
	// 			   		METHODES
	//---------------------------------------------

	public void ajouterComm(Commentaire n_comm){
		comm.add(n_comm);
	}

    public void ajouterEtiq(Etiquette n_etiq){
		etiquettes.add(n_etiq);
	}

    public void supprComm(Commentaire n_comm){
        comm.remove(n_comm);
    }

    public void supprEtiq(Etiquette n_etiq){
        etiquettes.remove(n_etiq);
    }
}

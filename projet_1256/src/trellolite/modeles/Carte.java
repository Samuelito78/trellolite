package trellolite.modeles;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
/*
 * @auteur Samuel Boix-Segura
 */

public class Carte {
    // Attributs
    Liste liste;
    ArrayList<Commentaire> comm;
    ArrayList<Etiquette> etiquettes;
    private String nom;
    private String description;
    private Date datedebut;
    private Date datefin;

    // Constructeur
    public Carte(String nom, String description, Date datedebut, Date datefin, ArrayList<Commentaire> comm, ArrayList<Etiquette> etiquettes, Liste liste) {
        this.setNom(nom);
        this.setDescription(description);
        this.setDatedebut(datedebut);
        this.setDatefin(datefin);
        this.comm = comm;
        this.etiquettes = etiquettes;

    }

    public Carte(String nom){
        this.nom = nom;
        this.datedebut = new Date();
        this.datefin = new Date();
        this.comm = new ArrayList<>();
        this.etiquettes = new ArrayList<>();
    }

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

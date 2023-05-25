package trellolite.modeles;
import javax.swing.*;
import java.util.ArrayList;
import trellolite.modeles.Projet;
public class Principale {
    private ArrayList<Projet> projets;

    public Principale() {
        this.projets = new ArrayList<>();
    }

    public ArrayList<Projet> getProjets() {
        return this.projets;
    }

    public void addProjet(Projet projet) {
        this.projets.add(projet);
    }
}

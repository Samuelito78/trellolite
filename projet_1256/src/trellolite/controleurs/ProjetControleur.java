package trellolite.controleurs;
import trellolite.modeles.Projet;
import trellolite.vues.ProjetVue;
public class ProjetControleur {
    private ProjetVue vue;
    private Projet projet;

    public ProjetControleur(Projet projet) {
        this.projet = projet;
        this.vue = new ProjetVue();
        this.vue.setProjet(projet);
    }

    public ProjetVue getVue() {
        return this.vue;
    }
}

package trellolite.controleurs;
import trellolite.modeles.Projet;
import trellolite.vues.ProjetVue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ProjetControleur {
    private ProjetVue vue;
    private Projet projet;
    private JButton projectButton;
    public ProjetControleur(Projet projet) {
        this.projet = projet;
        this.projectButton = new JButton(projet.getNom());
        this.projectButton.setPreferredSize(new Dimension(260, 60));
        this.projectButton.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.projectButton.setBackground(Color.CYAN);
        this.projectButton.setOpaque(true);
        this.vue = new ProjetVue(projectButton);
        this.vue.setProjet(projet);
    }

    public ProjetVue getVue() {
        return this.vue;
    }
}

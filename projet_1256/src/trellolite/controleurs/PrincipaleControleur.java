package trellolite.controleurs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import trellolite.vues.PrincipaleVue;
import trellolite.modeles.*;
import trellolite.controleurs.ProjetControleur;
import trellolite.vues.SectionVue;

public class PrincipaleControleur {
    private PrincipaleVue vue;
    private Principale modele;
    private SectionVue sectionVue;
    private JButton monBouton;
    private JButton submitButton;
    private ProjetControleur controleurProjet;
    private NavBarControleur controleurNavBar;

    public PrincipaleControleur(Principale modele) {
        this.modele = modele;
        this.vue = new PrincipaleVue();

        // Création des boutons
        monBouton = new JButton("Crée un projet");
        submitButton = new JButton("Créer le projet");

        monBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vue.showForm(submitButton);
            }
        });

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nom = vue.getNom();
                String type = vue.getType();
                String description = vue.getDescription();
                Projet projet = new Projet(nom, type, description);
                System.out.println(nom +" " + type +" "+ description);
                modele.addProjet(projet);

                sectionVue = new SectionVue();


                controleurProjet = new ProjetControleur(projet);
                controleurNavBar = new NavBarControleur(controleurProjet.getVue(), sectionVue);


                vue.showNavBar(controleurNavBar.getVue());
                vue.showSection(sectionVue);
            }
        });

        vue.showMainView(monBouton);
    }

    public PrincipaleVue getVue() {
        return this.vue;
    }
}

package trellolite.controleurs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import trellolite.vues.PrincipaleVue;
import trellolite.modeles.*;
public class PrincipaleControleur {
    private PrincipaleVue vue;
    private Principale modele;
    private JButton monBouton;
    private JButton submitButton;

    public PrincipaleControleur(Principale modele) {
        this.modele = modele;
        this.vue = new PrincipaleVue();

        // Création des boutons
        monBouton = new JButton("Mon Bouton");
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

                vue.showMainView(monBouton);
            }
        });

        vue.showMainView(monBouton);
    }

    public PrincipaleVue getVue() {
        return this.vue;
    }
}

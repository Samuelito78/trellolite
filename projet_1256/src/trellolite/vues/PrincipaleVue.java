package trellolite.vues;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class PrincipaleVue extends JPanel {

    public PrincipaleVue() {
        //Créer un bouton
        JButton myButton = new JButton("Mon Bouton");

        //Ajouter le bouton au panel
        this.add(myButton);

        //Définir le layout du panel
        this.setLayout(new FlowLayout());

        //Définir la taille préférée du panel
        this.setPreferredSize(new Dimension(400, 300));
    }
}

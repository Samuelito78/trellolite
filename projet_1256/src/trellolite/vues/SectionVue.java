package trellolite.vues;

import javax.swing.*;
import java.awt.*;

public class SectionVue extends JPanel {
    private JLabel label;
    public SectionVue(){
        this.label = new JLabel("ok");
        add(label);
    }

    public void afficheTableaux(){
        label.setText("Tableaux de bord");
    }

    public void afficheActivites(){
        label.setText("Activités");
    }

    public void afficheMembres(){
        label.setText("Membres");
    }

    public void afficheReunions(){
        label.setText("Reunions");
    }

    public void afficheParamètres(){
        label.setText("Paramètres");
    }
}

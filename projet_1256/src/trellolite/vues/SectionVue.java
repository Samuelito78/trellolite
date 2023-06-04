package trellolite.vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SectionVue extends JPanel {
    private JLabel label;
    public SectionVue(){
        setLayout(new BorderLayout());
        setBackground(Color.decode("#1F1F1F"));
        setBorder(new EmptyBorder(0, 100, 0, 100));
        this.label = new JLabel();
    }

    public void afficheTableaux(JPanel tableauVue){
        removeAll();
        add(tableauVue);
        revalidate();
        repaint();
    }

    public void afficheListe(JPanel liste){
        removeAll();
        add(liste);
        revalidate();
        repaint();
    }

    public void afficheCarte(JPanel carte){
        removeAll();
        add(carte);
        revalidate();
        repaint();
    }

    public void afficheMembres(JPanel membreVue){
        removeAll();
        add(membreVue);
        revalidate();
        repaint();
    }

    public void afficheReunions(JPanel reunionVue){
        removeAll();
        add(reunionVue);
        revalidate();
        repaint();
    }

    public void afficheParamètres(JPanel parametreVue){
        removeAll();
        add(parametreVue);
        revalidate();
        repaint();
    }

}

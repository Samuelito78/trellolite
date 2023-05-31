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
        System.out.println("ok");
        revalidate();
        repaint();
    }

    public void afficheListe(JPanel liste){
        removeAll();
        add(liste);
        System.out.println("ok");
        revalidate();
        repaint();
    }

    public void afficheActivites(){
        removeAll();
        add(label);
        label.setText("Reunions");
        revalidate();
        repaint();
    }

    public void afficheMembres(){
        removeAll();
        add(label);
        label.setText("Membres");
        revalidate();
        repaint();
    }

    public void afficheReunions(JPanel reunionVue){
        removeAll();
        add(reunionVue);
        System.out.println("ok");
        revalidate();
        repaint();
    }

    public void afficheParamètres(){
        removeAll();
        add(label);
        label.setText("Paramètres");
        revalidate();
        repaint();
    }
}

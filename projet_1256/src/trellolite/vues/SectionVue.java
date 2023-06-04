package trellolite.vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SectionVue extends JPanel {
    private JLabel label;

    /**
     * Constructeur de la classe SectionVue. Initialise le layout, la couleur de fond et la bordure.
     */
    public SectionVue() {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#1F1F1F"));
        setBorder(new EmptyBorder(0, 100, 0, 100));
        this.label = new JLabel();
    }

    /**
     * Affiche la vue d'un tableau.
     * @param tableauVue le JPanel représentant la vue d'un tableau.
     */
    public void afficheTableaux(JPanel tableauVue) {
        removeAll();
        add(tableauVue);
        revalidate();
        repaint();
    }

    /**
     * Affiche la vue d'une liste.
     * @param liste le JPanel représentant la vue d'une liste.
     */
    public void afficheListe(JPanel liste) {
        removeAll();
        add(liste);
        revalidate();
        repaint();
    }

    /**
     * Affiche la vue d'une carte.
     * @param carte le JPanel représentant la vue d'une carte.
     */
    public void afficheCarte(JPanel carte) {
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

    /**
     * Affiche la vue des réunions.
     * @param reunionVue le JPanel représentant la vue des réunions.
     */
    public void afficheReunions(JPanel reunionVue) {
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

package trellolite.vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * La classe SectionVue est un JPanel personnalisé qui affiche différents composants en fonction de la méthode appelée.
 * elle permet de changer le contenu affiché dans une section de l'application.
 * 
 * @author Samuel Boix-Segura
 */
public class SectionVue extends JPanel {
    private JLabel label;

    /**
     * Constructeur de la classe SectionVue.
     * Initialise la vue avec un BorderLayout, une couleur de fond et une bordure.
     */
    public SectionVue() {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#1F1F1F"));
        setBorder(new EmptyBorder(0, 100, 0, 100));
        this.label = new JLabel();
    }

    /**
     * Affiche un JPanel de type "tableau" dans la vue.
     *
     * @param tableauVue Le JPanel contenant le tableau à afficher.
     */
    public void afficheTableaux(JPanel tableauVue) {
        removeAll();
        add(tableauVue);
        revalidate();
        repaint();
    }

    /**
     * Affiche un JPanel de type "liste" dans la vue.
     *
     * @param liste Le JPanel contenant la liste à afficher.
     */
    public void afficheListe(JPanel liste) {
        removeAll();
        add(liste);
        revalidate();
        repaint();
    }

    /**
     * Affiche un JPanel de type "carte" dans la vue.
     *
     * @param carte Le JPanel contenant la carte à afficher.
     */
    public void afficheCarte(JPanel carte) {
        removeAll();
        add(carte);
        revalidate();
        repaint();
    }

    /**
     * Affiche un JPanel de type "membres" dans la vue.
     *
     * @param membreVue Le JPanel contenant les membres à afficher.
     */
    public void afficheMembres(JPanel membreVue) {
        removeAll();
        add(membreVue);
        revalidate();
        repaint();
    }

    /**
     * Affiche un JPanel de type "réunions" dans la vue.
     *
     * @param reunionVue Le JPanel contenant les réunions à afficher.
     */
    public void afficheReunions(JPanel reunionVue) {
        removeAll();
        add(reunionVue);
        revalidate();
        repaint();
    }

    /**
     * Affiche un JPanel de type "paramètres" dans la vue.
     *
     * @param parametreVue Le JPanel contenant les paramètres à afficher.
     */
    public void afficheParamètres(JPanel parametreVue) {
        removeAll();
        add(parametreVue);
        revalidate();
        repaint();
    }
}

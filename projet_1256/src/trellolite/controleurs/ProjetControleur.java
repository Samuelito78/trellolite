package trellolite.controleurs;

import trellolite.modeles.Projet;
import trellolite.vues.ProjetVue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Le contrôleur pour la gestion d'un projet.
 * Cette classe est responsable de la gestion de l'interaction entre le modèle Projet et la vue ProjetVue.
 * Elle crée et configure le bouton représentant le projet, y ajoute une icône et des styles,
 * crée une instance de ProjetVue et associe le projet à cette vue.
 *
 * @author Nawfel Kerarsi
 */
public class ProjetControleur {
    private ProjetVue vue;
    private Projet projet;
    private JButton projectButton;

    /**
     * Constructeur de la classe ProjetControleur.
     * @param projet l'instance du modèle Projet.
     */
    public ProjetControleur(Projet projet) {
        this.projet = projet;
        ImageIcon upIcon = new ImageIcon("src/trellolite/ressources/images/upIcon.png");
        JButton projectButton = new JButton("<html><b>"+projet.getNom()+"</b><html>");
        JLabel rightLabel = new JLabel(upIcon);
        projectButton.setLayout(new BorderLayout());
        rightLabel.setBorder(new EmptyBorder(0, 0, 0, 20)); // Ajout de la marge de 20px à droite
        projectButton.add(rightLabel, BorderLayout.EAST);

        // Ajout de l'icône à gauche
        ImageIcon icon = new ImageIcon("src/trellolite/ressources/images/ligne18.png");
        icon = resizeIcon(icon, 60, 60);
        projectButton.setIcon(icon);
        projectButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        projectButton.setHorizontalAlignment(SwingConstants.LEFT);

        // Configuration du bouton
        projectButton.setPreferredSize(new Dimension(260, 60));
        projectButton.setBorder(new EmptyBorder(0, 0, 0, 0));
        projectButton.setBackground(Color.decode("#343435"));
        projectButton.setIconTextGap(20);
        projectButton.setOpaque(true);
        projectButton.setFont(new Font(projectButton.getFont().getName(), projectButton.getFont().getStyle(), 15));
        projectButton.setForeground(Color.white);

        this.vue = new ProjetVue(projectButton);
        this.vue.setProjet(projet);
    }

    /**
     * Redimensionne une ImageIcon à la taille spécifiée.
     * @param icon l'ImageIcon à redimensionner.
     * @param width la largeur souhaitée.
     * @param height la hauteur souhaitée.
     * @return l'ImageIcon redimensionnée.
     */
    private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    /**
     * Renvoie l'instance du modèle Projet associée à ce contrôleur.
     * @return l'instance du modèle Projet.
     */
    public Projet getProjet() {
        return this.projet;
    }

    /**
     * Renvoie l'instance de la vue ProjetVue associée à ce contrôleur.
     * @return l'instance de la vue ProjetVue.
     */
    public ProjetVue getVue() {
        return this.vue;
    }
}

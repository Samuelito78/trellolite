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

    private static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public ProjetVue getVue() {
        return this.vue;
    }
}

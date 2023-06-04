package trellolite.controleurs;
import trellolite.modeles.Principale;
import trellolite.modeles.Projet;
import trellolite.vues.ProjetVue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProjetControleur {
    private ProjetVue vue;
    private Projet projet;
    private JButton projectButton;
    private JPopupMenu popupMenuProjet;
    private PrincipaleControleur principaleControleur;
    private Principale principale;
    public ProjetControleur(Projet projet, PrincipaleControleur principaleControleur, Principale principale) {
        this.projet = projet;
        this.principale = principale;
        this.principaleControleur = principaleControleur;
        ImageIcon upIcon = new ImageIcon("src/trellolite/ressources/images/upIcon.png");
        JButton projectButton = new JButton("<html><b>"+projet.getNom()+"</b><html>");
        JLabel rightLabel = new JLabel(upIcon);
        projectButton.setLayout(new BorderLayout());
        rightLabel.setBorder(new EmptyBorder(0, 0, 0, 20)); // Ajout de la marge de 20px à droite
        projectButton.add(rightLabel, BorderLayout.EAST);

        // Ajout de l'icône à gauche
        projectButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        projectButton.setHorizontalAlignment(SwingConstants.LEFT);

        // Configuration du bouton
        projectButton.setPreferredSize(new Dimension(260, 60));
        projectButton.setBorder(new EmptyBorder(0, 20, 0, 0));
        projectButton.setBackground(Color.decode("#343435"));
        projectButton.setOpaque(true);
        projectButton.setFont(new Font(projectButton.getFont().getName(), projectButton.getFont().getStyle(), 15));
        projectButton.setForeground(Color.white);


        this.vue = new ProjetVue(projectButton);
        this.vue.setProjet(projet);

        popupMenuProjet = new JPopupMenu();

        JMenuItem createProjet = new JMenuItem("Créer un projet");
        for (Projet pjt : principale.getProjets()) {
            if (pjt.equals(projet)) continue;
            JMenuItem pjtItem = new JMenuItem(pjt.getNom());
            pjtItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    principaleControleur.changeProjet(pjt);
                }
            });
            popupMenuProjet.add(pjtItem);
        }


        createProjet.setForeground(Color.black);

        popupMenuProjet.add(createProjet);
        projectButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    popupMenuProjet.show(me.getComponent(), me.getX(), me.getY());
                }
            }
        });

        createProjet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                principaleControleur.getVue().showForm(principaleControleur.getSubmitButton());
            }
        });


    }

    private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public Projet getProjet(){
        return this.projet;
    }

    public ProjetVue getVue() {
        return this.vue;
    }

    public void updateProjetPopupMenu(Projet projet) {
        popupMenuProjet.removeAll();  // Clear existing items
        JMenuItem createProjet = new JMenuItem("Créer un projet");
        for (Projet pjt : principale.getProjets()) {
            if (pjt.equals(projet)) continue;  // Don't add the current project

            JMenuItem pjtItem = new JMenuItem(pjt.getNom());
            pjtItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    principaleControleur.changeProjet(pjt);
                }
            });

            popupMenuProjet.add(pjtItem);
        }

        createProjet.setForeground(Color.black);

        createProjet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                principaleControleur.getVue().showForm(principaleControleur.getSubmitButton());
            }
        });


        popupMenuProjet.add(createProjet);
    }
}

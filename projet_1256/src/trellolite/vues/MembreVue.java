package trellolite.vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * La classe MembreVue représente la vue des membres dans l'application.
 * Elle étend la classe JPanel.
 */
public class MembreVue extends JPanel {

    JPanel headPanel;
    JPanel bodyPanel;
    JLabel titlePanel;
    JLabel subtitlePanel;
    JPanel membresPanel;
    JPanel membreContainer;

    /**
     * Constructeur de la classe MembreVue.
     * @param listesutilisateurs La liste des utilisateurs.
     * @param listeComboBox La liste des JComboBox associées aux utilisateurs.
     */
    public MembreVue(ArrayList<String> listesutilisateurs, ArrayList<JComboBox<String>> listeComboBox) {
        setLayout(new BorderLayout());
        setOpaque(false);

        // Création et configuration du panneau d'en-tête
        headPanel = new JPanel();
        headPanel.setLayout(new BorderLayout());
        headPanel.setOpaque(false);
        headPanel.setPreferredSize(new Dimension(headPanel.getWidth(), 75));

        // Création et configuration du panneau principal
        bodyPanel = new JPanel();
        bodyPanel.setLayout(new GridBagLayout());
        bodyPanel.setOpaque(false);

        // Ajout d'une bordure inférieure de 1px avec la couleur #363636
        headPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#363636")));

        // Création et configuration du titre
        this.titlePanel = new JLabel("<html><b>Membres</b></html>");
        titlePanel.setFont(new Font(titlePanel.getFont().getName(), titlePanel.getFont().getStyle(), 26));
        titlePanel.setForeground(Color.white);

        String subtitleText = "LES MEMBRES";
        // Création et configuration du sous-titre
        this.subtitlePanel = new JLabel(subtitleText);
        subtitlePanel.setPreferredSize(new Dimension(bodyPanel.getWidth(), 60));
        subtitlePanel.setForeground(Color.decode("#B9B9B9"));

        // Ajout du titre au panneau d'en-tête à l'ouest
        headPanel.add(titlePanel, BorderLayout.WEST);

        // Configuration des contraintes pour le sous-titre
        GridBagConstraints gbcSubTitle = new GridBagConstraints();
        gbcSubTitle.fill = GridBagConstraints.HORIZONTAL;
        gbcSubTitle.gridx = 0;
        gbcSubTitle.gridy = 0;
        gbcSubTitle.weightx = 1.0;

        // Ajout du sous-titre au panneau principal
        bodyPanel.add(subtitlePanel, gbcSubTitle);

        // Création du panneau pour les membres
        membresPanel = new JPanel();
        membresPanel.setLayout(new BoxLayout(membresPanel, BoxLayout.Y_AXIS));
        membresPanel.setOpaque(false);

        // Parcours de la liste des utilisateurs
        for (int i = 0; i < listesutilisateurs.size(); i++) {
            JPanel membrePanel = new JPanel(new BorderLayout());
            membrePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
            JLabel nomEtPrenomLabel = new JLabel("<html><b style='font-size: 11px'>" + listesutilisateurs.get(i) + "</b><html>");
            nomEtPrenomLabel.setForeground(Color.white);
            nomEtPrenomLabel.setBorder(new EmptyBorder(0, 20, 0, 0));

            // Ajout de la JComboBox associée à l'utilisateur à l'est du panneau du membre
            membrePanel.add(listeComboBox.get(i), BorderLayout.EAST);
            membrePanel.add(nomEtPrenomLabel);
            membrePanel.setBackground(Color.decode("#111111"));

            // Ajout du panneau du membre au panneau des membres
            membresPanel.add(membrePanel);
        }

        // Configuration des contraintes pour le panneau des membres
        GridBagConstraints gbcReunionPanel = new GridBagConstraints();
        gbcReunionPanel.fill = GridBagConstraints.BOTH;
        gbcReunionPanel.gridx = 0;
        gbcReunionPanel.gridy = 1;
        gbcReunionPanel.weightx = 1.0;
        gbcReunionPanel.weighty = 1.0;

        // Ajout du panneau des membres au panneau principal
        bodyPanel.add(membresPanel, gbcReunionPanel);

        // Création du panneau pour les boutons
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Ajout du panneau des boutons au panneau d'en-tête à l'est
        headPanel.add(buttonPanel, BorderLayout.EAST);

        // Ajout du panneau d'en-tête au panneau principal au nord
        add(headPanel, BorderLayout.NORTH);
        // Ajout du panneau principal au panneau courant au centre
        add(bodyPanel, BorderLayout.CENTER);
    }

    public void setUtilisateurs(ArrayList<String> listesutilisateurs, ArrayList<JComboBox<String>> listeComboBox) {
        membresPanel.removeAll(); // Supprime tous les membres existants

        // Ajoute de nouveaux membres
        for (int i = 0; i < listesutilisateurs.size(); i++) {
            JPanel membrePanel = new JPanel(new BorderLayout());
            membrePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
            JLabel nomEtPrenomLabel = new JLabel("<html><b style='font-size: 11px'>" + listesutilisateurs.get(i) + "</b><html>");
            nomEtPrenomLabel.setForeground(Color.white);
            nomEtPrenomLabel.setBorder(new EmptyBorder(0, 20, 0, 0));

            membrePanel.add(listeComboBox.get(i), BorderLayout.EAST);
            membrePanel.add(nomEtPrenomLabel);
            membrePanel.setBackground(Color.decode("#111111"));

            membresPanel.add(membrePanel);
        }

        // Force le rafraîchissement du panneau membresPanel
        membresPanel.revalidate();
        membresPanel.repaint();
    }


}

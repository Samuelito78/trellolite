package trellolite.vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * La classe ReunionVue représente la vue des réunions dans l'application. Elle affiche les réunions
 * existantes, permet la création de nouvelles réunions et met à jour la page des réunions en fonction
 * des modifications apportées.
 */
public class ReunionVue extends JPanel {
    private JLabel titlePanel;
    private JLabel subtitlePanel;
    private JPanel headPanel;
    private JPanel bodyPanel;
    private ArrayList<JButton> reunionBtnList;
    private JPanel reunionPanel;

    private JTextField nomReunionField;

    /**
     * Constructeur de la vue de réunion.
     *
     * @param creeReunionBtn   Le bouton pour créer une réunion
     * @param reunionBtnList   La liste des boutons de réunion existants
     */
    public ReunionVue(JButton creeReunionBtn, ArrayList<JButton> reunionBtnList) {
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
        this.titlePanel = new JLabel("<html><b>Réunions</b></html>");
        titlePanel.setFont(new Font(titlePanel.getFont().getName(), titlePanel.getFont().getStyle(), 26));
        titlePanel.setForeground(Color.white);

        // Création du texte du sous-titre en fonction de la présence ou de l'absence de réunions
        String subtitleText = (reunionBtnList != null && reunionBtnList.size() > 0) ? "VOS REUNIONS" : "VOUS N'AVEZ AUCUNE REUNION";
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

        // Création du panneau pour les réunions
        reunionPanel = new JPanel();
        reunionPanel.setOpaque(false);

        // Configuration des contraintes pour le panneau des réunions
        GridBagConstraints gbcReunionPanel = new GridBagConstraints();
        gbcReunionPanel.fill = GridBagConstraints.BOTH;
        gbcReunionPanel.gridx = 0;
        gbcReunionPanel.gridy = 1;
        gbcReunionPanel.weightx = 1.0;
        gbcReunionPanel.weighty = 1.0;

        // Ajout du panneau des réunions au panneau principal
        bodyPanel.add(reunionPanel, gbcReunionPanel);

        // Création du panneau pour les boutons
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        // Configuration des contraintes pour les boutons
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Ajout du bouton de création de réunion au panneau des boutons
        buttonPanel.add(creeReunionBtn, gbc);

        // Ajout du panneau des boutons au panneau d'en-tête à l'est
        headPanel.add(buttonPanel, BorderLayout.EAST);

        // Ajout du panneau d'en-tête au panneau principal au nord
        add(headPanel, BorderLayout.NORTH);
        // Ajout du panneau principal au panneau courant au centre
        add(bodyPanel, BorderLayout.CENTER);
    }

    /**
     * Met à jour la page des réunions en fonction de la liste de boutons de réunion fournie.
     *
     * @param reunionBtnList   La liste des boutons de réunion existants
     */
    public void refreshPage(ArrayList<JButton> reunionBtnList) {
        // Mise à jour du texte du sous-titre en fonction de la présence ou de l'absence de réunions
        String subtitleText = (reunionBtnList != null && reunionBtnList.size() > 0) ? "VOS REUNIONS" : "VOUS N'AVEZ AUCUNE REUNION";
        this.subtitlePanel.setText(subtitleText);
        reunionPanel.removeAll();

        // Calcul du nombre de colonnes pour l'affichage des boutons de réunion
        int numColumns = 4;
        reunionPanel.setLayout(new GridLayout(0, numColumns, 10, 10));

        // Ajout des boutons de réunion au panneau des réunions
        for (JButton reunionBtn : reunionBtnList) {
            reunionPanel.add(reunionBtn);
        }

        // Ajout de panneaux vides pour remplir les espaces restants
        int emptyPanelsCount = numColumns - (reunionBtnList.size() % numColumns);
        for (int k = 0; k < emptyPanelsCount; k++) {
            JPanel emptyPanel = new JPanel();
            emptyPanel.setOpaque(false);
            reunionPanel.add(emptyPanel);
        }

        // Rafraîchissement du panneau des réunions pour prendre en compte les modifications
        reunionPanel.revalidate();
        reunionPanel.repaint();
    }

    /**
     * Affiche le formulaire de création de réunion dans une boîte de dialogue.
     *
     * @param submitReunionBtn   Le bouton de soumission du formulaire
     * @param returnReunionBtn   Le bouton de retour
     * @param dialog             La boîte de dialogue
     */
    public void afficheForm(JButton submitReunionBtn, JButton returnReunionBtn, JDialog dialog) {
        // Configuration de la boîte de dialogue
        dialog.setModal(true);
        dialog.setUndecorated(true);
        dialog.setTitle("Formulaire de création de réunion");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Ajustement de la taille de la boîte de dialogue
        dialog.setResizable(false);

        // Création du panneau de formulaire
        JPanel formPanel = new JPanel(new BorderLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Configuration de la couleur de fond du panneau de formulaire
        formPanel.setBackground(Color.decode("#252526"));

        // Ajout du label pour le nom de la réunion
        JLabel label = new JLabel("Nom de la réunion");
        label.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 10));
        label.setForeground(Color.WHITE);
        formPanel.add(label, BorderLayout.NORTH);

        // Champ de saisie pour le nom de la réunion
        this.nomReunionField = new JTextField();
        this.nomReunionField.setBackground(Color.decode("#111111"));
        this.nomReunionField.setForeground(Color.WHITE);
        this.nomReunionField.setPreferredSize(new Dimension(nomReunionField.getPreferredSize().width, 40));
        formPanel.add(this.nomReunionField, BorderLayout.CENTER);

        // Panneau pour les boutons de soumission et de retour
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.decode("#252526"));

        // Personnalisation du bouton de soumission
        submitReunionBtn.setPreferredSize(new Dimension(140, 40));
        submitReunionBtn.setBackground(Color.decode("#1a8754"));
        submitReunionBtn.setForeground(Color.WHITE);
        submitReunionBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        submitReunionBtn.setOpaque(true);

        // Personnalisation du bouton de retour
        returnReunionBtn.setPreferredSize(new Dimension(returnReunionBtn.getPreferredSize().width, 40));
        returnReunionBtn.setBackground(Color.decode("#252526"));
        returnReunionBtn.setForeground(Color.WHITE);
        returnReunionBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        returnReunionBtn.setOpaque(true);

        // Ajout des boutons au panneau de boutons
        buttonPanel.add(returnReunionBtn);
        buttonPanel.add(submitReunionBtn);
        formPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Ajout du panneau de formulaire à la boîte de dialogue
        dialog.add(formPanel);

        // Affichage de la boîte de dialogue
        dialog.pack();

        // Calcul et définition de la position de la boîte de dialogue pour la centrer par rapport au JPanel
        Point location = this.getLocationOnScreen();
        int x = location.x + this.getWidth() / 2 - dialog.getWidth() / 2;
        int y = location.y + this.getHeight() / 2 - dialog.getHeight() / 2;
        dialog.setLocation(x, y);

        // Rendre la boîte de dialogue visible
        dialog.setVisible(true);
    }

    /**
     * Récupère le nom de la réunion à partir du champ de saisie.
     *
     * @return Le nom de la réunion
     */
    public String getNom() {
        return this.nomReunionField.getText();
    }
}

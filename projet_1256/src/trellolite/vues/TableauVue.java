package trellolite.vues;

import trellolite.modeles.Tableau;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

/**
 * La classe TableauVue représente la vue d'un tableau dans l'application.
 * Cette vue affiche les boutons des tableaux dans un panneau, ainsi qu'un formulaire de création de tableau.
 *
 * @auther Nawfel Kerarsi
 */
public class TableauVue extends JPanel {

    // Les attributs de classe pour le titre et le panneau d'en-tête
    private JLabel titlePanel;
    private JLabel subttitlePanel;
    private JPanel headPanel;
    private JPanel bodyPanel;
    private ArrayList<JButton> tableauBtnList;
    private JPanel tableauPanel;

    private JTextField nomTableauField;

    /**
     * Constructeur de la classe TableauVue.
     *
     * @param creeTableauBtn Le bouton pour créer un nouveau tableau.
     * @param reunionBtnList La liste des boutons pour les réunions.
     */
    public TableauVue(JButton creeTableauBtn, ArrayList<JButton> reunionBtnList){
        // Configuration du layout et de la couleur de fond de ce JPanel
        setLayout(new BorderLayout());
        setOpaque(false);

        // Initialisation et configuration du panneau d'en-tête
        headPanel = new JPanel();
        headPanel.setLayout(new BorderLayout());
        headPanel.setOpaque(false);
        // Définition de la taille préférée pour forcer la hauteur à 75px
        headPanel.setPreferredSize(new Dimension(headPanel.getWidth(), 75));

        // Initialisation et configuration du panneau général
        bodyPanel = new JPanel();
        bodyPanel.setLayout(new GridBagLayout());
        bodyPanel.setOpaque(false);

        // Ajout d'une bordure de 1px en bas du headPanel avec la couleur #363636
        headPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#363636")));

        // Initialisation et configuration du titre
        this.titlePanel = new JLabel("<html><b>Tableau de bord</b></html>");
        titlePanel.setFont(new Font(titlePanel.getFont().getName(), titlePanel.getFont().getStyle(), 26));
        titlePanel.setForeground(Color.white);

        // Initialisation et configuration du sous-titre
        String subtitleText = (tableauBtnList != null && tableauBtnList.size() > 0) ? "VOS TABLEAUX" : "VOUS N'AVEZ AUCUN TABLEAU";
        this.subttitlePanel = new JLabel(subtitleText);
        subttitlePanel.setPreferredSize(new Dimension(bodyPanel.getWidth(),60));
        subttitlePanel.setForeground(Color.decode("#B9B9B9"));

        // Ajout du titre et du sous-titre au panneau d'en-tête
        headPanel.add(titlePanel, BorderLayout.WEST);

        // Configuration des contraintes pour subttitlePanel
        GridBagConstraints gbcSubTitle = new GridBagConstraints();
        gbcSubTitle.fill = GridBagConstraints.HORIZONTAL;
        gbcSubTitle.gridx = 0;
        gbcSubTitle.gridy = 0;
        gbcSubTitle.weightx = 1.0;

        bodyPanel.add(subttitlePanel, gbcSubTitle);

        // Initialisation et configuration du panneau tableau
        tableauPanel = new JPanel();
        tableauPanel.setOpaque(false);

        // Ajout du panneau tableau au panneau général
        GridBagConstraints gbcTableauPanel = new GridBagConstraints();
        gbcTableauPanel.fill = GridBagConstraints.BOTH;
        gbcTableauPanel.gridx = 0;
        gbcTableauPanel.gridy = 1; // Ajouter tableauPanel en dessous de subttitlePanel
        gbcTableauPanel.weightx = 1.0;
        gbcTableauPanel.weighty = 1.0;
        bodyPanel.add(tableauPanel, gbcTableauPanel);

        // Création d'un nouveau JPanel pour le bouton
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        // Ajout du bouton au panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; // Fait en sorte que le bouton prenne la largeur du panel parent
        gbc.weightx = 1.0; // Pour que le bouton reste au centre horizontalement
        gbc.weighty = 1.0; // Pour que le bouton reste au centre verticalement

        buttonPanel.add(creeTableauBtn, gbc);

        // Ajout du bouton au panneau d'en-tête à droite
        headPanel.add(buttonPanel, BorderLayout.EAST);

        // Ajout du panneau d'en-tête et du panneau général à ce JPanel
        add(headPanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.CENTER);
    }

    /**
     * Rafraîchit la page en mettant à jour les boutons des tableaux.
     *
     * @param tableauBtnList La liste des boutons des tableaux.
     */
    public void refreshPage(ArrayList<JButton> tableauBtnList) {
        String subtitleText = (tableauBtnList != null && tableauBtnList.size() > 0) ? "VOS TABLEAUX" : "VOUS N'AVEZ AUCUN TABLEAU";
        this.subttitlePanel.setText(subtitleText);
        tableauPanel.removeAll(); // Effacer les boutons précédents

        int numColumns = 4; // Nombre de colonnes souhaité
        tableauPanel.setLayout(new GridLayout(0, numColumns, 10, 10)); // Utiliser GridLayout avec 0 lignes pour ajuster automatiquement le nombre de lignes

        for (JButton tableauBtn : tableauBtnList) {
            tableauPanel.add(tableauBtn);
        }
        for (int k=0; k<8;k++) {
            JPanel PanelVide = new JPanel();
            PanelVide.setOpaque(false);
            tableauPanel.add(PanelVide);
        }

        tableauPanel.revalidate();
        tableauPanel.repaint();
    }

    /**
     * Affiche le formulaire de création de tableau dans une JDialog modale.
     *
     * @param submitTableauBtn Le bouton de soumission du formulaire.
     * @param returnTableauBtn Le bouton de retour du formulaire.
     * @param dialog           La JDialog utilisée pour afficher le formulaire.
     */
    public void afficheForm(JButton submitTableauBtn, JButton returnTableauBtn, JDialog dialog){
        // Création de la JDialog
        dialog.setModal(true);
        dialog.setUndecorated(true);
        dialog.setTitle("Formulaire de création de tableau");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Ajuste la taille de la JDialog
        dialog.setResizable(false);

        // Création du formulaire
        JPanel formPanel = new JPanel(new BorderLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Setting the background color
        formPanel.setBackground(Color.decode("#252526"));

        // Ajout du label
        JLabel label = new JLabel("Nom du tableau");
        label.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 10));
        label.setForeground(Color.WHITE);
        formPanel.add(label, BorderLayout.NORTH);

        // Champ de saisie pour le nom du tableau
        this.nomTableauField = new JTextField();
        this.nomTableauField.setBackground(Color.decode("#111111"));
        this.nomTableauField.setForeground(Color.WHITE);
        this.nomTableauField.setPreferredSize(new Dimension(nomTableauField.getPreferredSize().width, 40));
        formPanel.add(this.nomTableauField, BorderLayout.CENTER);

        // Boutons submit et return
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.decode("#252526"));

        // Personnalisation du bouton submitTableauBtn
        submitTableauBtn.setPreferredSize(new Dimension(140, 40));
        submitTableauBtn.setBackground(Color.decode("#1a8754"));
        submitTableauBtn.setForeground(Color.WHITE);
        submitTableauBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        submitTableauBtn.setOpaque(true);
        // Personnalisation du bouton returnTableauBtn
        returnTableauBtn.setPreferredSize(new Dimension(returnTableauBtn.getPreferredSize().width, 40));
        returnTableauBtn.setBackground(Color.decode("#252526"));
        returnTableauBtn.setForeground(Color.WHITE);
        returnTableauBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        returnTableauBtn.setOpaque(true);
        buttonPanel.add(returnTableauBtn);
        buttonPanel.add(submitTableauBtn);
        formPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Ajout du formulaire à la JDialog
        dialog.add(formPanel);

        // Affichage de la JDialog
        dialog.pack();

        // Calcul et définition de la position de la JDialog pour la centrer par rapport à la JPanel
        Point location = this.getLocationOnScreen();
        int x = location.x + this.getWidth()/2 - dialog.getWidth()/2;
        int y = location.y + this.getHeight()/2 - dialog.getHeight()/2;
        dialog.setLocation(x, y);

        // Rendre la JDialog visible
        dialog.setVisible(true);
    }

    /**
     * Récupère le nom saisi dans le formulaire de création de tableau.
     *
     * @return Le nom saisi dans le champ de texte du formulaire.
     */
    public String getNom() {
        return this.nomTableauField.getText();
    }
}

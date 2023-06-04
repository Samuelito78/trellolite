package trellolite.vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class ListeVue extends JPanel {

    private JLabel titlePanel;
    private JLabel subttitlePanel;
    private JPanel headPanel;
    private JScrollPane bodyPanel;
    private ArrayList<JButton> listeBtnList;
    private JPanel listePanel;

    private JTextField nomField;

    /**
     * Constructeur de la classe ListeVue.
     * Crée une vue pour afficher les listes d'un tableau.
     *
     * @param creeListeBtn     Le bouton pour créer une nouvelle liste.
     * @param listePanelliste  La liste des panneaux de listes.
     * @param nom              Le nom du tableau.
     */
    public ListeVue(JButton creeListeBtn, ArrayList<JPanel> listePanelliste, String nom){
        // Configuration du layout et de l'opacité du JPanel
        setLayout(new BorderLayout());
        setOpaque(false);

        // Configuration du panneau d'en-tête
        headPanel = new JPanel();
        headPanel.setLayout(new BorderLayout());
        headPanel.setOpaque(false);
        headPanel.setPreferredSize(new Dimension(headPanel.getWidth(), 75));

        // Configuration du panneau de contenu
        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setOpaque(false);

        // Configuration du panneau de défilement avec le panneau de contenu
        bodyPanel = new JScrollPane(contentPanel);
        bodyPanel.setOpaque(false);
        bodyPanel.getViewport().setOpaque(false);
        bodyPanel.getVerticalScrollBar().setOpaque(false);
        bodyPanel.setBorder(null);
        ((JPanel) bodyPanel.getViewport().getView()).setOpaque(false);

        // Configuration de la bordure inférieure du panneau d'en-tête avec la couleur #363636
        headPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#363636")));

        // Configuration du titre
        this.titlePanel = new JLabel("<html><b>"+nom+"</b></html>");
        titlePanel.setFont(new Font(titlePanel.getFont().getName(), titlePanel.getFont().getStyle(), 26));
        titlePanel.setForeground(Color.white);

        // Configuration du sous-titre
        this.subttitlePanel = new JLabel();
        subttitlePanel.setPreferredSize(new Dimension(bodyPanel.getWidth(),60));
        subttitlePanel.setForeground(Color.decode("#B9B9B9"));

        // Ajout du titre au panneau d'en-tête à gauche
        headPanel.add(titlePanel, BorderLayout.WEST);

        // Configuration des contraintes pour le sous-titre
        GridBagConstraints gbcSubTitle = new GridBagConstraints();
        gbcSubTitle.fill = GridBagConstraints.HORIZONTAL;
        gbcSubTitle.gridx = 0;
        gbcSubTitle.gridy = 0;
        gbcSubTitle.weightx = 1.0;

        // Ajout du sous-titre au panneau de contenu
        ((JPanel)bodyPanel.getViewport().getView()).add(subttitlePanel, gbcSubTitle);

        // Configuration du panneau des listes
        listePanel = new JPanel();
        listePanel.setOpaque(false);

        // Configuration des contraintes pour le panneau des listes
        GridBagConstraints gbcListePanel = new GridBagConstraints();
        gbcListePanel.fill = GridBagConstraints.BOTH;
        gbcListePanel.gridx = 0;
        gbcListePanel.gridy = 1;
        gbcListePanel.weightx = 1.0;
        gbcListePanel.weighty = 1.0;

        // Ajout du panneau des listes au panneau de contenu
        ((JPanel)bodyPanel.getViewport().getView()).add(listePanel, gbcListePanel);

        // Configuration du panneau des boutons
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        // Configuration des contraintes pour les boutons
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        // Ajout du bouton "Créer une liste" au panneau des boutons
        buttonPanel.add(creeListeBtn, gbc);

        // Ajout du panneau d'en-tête et du panneau de défilement à ce JPanel
        add(headPanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.CENTER);

        // Rafraîchissement de la page avec les listes fournies
        this.refreshPage(listePanelliste);
    }

        /**
     * Met à jour la page en affichant les panneaux des listes.
     *
     * @param listePanelliste La liste des panneaux de listes.
     */
    public void refreshPage(ArrayList<JPanel> listePanelliste) {
        // Détermination du texte du sous-titre en fonction de la présence ou non de listes
        String subtitleText = (listePanelliste != null && listePanelliste.size() > 0) ? "VOS LISTES" : "VOUS N'AVEZ AUCUNE LISTE";

        // Mise à jour du texte du sous-titre
        this.subttitlePanel.setText(subtitleText);

        // Suppression de tous les panneaux de listes précédents
        listePanel.removeAll();

        // Configuration du nombre de colonnes pour le GridLayout
        int numColumns = 3;

        // Configuration du GridLayout pour le panneau des listes
        listePanel.setLayout(new GridLayout(0, numColumns, 10, 10));

        // Ajout des nouveaux panneaux de listes à listePanel
        for (JPanel panelBtn : listePanelliste) {
            listePanel.add(panelBtn);
        }

        // Ajout de panneaux vides pour remplir les colonnes restantes
        for (int k=0; k<3;k++) {
            JPanel PanelVide = new JPanel();
            PanelVide.setOpaque(false);
            listePanel.add(PanelVide);
        }

        // Réaffichage et redessin des composants du panneau des listes
        listePanel.revalidate();
        listePanel.repaint();
    }


    /**
     * Affiche un formulaire pour créer une nouvelle liste.
     *
     * @param submitListeBtn  Le bouton de soumission du formulaire.
     * @param returnListeBtn  Le bouton de retour du formulaire.
     * @param dialog          La fenêtre de dialogue pour afficher le formulaire.
     * @param label           Le label du formulaire.
     */
    public void afficheForm(JButton submitListeBtn, JButton returnListeBtn, JDialog dialog, JLabel label){
        // Configuration de la fenêtre de dialogue
        dialog.setModal(true);
        dialog.setUndecorated(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);

        // Création du panneau de formulaire
        JPanel formPanel = new JPanel(new BorderLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        formPanel.setBackground(Color.decode("#252526"));

        // Ajout du label au panneau de formulaire
        label.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 10));
        label.setForeground(Color.WHITE);
        formPanel.add(label, BorderLayout.NORTH);

        // Création du champ de saisie pour le nom de la liste
        this.nomField = new JTextField();
        this.nomField.setBackground(Color.decode("#111111"));
        this.nomField.setForeground(Color.WHITE);
        this.nomField.setPreferredSize(new Dimension(nomField.getPreferredSize().width, 40));
        formPanel.add(this.nomField, BorderLayout.CENTER);

        // Création du panneau des boutons de soumission et de retour
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.decode("#252526"));

        // Personnalisation du bouton de soumission
        submitListeBtn.setPreferredSize(new Dimension(140, 40));
        submitListeBtn.setBackground(Color.decode("#1a8754"));
        submitListeBtn.setForeground(Color.WHITE);
        submitListeBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        submitListeBtn.setOpaque(true);

        // Personnalisation du bouton de retour
        returnListeBtn.setPreferredSize(new Dimension(returnListeBtn.getPreferredSize().width, 40));
        returnListeBtn.setBackground(Color.decode("#252526"));
        returnListeBtn.setForeground(Color.WHITE);
        returnListeBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        returnListeBtn.setOpaque(true);

        // Ajout des boutons au panneau des boutons
        buttonPanel.add(returnListeBtn);
        buttonPanel.add(submitListeBtn);
        formPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Ajout du panneau de formulaire à la fenêtre de dialogue
        dialog.add(formPanel);

        // Ajustement de la taille de la fenêtre de dialogue
        dialog.pack();

        // Calcul de la position de la fenêtre de dialogue pour la centrer par rapport à la vue actuelle
        Point location = this.getLocationOnScreen();
        int x = location.x + this.getWidth()/2 - dialog.getWidth()/2;
        int y = location.y + this.getHeight()/2 - dialog.getHeight()/2;
        dialog.setLocation(x, y);

        // Affichage de la fenêtre de dialogue
        dialog.setVisible(true);
    }


    /**
     * Récupère le nom de la nouvelle liste saisi dans le formulaire.
     *
     * @return Le nom de la nouvelle liste.
     */
    public String getNom() {
        return this.nomField.getText();
    }

}

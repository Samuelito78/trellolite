package trellolite.vues;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import trellolite.modeles.*;
import java.awt.*;

/**
 * La classe PrincipaleVue représente la vue principale de l'application.
 *
 * @author Samuel Boix-Segura
 */
public class PrincipaleVue extends JPanel {
    private JPanel sidebar;
    private JPanel formPanel;

    // Les composants du formulaire
    private JTextField nomField;
    private JComboBox<String> typeBox;
    private JTextArea descriptionArea;

    /**
     * Constructeur de la classe PrincipaleVue.
     */
    public PrincipaleVue() {
        // Initialisation des composants
        sidebar = new JPanel(new BorderLayout());
        sidebar.setPreferredSize(new Dimension(260, 0));
        sidebar.setBackground(Color.BLUE);

        formPanel = new JPanel(new GridLayout(0, 1));
        nomField = new JTextField(10);
        typeBox = new JComboBox<>(new String[]{ "Petite entreprise", "Ressources humaines", "Opérations", "Ingénierie & informatique", "Marketing", "Vente et gestion de la relation client", "Éducation", "Autre" });
        descriptionArea = new JTextArea();

        // Ajout des composants au panneau de formulaire
        formPanel.add(new JLabel("Nom:"));
        formPanel.add(nomField);
        formPanel.add(new JLabel("Type:"));
        formPanel.add(typeBox);
        formPanel.add(new JLabel("Description:"));
        formPanel.add(descriptionArea);
    }

    /**
     * Récupère le nom saisi dans le champ de texte du formulaire.
     * 
     * @return Le nom saisi.
     */
    public String getNom() {
        return this.nomField.getText();
    }

    /**
     * Récupère le type sélectionné dans le champ de type du formulaire.
     * 
     * @return Le type sélectionné.
     */
    public String getType() {
        return (String) this.typeBox.getSelectedItem();
    }

    /**
     * Récupère la description saisie dans le champ de texte du formulaire.
     * 
     * @return La description saisie.
     */
    public String getDescription() {
        return this.descriptionArea.getText();
    }

    /**
     * Affiche le formulaire de la vue principale.
     * 
     * @param submitButton Le bouton à ajouter au formulaire pour soumettre les informations.
     */
    public void showForm(JButton submitButton) {
        this.removeAll();
        formPanel.add(submitButton);
        this.add(formPanel);
        this.revalidate();
        this.repaint();
    }

    /**
     * Affiche la vue principale sans projet.
     * 
     * @param monBouton Le bouton à ajouter à la vue principale.
     */
    public void showMainView(JButton monBouton) {
        this.removeAll();
        this.add(new JLabel("Oups ! Vous n'avez pas encore de projet."));
        this.add(monBouton);
        this.revalidate();
        this.repaint();
    }

    /**
     * Affiche la barre de navigation dans la vue principale.
     * 
     * @param navBarVue Le JPanel contenant la barre de navigation à afficher.
     */
    public void showNavBar(JPanel navBarVue) {
        this.removeAll();
        this.setLayout(new BorderLayout());
        this.add(navBarVue, BorderLayout.WEST);
        this.revalidate();
        this.repaint();
    }

    public void showSection(JPanel sectionVue) {
        this.add(sectionVue);
    }

}


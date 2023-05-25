package trellolite.vues;

import javax.swing.*;
import trellolite.modeles.*;
import java.awt.*;

public class PrincipaleVue extends JPanel {
    private JPanel formPanel;

    // Les composants du formulaire
    private JTextField nomField;
    private JComboBox<String> typeBox;
    private JTextArea descriptionArea;

    public PrincipaleVue() {
        // Création du formulaire
        formPanel = new JPanel(new GridLayout(0, 1));
        nomField = new JTextField(10);
        typeBox = new JComboBox<>(new String[]{ "Petite entreprise", "Ressources humaines", "Opérations", "Ingénierie & informatique", "Marketing", "Vente et gestion de la relation client", "Éducation", "Autre" });
        descriptionArea = new JTextArea();

        formPanel.add(new JLabel("Nom:"));
        formPanel.add(nomField);
        formPanel.add(new JLabel("Type:"));
        formPanel.add(typeBox);
        formPanel.add(new JLabel("Description:"));
        formPanel.add(descriptionArea);
    }

    public String getNom() {
        return this.nomField.getText();
    }

    public String getType() {
        return (String) this.typeBox.getSelectedItem();
    }

    public String getDescription() {
        return this.descriptionArea.getText();
    }

    public void showForm(JButton submitButton) {
        this.removeAll();
        formPanel.add(submitButton);
        this.add(formPanel);
        this.revalidate();
        this.repaint();
    }

    public void showMainView(JButton monBouton) {
        this.removeAll();
        this.add(monBouton);
        this.revalidate();
        this.repaint();
    }
}


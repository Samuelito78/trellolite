package trellolite.vues;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * La classe ParametreVue représente une vue pour afficher les paramètres d'un projet.
 * Elle permet à l'utilisateur de modifier le nom du projet, sa description et son type.
 * 
 * @author Nawfel Kerarsi
 */
public class ParametreVue extends JPanel {
    private JPanel headPanel;
    private JPanel bodyPanel;
    private JLabel titlePanel;
    private JLabel subtitlePanel;
    private JTextField nomProjetField;
    private JTextField descriptionProjetField;
    private JComboBox<String> typeProjet;
    private JPanel membresPanel;

    /**
     * Constructeur de la classe ParametreVue.
     * Crée une nouvelle instance de la vue avec les paramètres du projet spécifiés.
     *
     * @param nomProjet             Le nom du projet.
     * @param descriptionProjet     La description du projet.
     * @param typeProjet            Le type du projet.
     * @param submitBtn             Le bouton pour soumettre les modifications.
     */
    public ParametreVue(String nomProjet, String descriptionProjet, JComboBox<String> typeProjet, JButton submitBtn) {
        setLayout(new BorderLayout());
        setOpaque(false);
        this.typeProjet = typeProjet;

        headPanel = new JPanel();
        headPanel.setLayout(new BorderLayout());
        headPanel.setOpaque(false);
        headPanel.setPreferredSize(new Dimension(headPanel.getWidth(), 75));

        bodyPanel = new JPanel();
        bodyPanel.setLayout(new GridBagLayout());
        bodyPanel.setOpaque(false);

        headPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#363636")));

        this.titlePanel = new JLabel("<html><b>Paramètres</b></html>");
        titlePanel.setFont(new Font(titlePanel.getFont().getName(), titlePanel.getFont().getStyle(), 26));
        titlePanel.setForeground(Color.white);

        headPanel.add(titlePanel, BorderLayout.WEST);

        membresPanel = new JPanel();
        membresPanel.setLayout(new BoxLayout(membresPanel, BoxLayout.Y_AXIS));
        membresPanel.setOpaque(false);

        GridBagConstraints gbcReunionPanel = new GridBagConstraints();
        gbcReunionPanel.fill = GridBagConstraints.BOTH;
        gbcReunionPanel.gridx = 0;
        gbcReunionPanel.gridy = 1;
        gbcReunionPanel.weightx = 1.0;
        gbcReunionPanel.weighty = 1.0;

        bodyPanel.add(membresPanel, gbcReunionPanel);

        // Ajout des composants pour le nom du projet
        JPanel labelPanel1 = new JPanel(new BorderLayout());
        labelPanel1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        labelPanel1.setOpaque(false);
        membresPanel.add(labelPanel1);

        JLabel nomProjetLabel = new JLabel("<html><b>Nom du projet</b><html>");
        nomProjetLabel.setForeground(Color.white);
        labelPanel1.add(nomProjetLabel);

        JLabel descProjetLabel = new JLabel("<html><b>Description du projet</b><html>");
        descProjetLabel.setForeground(Color.white);
        descProjetLabel.setPreferredSize(new Dimension(400,0));
        labelPanel1.add(descProjetLabel, BorderLayout.EAST);

        JPanel fieldPanel1 = new JPanel(new BorderLayout());
        fieldPanel1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        fieldPanel1.setOpaque(false);
        membresPanel.add(fieldPanel1);

        nomProjetField = new JTextField();
        nomProjetField.setText(nomProjet);
        nomProjetField.setForeground(Color.white);
        nomProjetField.setBackground(Color.decode("#111111"));
        fieldPanel1.add(nomProjetField);

        descriptionProjetField = new JTextField();
        descriptionProjetField.setText(descriptionProjet);
        descriptionProjetField.setForeground(Color.white);
        descriptionProjetField.setBackground(Color.decode("#111111"));
        descriptionProjetField.setPreferredSize(new Dimension(400,0));
        fieldPanel1.add(descriptionProjetField, BorderLayout.EAST);

        // Ajout des composants pour le type du projet
        JPanel labelPanel2 = new JPanel(new BorderLayout());
        labelPanel2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        labelPanel2.setOpaque(false);
        membresPanel.add(labelPanel2);

        JLabel typeProjetLabel = new JLabel("<html><b>Type du projet</b><html>");
        typeProjetLabel.setForeground(Color.white);
        labelPanel2.add(typeProjetLabel);

        JLabel saveModifLabel = new JLabel("<html><b>Enregistrer les modifications</b><html>");
        saveModifLabel.setForeground(Color.white);
        saveModifLabel.setPreferredSize(new Dimension(400,0));
        labelPanel2.add(saveModifLabel, BorderLayout.EAST);

        JPanel fieldPanel2 = new JPanel(new BorderLayout());
        fieldPanel2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));
        fieldPanel2.setOpaque(false);
        membresPanel.add(fieldPanel2);

        fieldPanel2.add(typeProjet);
        fieldPanel2.add(submitBtn, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        headPanel.add(buttonPanel, BorderLayout.EAST);

        add(headPanel, BorderLayout.NORTH);
        add(bodyPanel, BorderLayout.CENTER);
    }

    /**
     * Obtient la valeur du champ nomProjetField.
     *
     * @return Le nom du projet saisi par l'utilisateur.
     */
    public String getNomProjetField() {
        return nomProjetField.getText();
    }

    /**
     * Obtient la valeur du champ descriptionProjetField.
     *
     * @return La description du projet saisie par l'utilisateur.
     */
    public String getDescProjetField() {
        return descriptionProjetField.getText();
    }

    /**
     * Obtient la valeur sélectionnée dans le champ typeProjet.
     *
     * @return Le type de projet sélectionné par l'utilisateur.
     */
    public String getTypeProjet() {
        return typeProjet.getSelectedItem().toString();
    }

    /**
     * Définit la valeur du champ nomProjetField.
     *
     * @param nomProjet Le nom du projet à afficher.
     */
    public void setNomProjetField(String nomProjet) {
        nomProjetField.setText(nomProjet);
    }

    /**
     * Définit la valeur du champ descriptionProjetField.
     *
     * @param descProjet La description du projet à afficher.
     */
    public void setDescProjetField(String descProjet) {
        descriptionProjetField.setText(descProjet);
    }

    /**
     * Définit la valeur sélectionnée dans le champ typeProjet.
     *
     * @param typeNomProjet Le type de projet à sélectionner.
     */
    public void setTypeProjet(String typeNomProjet) {
        typeProjet.setSelectedItem(typeNomProjet);
    }
}

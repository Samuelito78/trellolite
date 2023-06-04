package trellolite.controleurs;

import trellolite.modeles.Projet;
import trellolite.modeles.Role;
import trellolite.vues.ParametreVue;
import trellolite.vues.ProjetVue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Le contrôleur des paramètres d'un projet.
 * Permet de gérer les interactions et les modifications des paramètres d'un projet.
 * @author Nawfel Kerarsi
 */
public class ParametreControleur {
    ParametreVue parametreVue;
    private Projet projet;
    private ProjetVue projetVue;

    /**
     * Constructeur de la classe ParametreControleur.
     * Initialise les composants de l'interface utilisateur et définit les gestionnaires d'événements.
     *
     * @param projet     Le projet concerné.
     * @param projetVue  La vue du projet.
     */
    ParametreControleur(Projet projet, ProjetVue projetVue) {
        this.projet = projet;
        this.projetVue = projetVue;

        String[] options = {"Petite entreprise", "Ressources humaines", "Opérations", "Ingénierie & informatique", "Marketing", "Vente et gestion de la relation client", "Éducation", "Autre"};
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setSelectedItem(projet.getType());
        JButton submitBtn = new JButton("Enregistrer");
        submitBtn.setForeground(Color.white);
        submitBtn.setBackground(Color.decode("#1a8754"));
        submitBtn.setOpaque(true);
        submitBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        submitBtn.setPreferredSize(new Dimension(400, 0));

        // Gestionnaire d'événement pour le bouton de soumission du formulaire
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                projet.setNom(parametreVue.getNomProjetField());
                projetVue.setProjectButton(parametreVue.getNomProjetField());
                projet.setDescription(parametreVue.getDescProjetField());
                projet.setType(parametreVue.getTypeProjet());
            }
        });

        parametreVue = new ParametreVue(projet.getNom(), projet.getDescription(), comboBox, submitBtn);
    }

    /**
     * @return La vue des paramètres du projet.
     */
    public JPanel getVue() {
        return this.parametreVue;
    }

    /**
     * Met à jour le projet mis en parametre.
     *
     * @param projet Le nouveau projet.
     */
    public void setProjet(Projet projet) {
        this.projet = projet;

        parametreVue.setNomProjetField(projet.getNom());
        parametreVue.setDescProjetField(projet.getDescription());
        parametreVue.setTypeProjet(projet.getType());

        projetVue.setProjectButton(projet.getNom());
    }
}

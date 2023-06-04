package trellolite.controleurs;

import trellolite.modeles.Projet;
import trellolite.modeles.Role;
import trellolite.modeles.Utilisateur;
import trellolite.vues.MembreVue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Le contrôleur des membres d'un projet.
 * Permet de gérer les membres d'un projet, leurs rôles et leurs interactions.
 * @author Samuel Boix-Segura
 */
public class MembreControleur {
    MembreVue membreVue;

    /**
     * Constructeur de la classe MembreControleur.
     * Initialise les composants de l'interface utilisateur et définit les gestionnaires d'événements.
     *
     * @param projet Le projet concerné
     */
    MembreControleur(Projet projet) {
        ArrayList<String> listesutilisateurs = new ArrayList<>();
        ArrayList<JComboBox<String>> listeComboBox = new ArrayList<>();

        // Parcours des utilisateurs du projet
        for (Utilisateur utilisateur : projet.getUtilisateurs()) {
            listesutilisateurs.add(utilisateur.getNom() + " " + utilisateur.getPrenom());

            String[] options = {"Administrateur", "Membre", "Spectateur"};
            JComboBox<String> comboBox = new JComboBox<>(options);
            comboBox.setBorder(new EmptyBorder(0, 0, 0, 20));

            // Sélection du rôle dans la liste déroulante
            switch (utilisateur.getRole()) {
                case administrateur:
                    comboBox.setSelectedIndex(0);
                    comboBox.setEnabled(false);
                    break;
                case membre:
                    comboBox.setSelectedIndex(1);
                    break;
                case spectateur:
                    comboBox.setSelectedIndex(2);
                    break;
            }

            // Gestionnaire d'événement pour la modification du rôle
            comboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String selectedValue = (String) comboBox.getSelectedItem();

                    switch (selectedValue) {
                        case "Administrateur":
                            utilisateur.setRole(Role.administrateur);
                            break;
                        case "Membre":
                            utilisateur.setRole(Role.membre);
                            break;
                        case "Spectateur":
                            utilisateur.setRole(Role.spectateur);
                            break;
                    }
                }
            });

            listeComboBox.add(comboBox);
        }

        membreVue = new MembreVue(listesutilisateurs, listeComboBox);
    }

    /**
     * Récupère la vue des membres du projet.
     *
     * @return La vue des membres du projet.
     */
    public JPanel getVue() {
        return this.membreVue;
    }

    /**
     * Met à jour le projet associé.
     *
     * @param newProjet Le nouveau projet.
     */
    public void setProjet(Projet newProjet) {
        ArrayList<String> listesutilisateurs = new ArrayList<>();
        ArrayList<JComboBox<String>> listeComboBox = new ArrayList<>();

        // Parcours des utilisateurs du nouveau projet
        for (Utilisateur utilisateur : newProjet.getUtilisateurs()) {
            listesutilisateurs.add(utilisateur.getNom() + " " + utilisateur.getPrenom());

            String[] options = {"Administrateur", "Membre", "Spectateur"};
            JComboBox<String> comboBox = new JComboBox<>(options);
            comboBox.setBorder(new EmptyBorder(0, 0, 0, 20));

            // Sélection du rôle dans la liste déroulante
            switch (utilisateur.getRole()) {
                case administrateur:
                    comboBox.setSelectedIndex(0);
                    comboBox.setEnabled(false);
                    break;
                case membre:
                    comboBox.setSelectedIndex(1);
                    break;
                case spectateur:
                    comboBox.setSelectedIndex(2);
                    break;
            }

            // Gestionnaire d'événement pour la modification du rôle
            comboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String selectedValue = (String) comboBox.getSelectedItem();

                    switch (selectedValue) {
                        case "Administrateur":
                            utilisateur.setRole(Role.administrateur);
                            break;
                        case "Membre":
                            utilisateur.setRole(Role.membre);
                            break;
                        case "Spectateur":
                            utilisateur.setRole(Role.spectateur);
                            break;
                    }
                }
            });

            listeComboBox.add(comboBox);
        }

        membreVue.setUtilisateurs(listesutilisateurs, listeComboBox);
    }
}

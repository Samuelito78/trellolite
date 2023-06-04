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

public class MembreControleur {
    MembreVue membreVue;

    MembreControleur(Projet projet) {
        ArrayList<String> listesutilisateurs = new ArrayList<>();
        ArrayList<JComboBox<String>> listeComboBox = new ArrayList<>();

        for (Utilisateur utilisateur : projet.getUtilisateurs()) {
            listesutilisateurs.add(utilisateur.getNom() + " " + utilisateur.getPrenom());

            String[] options = {"Administrateur", "Membre", "Spectateur"};
            JComboBox<String> comboBox = new JComboBox<>(options);
            comboBox.setBorder(new EmptyBorder(0, 0, 0, 20));

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

    public JPanel getVue() {
        return this.membreVue;
    }

    public void setProjet(Projet newProjet) {
        ArrayList<String> listesutilisateurs = new ArrayList<>();
        ArrayList<JComboBox<String>> listeComboBox = new ArrayList<>();

        for (Utilisateur utilisateur : newProjet.getUtilisateurs()) {
            listesutilisateurs.add(utilisateur.getNom() + " " + utilisateur.getPrenom());

            String[] options = {"Administrateur", "Membre", "Spectateur"};
            JComboBox<String> comboBox = new JComboBox<>(options);
            comboBox.setBorder(new EmptyBorder(0, 0, 0, 20));

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
package trellolite.controleurs;

import trellolite.modeles.Projet;
import trellolite.modeles.Reunion;
import trellolite.vues.ReunionVue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Le controleur des réunions d'un projet.
 * Permet de gérer les réunions d'un projet, leur création et leurs interactions.
 * 
 * @author Samuel Boix-Segura
 */
public class ReunionControleur {
    private JButton creeReunionBtn;
    private JButton submitReunionBtn;
    private JButton returnReunionBtn;
    private ReunionVue reunionVue;
    private Reunion reunion;
    private JDialog dialog;
    private ArrayList<JButton> reunionBtnList;
    private Projet projet;

    private String[] couleurs;

    /**
     * Constructeur de la classe ReunionControleur.
     * Initialise les composants de l'interface utilisateur et définit les gestionnaires d'événements.
     *
     * @param projet Le projet concerné.
     */
    public ReunionControleur(Projet projet) {
        this.projet = projet;
        this.couleurs = new String[]{"#7EA6E0", "#EA6B66", "#E8A566", "#97D077", "#9D7EE0", "#49618F", "#833551", "#7D4040"};
        this.creeReunionBtn = new JButton("Nouvelle réunion");
        this.submitReunionBtn = new JButton("Créer la réunion");
        this.returnReunionBtn = new JButton("Retour");
        this.reunionBtnList = new ArrayList<>();

        // Création des boutons de réunion pour les réunions existantes dans le projet
        for (Reunion reunion : projet.getReunions()) {
            JButton reunionBtn = new JButton(reunion.getNom());
            reunionBtnList.add(reunionBtn);
        }

        this.creeReunionBtn.setPreferredSize(new Dimension(160, 40));
        this.creeReunionBtn.setBackground(Color.decode("#FA586A"));
        this.creeReunionBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.creeReunionBtn.setOpaque(true);
        this.creeReunionBtn.setForeground(Color.white);
        reunionVue = new ReunionVue(this.creeReunionBtn, reunionBtnList);

        // Gestionnaire d'événement pour le bouton de création de réunion
        creeReunionBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog = new JDialog();
                reunionVue.afficheForm(submitReunionBtn, returnReunionBtn, dialog);
            }
        });

        // Gestionnaire d'événement pour le bouton de retour
        returnReunionBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        // Gestionnaire d'événement pour le bouton de soumission de réunion
        submitReunionBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reunionBtnList.clear();
                Reunion nouvelleReunion = new Reunion(reunionVue.getNom(), projet);
                projet.ajouterReunion(nouvelleReunion);
                String[] couleurs = {"#7EA6E0", "#EA6B66", "#E8A566", "#97D077", "#9D7EE0", "#49618F", "#833551", "#7D4040"};
                int indexCouleur = 0;

                // Création des boutons de réunion pour les réunions existantes dans le projet
                for (Reunion reunion : projet.getReunions()) {
                    JButton reunionBtn = new JButton("<html><span style='font-size:11px'><b>" + reunion.getNom() + "</b></span><html>");
                    reunionBtn.setBorder(new EmptyBorder(0, 10, 20, 0));
                    reunionBtn.setBackground(Color.decode(couleurs[indexCouleur]));
                    reunionBtn.setForeground(Color.WHITE);
                    reunionBtn.setMargin(new Insets(10, 10, 10, 10));
                    reunionBtn.setHorizontalAlignment(SwingConstants.LEFT);
                    reunionBtn.setVerticalAlignment(SwingConstants.BOTTOM);
                    reunionBtn.setOpaque(true);
                    reunionBtnList.add(reunionBtn);

                    indexCouleur++;
                    if (indexCouleur >= couleurs.length) {
                        indexCouleur = 0;
                    }
                }
                reunionVue.refreshPage(reunionBtnList);
                dialog.dispose();
            }
        });

    }

    /**
     * Met à jour le projet associé au contrôleur et rafraîchit l'affichage des réunions
     * @param projet Le nouveau projet.
     */
    public void setProjet(Projet projet) {
        this.projet = projet;

        reunionBtnList.clear();

        int indexCouleur = 0;

        // Création des boutons de réunion pour les réunions du nouveau projet
        for (Reunion reunion : projet.getReunions()) {
            JButton reunionBtn = new JButton("<html><span style='font-size:11px'><b>" + reunion.getNom() + "</b></span><html>");
            reunionBtn.setBorder(new EmptyBorder(0, 10, 20, 0));
            reunionBtn.setBackground(Color.decode(couleurs[indexCouleur]));
            reunionBtn.setForeground(Color.WHITE);
            reunionBtn.setMargin(new Insets(10, 10, 10, 10));
            reunionBtn.setHorizontalAlignment(SwingConstants.LEFT);
            reunionBtn.setVerticalAlignment(SwingConstants.BOTTOM);
            reunionBtn.setOpaque(true);
            reunionBtnList.add(reunionBtn);

            indexCouleur++;
            if (indexCouleur >= couleurs.length) {
                indexCouleur = 0;
            }
        }

        reunionVue.refreshPage(reunionBtnList);
    }

    /**
     * @return La vue du bouton de création de réunion.
     */
    public JPanel getCreeReunionBtn() {
        return this.reunionVue;
    }
}

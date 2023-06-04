package trellolite.controleurs;

import trellolite.modeles.Projet;
import trellolite.modeles.Tableau;
import trellolite.modeles.Utilisateur;
import trellolite.vues.SectionVue;
import trellolite.vues.TableauVue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Le contrôleur pour la gestion d'un tableau.
 * Cette classe est responsable de la gestion de l'interaction entre le modèle Tableau et la vue TableauVue.
 * Elle crée et configure les boutons nécessaires, crée une instance de TableauVue et associe le tableau à cette vue.
 *
 * @author Nawfel Kerarsi
 */
public class TableauControleur {
    // Déclaration des boutons
    private JButton creeTableauBtn;
    private JButton submitTableauBtn;
    private JButton returnTableauBtn;

    private TableauVue tableauVue;
    private JDialog dialog;

    // Liste des boutons de tableau
    private ArrayList<JButton> tableauBtnList;

    private SectionVue sectionVue;
    private Projet projet;
    Utilisateur utilisateur;

    /**
     * Constructeur de la classe TableauControleur.
     * Initialise les composants de l'interface utilisateur et définit les gestionnaires d'événements.
     *
     * @param projet      Le projet en cours.
     * @param sectionVue  La vue de la section.
     * @param utilisateur L'utilisateur actuel.
     */
    public TableauControleur(Projet projet, SectionVue sectionVue, Utilisateur utilisateur) {
        // Initialisation des attributs
        this.projet = projet;
        this.utilisateur = utilisateur;
        this.creeTableauBtn = new JButton("Nouveau tableau");
        this.submitTableauBtn = new JButton("Créer le tableau");
        this.returnTableauBtn = new JButton("Retour");
        this.tableauBtnList = new ArrayList<JButton>();
        this.sectionVue = sectionVue;

        // Création des boutons pour chaque tableau du projet
        for (Tableau tableau : projet.getTableaux()) {
            JButton tableauBtn = new JButton(tableau.getNom());
            tableauBtnList.add(tableauBtn);
        }

        // Configuration du bouton de création de tableau
        this.creeTableauBtn.setPreferredSize(new Dimension(160, 40));
        this.creeTableauBtn.setBackground(Color.decode("#FA586A"));
        this.creeTableauBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.creeTableauBtn.setOpaque(true);
        this.creeTableauBtn.setForeground(Color.white);

        // Création de la vue des tableaux
        tableauVue = new TableauVue(this.creeTableauBtn, tableauBtnList);

        // Configuration des gestionnaires d'événements
        creeTableauBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Affichage du formulaire de création de tableau
                dialog = new JDialog();
                tableauVue.afficheForm(submitTableauBtn, returnTableauBtn, dialog);
            }
        });

        returnTableauBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fermeture du formulaire de création de tableau
                dialog.dispose();
            }
        });

        submitTableauBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tableauBtnList.clear();
                Tableau nouveauTableau = new Tableau(tableauVue.getNom(), projet);
                projet.ajouterTableau(nouveauTableau);
                String[] couleurs = {"#7EA6E0", "#EA6B66", "#E8A566", "#97D077", "#9D7EE0", "#49618F", "#833551", "#7D4040"};
                int indexCouleur = 0;

                for (Tableau tableau : projet.getTableaux()) {
                    // Creation et personalisation du bouton
                    JButton tableauBtn = new JButton("<html><span style='font-size:11px'><b>" + tableau.getNom() + "</b></span><html>");
                    tableauBtn.setBorder(new EmptyBorder(0, 10, 20, 0));
                    tableauBtn.setBackground(Color.decode(couleurs[indexCouleur]));
                    tableauBtn.setForeground(Color.WHITE);
                    tableauBtn.setMargin(new Insets(10, 10, 10, 10)); // Définir une marge autour du texte du bouton
                    tableauBtn.setHorizontalAlignment(SwingConstants.LEFT); // Aligner le texte à gauche
                    tableauBtn.setVerticalAlignment(SwingConstants.BOTTOM);
                    tableauBtn.setOpaque(true);

                    // Creation objet type ListeControleur
                    ListeControleur listeControleur = new ListeControleur(tableau, sectionVue, utilisateur);
                    // Ecoute de l'événement tableauBtn
                    tableauBtn.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            sectionVue.afficheListe(listeControleur.getCreeListeBtn());
                        }
                    });

                    // Création d'un menu contextuel
                    JPopupMenu popupMenu = new JPopupMenu();
                    popupMenu.setBackground(Color.black);

                    // Ajout d'une option de suppression au menu contextuel
                    JMenuItem deleteItem = new JMenuItem("Supprimer le tableau");
                    deleteItem.setBackground(Color.red);
                    deleteItem.setForeground(Color.white);
                    deleteItem.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // supprimer le tableau du projet
                            projet.supprTableau(tableau);

                            // supprimer le bouton correspondant à ce tableau de la liste tableauBtnList
                            tableauBtnList.remove(tableauBtn);

                            // actualisation de l'interface utilisateur pour afficher la suppression du tableau
                            tableauVue.refreshPage(tableauBtnList);
                        }
                    });

                    popupMenu.add(deleteItem);

                    // Ajout d'un MouseListener à tableauBtn pour afficher le menu contextuel lors d'un clic droit
                    tableauBtn.addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent me) {
                            if (SwingUtilities.isRightMouseButton(me)) {
                                popupMenu.show(me.getComponent(), me.getX(), me.getY());
                            }
                        }
                    });

                    tableauBtnList.add(tableauBtn);
                    indexCouleur++;
                    if (indexCouleur >= couleurs.length) { // Si on a utilisé toutes les couleurs, on revient au début
                        indexCouleur = 0;
                    }
                }

                tableauVue.refreshPage(tableauBtnList);
                dialog.dispose();
            }
        });

    }

    /**
     * Renvoie le bouton "Nouveau tableau" avec la vue des tableaux.
     *
     * @return Le bouton "Nouveau tableau" avec la vue des tableaux.
     */
    public JPanel getCreeTableauBtn() {
        return this.tableauVue;
    }

    /**
     * Définit le projet associé au tableau.
     * Met à jour la liste des boutons de tableau en fonction des tableaux du nouveau projet.
     *
     * @param projet Le nouveau projet associé au tableau.
     */
    public void setProjet(Projet projet) {
        this.projet = projet;

        // on clear la liste de boutons
        tableauBtnList.clear();
        String[] couleurs = {"#7EA6E0", "#EA6B66", "#E8A566", "#97D077", "#9D7EE0", "#49618F", "#833551", "#7D4040"};
        int indexCouleur = 0;

        // Creation de nouveaux boutons pour les tableaux du nouveau projet
        for (Tableau tableau : projet.getTableaux()) {
            // Creation et personalisation du bouton
            JButton tableauBtn = new JButton("<html><span style='font-size:11px'><b>" + tableau.getNom() + "</b></span><html>");
            tableauBtn.setBorder(new EmptyBorder(0, 10, 20, 0));
            tableauBtn.setBackground(Color.decode(couleurs[indexCouleur]));
            tableauBtn.setForeground(Color.WHITE);
            tableauBtn.setMargin(new Insets(10, 10, 10, 10)); // on definit une marge autour du texte du bouton
            tableauBtn.setHorizontalAlignment(SwingConstants.LEFT); // on aligne le texte à gauche
            tableauBtn.setVerticalAlignment(SwingConstants.BOTTOM);
            tableauBtn.setOpaque(true);

            // Creation d'un objet de type ListeControleur
            ListeControleur listeControleur = new ListeControleur(tableau, sectionVue, utilisateur);
            // Ecoute de l'événement tableauBtn
            tableauBtn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sectionVue.afficheListe(listeControleur.getCreeListeBtn());
                }
            });

            // Creation d'un menu contextuel
            JPopupMenu popupMenu = new JPopupMenu();
            popupMenu.setBackground(Color.black);

            // Ajout d'une option de suppression au menu contextuel
            JMenuItem deleteItem = new JMenuItem("Supprimer le tableau");
            deleteItem.setBackground(Color.red);
            deleteItem.setForeground(Color.white);
            deleteItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // supprimer le tableau du projet
                    projet.supprTableau(tableau);

                    // supprimer le bouton correspondant à ce tableau de la liste tableauBtnList
                    tableauBtnList.remove(tableauBtn);

                    // actualiser l'interface utilisateur pour afficher la suppression du tableau
                    tableauVue.refreshPage(tableauBtnList);
                }
            });

            popupMenu.add(deleteItem);

            // Ajout d'un MouseListener à tableauBtn pour afficher le menu contextuel lors d'un clic droit
            tableauBtn.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    if (SwingUtilities.isRightMouseButton(me)) {
                        popupMenu.show(me.getComponent(), me.getX(), me.getY());
                    }
                }
            });

            tableauBtnList.add(tableauBtn);
            indexCouleur++;
            if (indexCouleur >= couleurs.length) { // Si on a utilisé toutes les couleurs, on revient au début
                indexCouleur = 0;
            }
        }
        // Refresh the view
        tableauVue.refreshPage(tableauBtnList);


    }
}

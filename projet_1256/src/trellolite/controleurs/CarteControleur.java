/**
 * Le contrôleur pour la gestion des cartes.
 * Cette classe gère l'interaction entre le modèle Carte et la vue CarteVue.
 * Elle initialise les composants de l'interface utilisateur de la carte et définit les gestionnaires d'événements.
 *
 * @param carte              La carte associée au contrôleur.
 * @param tableau            Le tableau auquel la carte appartient.
 * @param sectionVue         La vue de la section.
 * @param listeVue           La vue de la liste.
 * @param utilisateur        L'utilisateur actuel.
 * @param listeControleur    Le contrôleur de liste.
 *
 * L'auteur de cette classe est Nawfel Kerarsi.
 */
package trellolite.controleurs;

import trellolite.modeles.*;
import trellolite.vues.CarteVue;
import trellolite.vues.ListeVue;
import trellolite.vues.SectionVue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

public class CarteControleur {
    private Carte carte;
    private CarteVue carteVue;
    private ArrayList<String> commentaireList;
    private ArrayList<String> etiquetteList;
    private JButton submitCommentaireBtn;
    private JButton returnCommentaireBtn;
    private JButton submitEtiquetteBtn;
    private JButton returnEtiquetteBtn;
    private JDialog dialog;

    /**
     * Constructeur de la classe CarteControleur.
     * Initialise les composants de l'interface utilisateur de la carte et définit les gestionnaires d'événements.
     *
     * @param carte              La carte associée au contrôleur.
     * @param tableau            Le tableau auquel la carte appartient.
     * @param sectionVue         La vue de la section.
     * @param listeVue           La vue de la liste.
     * @param utilisateur        L'utilisateur actuel.
     * @param listeControleur    Le contrôleur de liste.
     */
    public CarteControleur(Carte carte, Tableau tableau, SectionVue sectionVue, ListeVue listeVue, Utilisateur utilisateur, ListeControleur listeControleur) {
        this.carte = carte;
        this.commentaireList = new ArrayList<>();
        this.etiquetteList = new ArrayList<>();
        this.submitCommentaireBtn = new JButton("Commenter");
        this.returnCommentaireBtn = new JButton("Retour");
        this.submitEtiquetteBtn = new JButton("Étiqueter");
        this.returnEtiquetteBtn = new JButton("Retour");

        JButton crossReturn = new JButton();
        ImageIcon icon = new ImageIcon("src/trellolite/ressources/images/cross.png");
        crossReturn.setIcon(icon);
        crossReturn.setPreferredSize(new Dimension(30, 50));
        crossReturn.setBorder(new EmptyBorder(20, 0, 0, 0));
        crossReturn.setOpaque(false);

        // Gestionnaire d'événement pour le bouton de retour
        crossReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                carteVue.setNomCarteField(carte.getNom());
                carteVue.setDescriptionCarteField(carte.getDescription());
                carteVue.setDateDebut(carte.getDatedebut());
                carteVue.setDateFin(carte.getDatefin());
                sectionVue.afficheListe(listeVue);
            }
        });

        // Ajout des commentaires de la carte à la liste de commentaires
        for (Commentaire commentaire : carte.getComm()) {
            commentaireList.add("<html><b>" + commentaire.getCreateurcomm() + "</b> : " + commentaire.getContenu() + "</html>");
        }

        // Ajout des étiquettes de la carte à la liste d'étiquettes
        for (Etiquette etiquette : carte.getEtiquettes()) {
            etiquetteList.add(etiquette.getNom());
        }

        JButton ajouterCommentaireBtn = new JButton("<html><b>Nouveau commentaire</b><html>");
        ajouterCommentaireBtn.setForeground(Color.white);
        ajouterCommentaireBtn.setBackground(Color.decode("#111111"));
        ajouterCommentaireBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        ajouterCommentaireBtn.setOpaque(true);

        // Gestionnaire d'événement pour le bouton d'ajout de commentaire
        ajouterCommentaireBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog = new JDialog();
                carteVue.afficheForm(submitCommentaireBtn, returnCommentaireBtn, dialog, new JLabel("Nouveau commentaire"));
            }
        });

        // Gestionnaire d'événement pour le bouton de retour du formulaire de commentaire
        returnCommentaireBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        // Gestionnaire d'événement pour le bouton de soumission du formulaire de commentaire
        submitCommentaireBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                Commentaire comm = new Commentaire(utilisateur, carteVue.getNom(), date, carte);
                carte.ajouterComm(comm);
                commentaireList.add("<html><b>" + comm.getCreateurcomm().getNom() + "</b> : " + comm.getContenu() + "</html>");
                dialog.dispose();
                carteVue.setCommentaireList(commentaireList);
                carteVue.refreshPage();
            }
        });

        JButton ajouterEtiquetteBtn = new JButton("<html><b>Nouvelle Etiquette</b><html>");
        ajouterEtiquetteBtn.setForeground(Color.white);
        ajouterEtiquetteBtn.setBackground(Color.decode("#111111"));
        ajouterEtiquetteBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        ajouterEtiquetteBtn.setOpaque(true);
        ajouterEtiquetteBtn.setPreferredSize(new Dimension(210, 0));

        // Gestionnaire d'événement pour le bouton d'ajout d'étiquette
        ajouterEtiquetteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog = new JDialog();
                carteVue.afficheForm(submitEtiquetteBtn, returnEtiquetteBtn, dialog, new JLabel("Nouvelle étiquette"));
            }
        });

        // Gestionnaire d'événement pour le bouton de soumission du formulaire d'étiquette
        submitEtiquetteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Etiquette ett = new Etiquette(carteVue.getNom());
                carte.ajouterEtiq(ett);
                etiquetteList.add(ett.getNom());
                dialog.dispose();
                carteVue.setEtiquetteList(etiquetteList);
                carteVue.refreshPage();
            }
        });


        returnEtiquetteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        JButton submitBtn = new JButton("Enregistrer les modifications");
        submitBtn.setBackground(Color.decode("#1a8754"));
        submitBtn.setForeground(Color.WHITE);
        submitBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        submitBtn.setOpaque(true);
        submitBtn.setPreferredSize(new Dimension(210, 40));

        // Gestionnaire d'événement pour le bouton de soumission du formulaire de modification de la carte
        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                carte.setNom(carteVue.getNomCarteField());
                carte.setDescription(carteVue.getDescriptionCarteField());
                carte.setDatedebut(carteVue.getDebutDate());
                carte.setDatefin(carteVue.getFinDate());
                listeControleur.updateCarteNom(carteVue.getNomCarteField());
                sectionVue.afficheListe(listeVue);
            }
        });

        // Création de la vue de la carte avec les composants configurés
        this.carteVue = new CarteVue(
                carte.getNom(),
                carte.getDescription(),
                carte.getDatedebut(),
                carte.getDatefin(),
                commentaireList,
                etiquetteList,
                tableau.getNom(),
                crossReturn,
                ajouterCommentaireBtn,
                ajouterEtiquetteBtn,
                submitBtn
        );
    }

    /**
     * @return L'instance de la vue de la carte.
     */
    public JPanel getVue() {
        return this.carteVue;
    }
}

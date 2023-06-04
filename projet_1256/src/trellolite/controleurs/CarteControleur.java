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
    Carte carte;
    CarteVue carteVue;
    ArrayList<String> commentaireList;
    ArrayList<String> etiquetteList;
    private JButton submitCommentaireBtn;
    private JButton returnCommentaireBtn;

    private JButton submitEtiquetteBtn;
    private JButton returnEtiquetteBtn;
    private JDialog dialog;
    CarteControleur(Carte carte, Tableau tableau, SectionVue sectionVue, ListeVue listeVue, Utilisateur utilisateur){
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

        crossReturn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                carteVue.setNomCarteField(carte.getNom());
                carteVue.setDescriptionCarteField(carte.getDescription());
                carteVue.setDateDebut(carte.getDatedebut());
                carteVue.setDateFin(carte.getDatefin());
                sectionVue.afficheListe(listeVue);
            }
        });

        for (Commentaire commentaire : carte.getComm()) {
            commentaireList.add("<html><b>"+commentaire.getCreateurcomm()+"</b> : "+commentaire.getContenu()+"</html>");
        }

        for (Etiquette etiquette : carte.getEtiquettes()) {
            etiquetteList.add(etiquette.getNom());
        }

        JButton ajouterCommentaireBtn = new JButton("<html><b>Nouveau commentaire</b><html>");
        ajouterCommentaireBtn.setForeground(Color.white);
        ajouterCommentaireBtn.setBackground(Color.decode("#111111"));
        ajouterCommentaireBtn.setBorder(new EmptyBorder(0,0,0,0));
        ajouterCommentaireBtn.setOpaque(true);


        ajouterCommentaireBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog = new JDialog();
                carteVue.afficheForm(submitCommentaireBtn, returnCommentaireBtn, dialog, new JLabel("Nouveau commentaire"));
            }
        });

        returnCommentaireBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        submitCommentaireBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date date = new Date();
                Commentaire comm = new Commentaire(utilisateur, carteVue.getNom(), date, carte);
                carte.ajouterComm(comm);
                commentaireList.add("<html><b>"+comm.getCreateurcomm().getNom()+"</b> : "+comm.getContenu()+"</html>");
                dialog.dispose();
                carteVue.setCommentaireList(commentaireList);
                carteVue.refreshPage();
            }
        });




        JButton ajouterEtiquetteBtn = new JButton("<html><b>Nouvelle Etiquette</b><html>");
        ajouterEtiquetteBtn.setForeground(Color.white);
        ajouterEtiquetteBtn.setBackground(Color.decode("#111111"));
        ajouterEtiquetteBtn.setBorder(new EmptyBorder(0,0,0,0));
        ajouterEtiquetteBtn.setOpaque(true);
        ajouterEtiquetteBtn.setPreferredSize(new Dimension(210,0));

        ajouterEtiquetteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog = new JDialog();
                carteVue.afficheForm(submitEtiquetteBtn, returnEtiquetteBtn, dialog, new JLabel("Nouvelle étiquette"));
            }
        });

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

        submitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                carte.setNom(carteVue.getNomCarteField());
                carte.setDescription(carteVue.getDescriptionCarteField());
                carte.setDatedebut(carteVue.getDebutDate());
                carte.setDatefin(carteVue.getFinDate());
                sectionVue.afficheListe(listeVue);
            }
        });


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

    public JPanel getVue(){
        return this.carteVue;
    }
}

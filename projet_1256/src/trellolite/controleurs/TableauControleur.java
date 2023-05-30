package trellolite.controleurs;

import trellolite.modeles.Projet;
import trellolite.modeles.Tableau;
import trellolite.vues.TableauVue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TableauControleur {
    private JButton creeTableauBtn;
    private JButton submitTableauBtn;
    private JButton returnTableauBtn;
    private TableauVue tableauVue;
    private JDialog dialog;
    private ArrayList<JButton> tableauBtnList;
    public TableauControleur(Projet projet){
        this.creeTableauBtn = new JButton("Nouveau tableau");
        this.submitTableauBtn = new JButton("Créer le tableau");
        this.returnTableauBtn = new JButton("Retour");
        this.tableauBtnList = new ArrayList<JButton>();

        for (Tableau tableau : projet.getTableaux()) {
            JButton tableauBtn = new JButton(tableau.getNom());
            tableauBtnList.add(tableauBtn);
        }

        this.creeTableauBtn.setPreferredSize(new Dimension(160, 40));
        this.creeTableauBtn.setBackground(Color.decode("#FA586A"));
        this.creeTableauBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.creeTableauBtn.setOpaque(true);
        this.creeTableauBtn.setForeground(Color.white);
        System.out.println("Constructeur TableauControleur");
        tableauVue = new TableauVue(this.creeTableauBtn, tableauBtnList);


        creeTableauBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog = new JDialog();
                tableauVue.afficheForm(submitTableauBtn, returnTableauBtn, dialog);
            }
        });

        returnTableauBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
                    JButton tableauBtn = new JButton("<html><b>"+tableau.getNom()+"</b><html>");
                    tableauBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
                    tableauBtn.setBackground(Color.decode(couleurs[indexCouleur]));
                    tableauBtn.setForeground(Color.WHITE);
                    tableauBtn.setMargin(new Insets(10, 10, 10, 10)); // Définir une marge autour du texte du bouton
                    tableauBtn.setHorizontalAlignment(SwingConstants.LEFT); // Aligner le texte à gauche
                    tableauBtn.setOpaque(true);
                    tableauBtnList.add(tableauBtn);

                    indexCouleur++;
                    if (indexCouleur >= couleurs.length) { // Si nous avons utilisé toutes les couleurs, recommençons depuis le début
                        indexCouleur = 0;
                    }
                }
                tableauVue.refreshPage(tableauBtnList);
                dialog.dispose();
            }
        });

    }

    public JPanel getCreeTableauBtn(){
        return this.tableauVue;
    }
}

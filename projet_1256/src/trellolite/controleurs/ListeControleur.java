package trellolite.controleurs;

import trellolite.modeles.Projet;
import trellolite.modeles.Liste;
import trellolite.modeles.Tableau;
import trellolite.vues.ListeVue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ListeControleur {
    private JButton creeListeBtn;
    private JButton submitListeBtn;
    private JButton returnListeBtn;
    private ListeVue listeVue;
    private JDialog dialog;
    private ArrayList<JPanel> listePanelList;

    public ListeControleur(Tableau tableau){
        this.creeListeBtn = new JButton("Nouvelle liste");
        this.submitListeBtn = new JButton("Créer la liste");
        this.returnListeBtn = new JButton("Retour");
        this.listePanelList = new ArrayList<JPanel>();

        for (Liste liste : tableau.getListe()) {
            JPanel listePanel = new JPanel();
            JLabel listeLabel = new JLabel(liste.getNom());
            listeLabel.setForeground(Color.WHITE);
            listePanel.add(listeLabel);
            listePanelList.add(listePanel);
        }

        this.creeListeBtn.setPreferredSize(new Dimension(160, 40));
        this.creeListeBtn.setBackground(Color.decode("#FA586A"));
        this.creeListeBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.creeListeBtn.setOpaque(true);
        this.creeListeBtn.setForeground(Color.white);
        System.out.println("Constructeur ListeControleur");
        listeVue = new ListeVue(this.creeListeBtn, listePanelList, tableau.getNom());


        creeListeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog = new JDialog();
                listeVue.afficheForm(submitListeBtn, returnListeBtn, dialog);
            }
        });

        returnListeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        submitListeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listePanelList.clear();
                Liste nouvelleListe = new Liste(listeVue.getNom(), tableau);
                tableau.ajouterListe(nouvelleListe);
                String[] couleurs = {"#7EA6E0", "#EA6B66", "#E8A566", "#97D077", "#9D7EE0", "#49618F", "#833551", "#7D4040"};
                int indexCouleur = 0;

                for (Liste liste : tableau.getListe()) {
                    // Creation et personalisation du panel
                    JPanel listePanel = new JPanel();
                    JLabel listeLabel = new JLabel(liste.getNom());
                    listeLabel.setForeground(Color.WHITE);
                    listePanel.setBackground(Color.decode(couleurs[indexCouleur]));
                    listePanel.add(listeLabel);

                    // Créer un menu contextuel
                    JPopupMenu popupMenu = new JPopupMenu();
                    popupMenu.setBackground(Color.black);

                    // Ajouter une option de suppression au menu contextuel
                    JMenuItem deleteItem = new JMenuItem("Supprimer la liste");
                    deleteItem.setBackground(Color.red);
                    deleteItem.setForeground(Color.white);
                    deleteItem.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            // Logique pour supprimer la liste du projet
                            tableau.supprListe(liste);

                            // Supprimer le panel correspondant à cette liste de la liste listePanelList
                            listePanelList.remove(listePanel);

                            // Actualiser l'interface utilisateur pour refléter la suppression de la liste
                            listeVue.refreshPage(listePanelList);
                        }
                    });

                    popupMenu.add(deleteItem);

                    // Ajouter un MouseListener à listePanel pour afficher le menu contextuel lors d'un clic droit
                    listePanel.addMouseListener(new MouseAdapter() {
                        public void mousePressed(MouseEvent me) {
                            if (SwingUtilities.isRightMouseButton(me)) {
                                popupMenu.show(me.getComponent(), me.getX(), me.getY());
                            }
                        }
                    });

                    listePanelList.add(listePanel);
                    indexCouleur++;
                    if (indexCouleur >= couleurs.length) { // Si nous avons utilisé toutes les couleurs, recommençons depuis le début
                        indexCouleur = 0;
                    }
                }

                listeVue.refreshPage(listePanelList);
                dialog.dispose();
            }
        });

    }

    public JPanel getCreeListeBtn(){
        return this.listeVue;
    }
}

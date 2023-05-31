package trellolite.controleurs;

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
    private ListeVue listeVue;
    private JDialog dialog;
    private JDialog dialog2;
    private ArrayList listePanelList;

    private String[] couleurs = {"#757575","#7EA6E0","#67AB66","#7EA6E0", "#EA6B66", "#E8A566", "#97D077", "#9D7EE0", "#49618F", "#833551", "#7D4040"};
    private int indexCouleur = 0;

    public ListeControleur(Tableau tableau) {
        this.creeListeBtn = new JButton("Nouvelle liste");
        JButton submitListeBtn = new JButton("Créer la liste");
        JButton returnListeBtn = new JButton("Retour");

        this.listePanelList = new ArrayList<>();

        for (Liste liste : tableau.getListe()) {
            listePanelList.add(createListePanel(liste, tableau));
        }
        this.creeListeBtn.setPreferredSize(new Dimension(160, 40));
        this.creeListeBtn.setBackground(Color.decode("#FA586A"));
        this.creeListeBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        this.creeListeBtn.setOpaque(true);
        this.creeListeBtn.setForeground(Color.white);

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
                for (Liste liste : tableau.getListe()) {
                    listePanelList.add(createListePanel(liste, tableau));
                }
                listeVue.refreshPage(listePanelList);
                dialog.dispose();
            }
        });
    }

    private JPanel createListePanel(Liste liste, Tableau tableau) {
        JPanel listePanel = new JPanel(new BorderLayout());
        JButton creeCarteBtn = new JButton("Nouvelle carte");

        listePanel.setBackground(Color.decode(couleurs[indexCouleur]));
        listePanel.setBorder(new EmptyBorder(15, 15, 15, 15)); // Add 15px padding to all sides

        JLabel listeLabel = new JLabel("<html><span style='font-size:11px'><b>"+liste.getNom()+"</b></span><html>");
        listeLabel.setForeground(Color.WHITE);
        listeLabel.setFont(new Font(listeLabel.getFont().getName(), Font.BOLD, 11)); // Change font to bold and size to 11px
        listePanel.add(listeLabel, BorderLayout.NORTH); // Add label to the top (north) of the panel


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


        indexCouleur++;
        if (indexCouleur >= couleurs.length) {
            indexCouleur = 0; // Reset color index if we've used all colors
        }

        listePanel.add(creeCarteBtn, BorderLayout.SOUTH);
        return listePanel;
    }
    public JPanel getCreeListeBtn(){
        return this.listeVue;
    }
}

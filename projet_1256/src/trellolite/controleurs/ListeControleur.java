package trellolite.controleurs;

import trellolite.modeles.Carte;
import trellolite.modeles.Liste;
import trellolite.modeles.Tableau;
import trellolite.modeles.Utilisateur;
import trellolite.vues.ListeVue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import trellolite.vues.SectionVue;
import trellolite.vues.TableauVue;

public class ListeControleur {
    private JButton creeListeBtn;
    private JButton carteBtn;
    private ListeVue listeVue;
    private JDialog dialog;
    private JDialog dialog2;
    private ArrayList listePanelList;
    private SectionVue sectionVue;
    private Tableau tableau;
    private String[] couleurs = {"#757575","#7EA6E0","#67AB66","#7EA6E0", "#EA6B66", "#E8A566", "#97D077", "#9D7EE0", "#49618F", "#833551", "#7D4040"};
    private int indexCouleur = 0;
    private Utilisateur utilisateur;

    public ListeControleur(Tableau tableau, SectionVue sectionVue, Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        this.creeListeBtn = new JButton("Nouvelle liste");
        this.sectionVue = sectionVue;
        this.tableau = tableau;
        JButton submitListeBtn = new JButton("Créer la liste");
        JButton returnListeBtn = new JButton("Retour");
        JLabel label = new JLabel("Nom de la liste");

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
                listeVue.afficheForm(submitListeBtn, returnListeBtn, dialog, label);
            }
        });



        returnListeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        submitListeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Liste nouvelleListe = new Liste(listeVue.getNom(), tableau);
                tableau.ajouterListe(nouvelleListe);

                // Ajoutez seulement le panneau pour la nouvelle liste, pas pour chaque liste
                listePanelList.add(createListePanel(nouvelleListe, tableau));

                listeVue.refreshPage(listePanelList);
                dialog.dispose();
            }
        });
    }

    private JPanel createListePanel(Liste liste, Tableau tableau) {
        JPanel listePanel = new JPanel(new BorderLayout());

        JPanel carteBtnPanel = new JPanel();
        GridLayout layout = new GridLayout(0, 1); // Create the layout separately
        carteBtnPanel.setBorder(new EmptyBorder(10, 0, 10, 0));
        layout.setVgap(10); // Set the vertical gap between rows
        carteBtnPanel.setLayout(layout); // Set the layout with a gap
        carteBtnPanel.setOpaque(false);
        JButton creeCarteBtn = new JButton("<html><b>Nouvelle carte</b></html<");

        creeCarteBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
        creeCarteBtn.setOpaque(true);
        creeCarteBtn.setBackground(new Color(255, 255, 255, 30));
        creeCarteBtn.setForeground(Color.white);
        creeCarteBtn.setPreferredSize(new Dimension(0, 30));
        creeCarteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = createCarteDialog(liste, listePanel, carteBtnPanel);
            }
        });

        for (Carte carte : liste.getCartes()) {
            System.out.println("Ajout de "+ carte.getNom()+" dans "+ liste.getNom());
            carteBtn = new JButton(carte.getNom());
            carteBtn.setPreferredSize(new Dimension(Integer.MAX_VALUE, 40));
            carteBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
            carteBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
            carteBtn.setBackground(Color.white);
            carteBtn.setOpaque(true);
            carteBtnPanel.add(carteBtn);
        }

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
            indexCouleur = 0;
        }

        listePanel.add(carteBtnPanel, BorderLayout.CENTER);
        listePanel.add(creeCarteBtn, BorderLayout.SOUTH);

        return listePanel;
    }


    private JDialog createCarteDialog(Liste liste, JPanel listePanel, JPanel carteBtnPanel) {
        JDialog dialog = new JDialog();
        JLabel label = new JLabel("Nom de la carte");
        JButton submitCarteBtn = new JButton("Créer la carte");
        JButton returnCarteBtn = new JButton("Retour");

        submitCarteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Carte nouvelleCarte = new Carte(listeVue.getNom());
                liste.ajouterCarte(nouvelleCarte);

                carteBtn = new JButton(nouvelleCarte.getNom());
                carteBtn.setPreferredSize(new Dimension(Integer.MAX_VALUE, 40));
                carteBtn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
                carteBtn.setBorder(new EmptyBorder(0, 0, 0, 0));
                carteBtn.setBackground(Color.white);
                carteBtn.setOpaque(true);

                CarteControleur carteControleur = new CarteControleur(nouvelleCarte, tableau, sectionVue, listeVue, utilisateur, ListeControleur.this);

                carteBtn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        sectionVue.afficheCarte(carteControleur.getVue());
                    }
                });


                // Créer un menu contextuel pour chaque carteBtn
                JPopupMenu popupMenuCarte = new JPopupMenu();
                JMenuItem deleteItemCarte = new JMenuItem("Supprimer la carte");
                deleteItemCarte.setBackground(Color.red);
                deleteItemCarte.setForeground(Color.white);
                deleteItemCarte.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Logique pour supprimer la carte de la liste
                        liste.supprCarte(nouvelleCarte);

                        // Supprimer le bouton correspondant à cette carte de carteBtnPanel
                        carteBtnPanel.remove(carteBtn);

                        // Actualiser l'interface utilisateur pour refléter la suppression de la carte
                        listeVue.refreshPage(listePanelList);
                    }
                });
                popupMenuCarte.add(deleteItemCarte);

                // Ajouter un MouseListener à carteBtn pour afficher le menu contextuel lors d'un clic droit
                carteBtn.addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent me) {
                        if (SwingUtilities.isRightMouseButton(me)) {
                            popupMenuCarte.show(me.getComponent(), me.getX(), me.getY());
                        }
                    }
                });

                carteBtnPanel.add(carteBtn);

                dialog.dispose();
                listeVue.refreshPage(listePanelList);
            }
        });



        returnCarteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        listeVue.afficheForm(submitCarteBtn, returnCarteBtn, dialog, label);



        return dialog;
    }



    public JPanel getCreeListeBtn(){
        return this.listeVue;
    }

    public void updateCarteNom(String nouveauNom) {
        if (carteBtn != null) {
            carteBtn.setText(nouveauNom);
        }
    }
}

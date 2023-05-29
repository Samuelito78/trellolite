package trellolite.controleurs;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import trellolite.modeles.NavBar;
import trellolite.modeles.NavButton;
import trellolite.modeles.Projet;
import trellolite.vues.NavButtonVue;
import trellolite.vues.ProjetVue;
import trellolite.vues.SectionVue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NavButtonControleur {
    private NavButtonVue navButtonVue;
    private NavBar navBar;
    private SectionVue sectionVue;
    NavButtonControleur(NavBar navBar, SectionVue sectionVue){
        this.sectionVue = sectionVue;
        this.navBar = navBar;
        ArrayList<JButton> navButtonsList = new ArrayList<>();
        ArrayList<NavButton> navButtons = navBar.getButtons();

        for (NavButton button : navButtons) {
            System.out.println(button.getName());
            JButton btn = new JButton(button.getName());
            ImageIcon icon = new ImageIcon(button.getIconURL());
            btn.setIcon(icon);
            btn.setIconTextGap(15);
            btn.setFont(new Font(btn.getFont().getName(), btn.getFont().getStyle(), 13));
            btn.setForeground(Color.white);
            btn.setPreferredSize(new Dimension(260, 40));
            btn.setBorder(new EmptyBorder(0, 25, 0, 0));
            btn.setHorizontalTextPosition(JButton.RIGHT);
            btn.setHorizontalAlignment(JButton.LEFT);
            btn.setBackground(Color.decode("#252526"));
            btn.setOpaque(true);

            // Initialise la couleur du bouton en fonction de son état isSelected
            if(button.isSelected()){
                btn.setBackground(Color.decode("#343435"));
            } else {
                btn.setBackground(Color.decode("#252526")); // Supposons que la couleur GRAY est la couleur d'un bouton non sélectionné.
            }

            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Mettre tous les boutons sur isSelected = false
                    for (NavButton otherButton : navButtons) {
                        otherButton.setSelected(false);
                    }

                    // Mettre ce bouton sur isSelected = true
                    button.setSelected(true);

                    // Mettre à jour les couleurs de tous les boutons en conséquence
                    for (JButton otherBtn : navButtonsList) {
                        if(button.getName().equals(otherBtn.getText())){
                            otherBtn.setBackground(Color.decode("#343435"));
                        } else {
                            otherBtn.setBackground(Color.decode("#252526"));
                        }
                    }

                    switch (button.getName()) {
                        case "Tableau de bord":
                            sectionVue.afficheTableaux();
                            break;
                        case "Activité":
                            sectionVue.afficheActivites();
                            break;
                        case "Membres":
                            sectionVue.afficheMembres();
                            break;
                        case "Réunions":
                            sectionVue.afficheReunions();
                            break;
                        case "Paramètres":
                            sectionVue.afficheParamètres();
                            break;
                        // Autres cas possibles
                        default:
                            // Instructions à exécuter si expression ne correspond à aucun des cas précédents
                            break;
                    }
                }
            });
            navButtonsList.add(btn);
            sectionVue.afficheTableaux();

        }

        this.navButtonVue = new NavButtonVue(navButtonsList);
    }

    public NavButtonVue getVue() {
        return this.navButtonVue;
    }
}

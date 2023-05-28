package trellolite.controleurs;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import trellolite.modeles.NavBar;
import trellolite.modeles.NavButton;
import trellolite.modeles.Projet;
import trellolite.vues.NavButtonVue;
import trellolite.vues.ProjetVue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NavButtonControleur {
    private NavButtonVue navButtonVue;
    private NavBar navBar;
    NavButtonControleur(NavBar navBar){
        this.navBar = navBar;
        ArrayList<JButton> navButtonsList = new ArrayList<>();
        ArrayList<NavButton> navButtons = navBar.getButtons();

        for (NavButton button : navButtons) {
            System.out.println(button.getName());
            JButton btn = new JButton(button.getName());
            btn.setPreferredSize(new Dimension(260, 40));
            btn.setBorder(new EmptyBorder(0, 0, 0, 0));
            btn.setBackground(Color.CYAN);
            btn.setOpaque(true);

            // Initialise la couleur du bouton en fonction de son état isSelected
            if(button.isSelected()){
                btn.setBackground(Color.CYAN);
            } else {
                btn.setBackground(Color.GRAY); // Supposons que la couleur GRAY est la couleur d'un bouton non sélectionné.
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
                            otherBtn.setBackground(Color.CYAN);
                        } else {
                            otherBtn.setBackground(Color.GRAY);
                        }
                    }
                }
            });
            navButtonsList.add(btn);
        }

        this.navButtonVue = new NavButtonVue(navButtonsList);
    }

    public NavButtonVue getVue() {
        return this.navButtonVue;
    }
}

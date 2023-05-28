package trellolite.controleurs;
import trellolite.modeles.NavBar;
import trellolite.modeles.NavButton;
import trellolite.vues.NavBarVue;

import trellolite.vues.PrincipaleVue;
import trellolite.vues.ProjetVue;

import javax.swing.*;

public class NavBarControleur {
    private NavBar navBar;
    private NavBarVue navBarVue;
    private ProjetVue projetVue;
    private NavButtonControleur navButtonControleur;
    public NavBarControleur(ProjetVue projetVue){
        this.projetVue = projetVue;
        navBar = new NavBar();
        NavButton navButton1 = new NavButton("Tableau de bord", "");
        NavButton navButton2 = new NavButton("Activité", "");
        NavButton navButton3 = new NavButton("Membre", "");
        NavButton navButton4 = new NavButton("Réunions", "");
        NavButton navButton5 = new NavButton("Paramètres", "");
        navBar.addButton(navButton1);
        navBar.addButton(navButton2);
        navBar.addButton(navButton3);
        navBar.addButton(navButton4);
        navBar.addButton(navButton5);
        navButtonControleur = new NavButtonControleur(navBar);
        this.navBarVue = new NavBarVue(projetVue.getProjectButton(), navButtonControleur.getVue().getNavButtonPannel());




    }

    public JPanel getVue() {
        return this.navBarVue.getNavBar();
    }
}

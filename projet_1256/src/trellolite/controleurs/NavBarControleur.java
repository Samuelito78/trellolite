package trellolite.controleurs;
import trellolite.modeles.NavBar;
import trellolite.modeles.NavButton;
import trellolite.vues.NavBarVue;

import trellolite.vues.PrincipaleVue;
import trellolite.vues.ProjetVue;
import trellolite.vues.SectionVue;

import javax.swing.*;

public class NavBarControleur {
    private NavBar navBar;
    private NavBarVue navBarVue;
    private ProjetVue projetVue;
    private NavButtonControleur navButtonControleur;
    public NavBarControleur(ProjetVue projetVue, SectionVue sectionVue){
        this.projetVue = projetVue;
        navBar = new NavBar();
        NavButton navButton1 = new NavButton("Tableau de bord", "src/trellolite/ressources/images/iconTable.png", true);
        NavButton navButton2 = new NavButton("Activité", "src/trellolite/ressources/images/iconReturn.png");
        NavButton navButton3 = new NavButton("Membres", "src/trellolite/ressources/images/iconUsers.png");
        NavButton navButton4 = new NavButton("Réunions", "src/trellolite/ressources/images/iconMic.png");
        NavButton navButton5 = new NavButton("Paramètres", "src/trellolite/ressources/images/iconGear.png");
        navBar.addButton(navButton1);
        navBar.addButton(navButton2);
        navBar.addButton(navButton3);
        navBar.addButton(navButton4);
        navBar.addButton(navButton5);
        navButtonControleur = new NavButtonControleur(navBar, sectionVue);
        this.navBarVue = new NavBarVue(projetVue, navButtonControleur.getVue());

    }

    public JPanel getVue() {
        return this.navBarVue;
    }
}

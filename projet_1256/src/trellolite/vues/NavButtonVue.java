package trellolite.vues;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NavButtonVue extends JPanel {
    private JPanel navButtonPannel;
    private ArrayList<JButton> navButtons;
    public NavButtonVue(ArrayList<JButton> navButtons){
        this.navButtons = navButtons;
        this.navButtonPannel = new JPanel();
        this.navButtonPannel.setBackground(Color.GRAY);
        for (JButton button : navButtons) {
            navButtonPannel.add(button);
        }
    }

    public JPanel getNavButtonPannel() {
        return this.navButtonPannel;
    }
}

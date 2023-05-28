package trellolite.vues;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NavButtonVue extends JPanel {
    public NavButtonVue(ArrayList<JButton> navButtons){
        setBackground(Color.GRAY);
        for (JButton button : navButtons) {
            add(button);
        }
    }
}

package trellolite.vues;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NavButtonVue extends JPanel {
    public NavButtonVue(ArrayList<JButton> navButtons){
        setBackground(Color.decode("#252526"));
        for (JButton button : navButtons) {
            add(button);
        }
    }
}

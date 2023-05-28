package trellolite.vues;
import trellolite.modeles.Projet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Image;
public class ProjetVue extends JPanel{
    private JButton projectButton;
    public ProjetVue(JButton projectButton) {
        setLayout(new BorderLayout());
        setBackground(Color.GREEN);
        add(projectButton);
    }

    public void setProjet(Projet projet) {
    }

}

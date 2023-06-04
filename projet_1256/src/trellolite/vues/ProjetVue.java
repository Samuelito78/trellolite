package trellolite.vues;
import trellolite.modeles.Projet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Image;
public class ProjetVue extends JPanel{
    private JButton projectButton;
    public ProjetVue(JButton projectButton) {
        this.projectButton = projectButton;
        setLayout(new BorderLayout());
        setBackground(Color.decode("#252526"));
        add(projectButton);
    }

    public void setProjet(Projet projet) {

    }

    public void setProjectButton(String nomProjet){
        projectButton.setText("<html><b>"+nomProjet+"<b><html>");
    }

}

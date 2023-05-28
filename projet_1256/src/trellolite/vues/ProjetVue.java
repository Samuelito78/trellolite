package trellolite.vues;
import trellolite.modeles.Projet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Image;
public class ProjetVue extends JPanel{
    private JPanel projectPannel;
    private JButton projectButton;
    public ProjetVue(JButton projectButton) {
        this.projectPannel = new JPanel();
        this.projectPannel.setLayout(new BorderLayout());
        this.projectPannel.setBackground(Color.GREEN);
        projectPannel.add(projectButton);
        this.add(projectPannel);
    }

    public void setProjet(Projet projet) {

    }

    public JPanel getProjectButton() {
        return this.projectPannel;
    }
}

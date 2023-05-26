package trellolite.vues;
import trellolite.modeles.Projet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Image;
public class ProjetVue extends JPanel{
    private JButton nomLabel;
    public ProjetVue() {
        nomLabel = new JButton();
        nomLabel.setBorder(new EmptyBorder(15, 10,15,10));
        nomLabel.setBackground(Color.RED);
        nomLabel.setOpaque(true);
        nomLabel.setPreferredSize(new Dimension(210, 70));
        ImageIcon icon = new ImageIcon("src/trellolite/ressources/images/logo.jpg");
        Image originalImage = icon.getImage();
        Image resizedImage = originalImage.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon resizedicon = new ImageIcon(resizedImage);
        nomLabel.setIcon(resizedicon);
        nomLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
        nomLabel.setHorizontalAlignment(SwingConstants.LEFT);

        this.add(nomLabel);
    }

    public void setProjet(Projet projet) {
        nomLabel.setText(projet.getNom());
    }
}

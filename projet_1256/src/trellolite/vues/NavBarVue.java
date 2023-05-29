package trellolite.vues;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Color;
public class NavBarVue extends JPanel{
    private JPanel projectButton;
    public NavBarVue(JPanel projectButton, JPanel navButtonPannel){
        ImageIcon originalIcon = new ImageIcon("src/trellolite/ressources/images/trelite.png");
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(120, 24, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(260, 0));
        setBackground(Color.decode("#252526"));
        add(projectButton, BorderLayout.SOUTH);

        JLabel label = new JLabel(resizedIcon);
        label.setBorder(new EmptyBorder(20,0,20,0));
        add(label, BorderLayout.NORTH);
        add(navButtonPannel, BorderLayout.CENTER);


    }

}
